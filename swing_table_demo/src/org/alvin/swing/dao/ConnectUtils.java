/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author tangzhichao
 */
public class ConnectUtils {

    //单例
    private static final ConnectUtils instance = new ConnectUtils();
    //批量上限
    private static final int BATCH_SIZE = 100;

    private ConnectUtils() {
        try {
            //加载配置
            this.env.load(this.getClass().getResourceAsStream("/jdbc.properties"));
            Class.forName(this.env.getProperty("jdbc.driverClass"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("加载配置失败。。。");
            System.exit(0);
        }
    }

    private Properties env = new Properties();

    public static ConnectUtils getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        String url = this.env.getProperty("jdbc.url");
        String user = this.env.getProperty("jdbc.user");
        String password = this.env.getProperty("jdbc.password");
        return DriverManager.getConnection(url, user, password);
    }

    //执行单行语句
    public int execute(String sql, Object[] params) throws SQLException {
        try (Connection conn = this.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                setParameters(ps, params);
                conn.setAutoCommit(false);
                int res = ps.executeUpdate();
                conn.commit();
                return res;
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    //批量执行sql
    public int[] executeBatch(String sql, List<Object[]> paramsList) throws SQLException {
        int[] res = new int[paramsList.size()];
        try (Connection conn = this.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int i = 0; i < paramsList.size(); i++) {
                    if (i != 0 && i % BATCH_SIZE == 0) {
                        int[] tmpRes = ps.executeBatch();
                        System.arraycopy(tmpRes, 0, res, i - tmpRes.length, tmpRes.length);
                    }
                    this.setParameters(ps, paramsList.get(i));
                    ps.addBatch();
                }
                int[] tmpRes = ps.executeBatch();
                System.arraycopy(tmpRes, 0, res, res.length - tmpRes.length, tmpRes.length);
                conn.commit();
                return res;
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    //返回单个列
    public Object queryScalar(String sql, Object[] params) throws SQLException {
        try (Connection conn = this.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                setParameters(ps, params);
                try (ResultSet res = ps.executeQuery()) {
                    if (res.next()) {
                        return res.getObject(1);
                    }
                    return null;
                }
            } catch (SQLException ex) {
                throw ex;
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * 返回一个对象
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public Map<String, Object> queryObj(String sql, Object[] params) throws SQLException {
        try (Connection conn = ConnectUtils.getInstance().getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet res = ps.executeQuery()) {
                    ResultSetMetaData rsmd = res.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    Map<String, Object> map = new HashMap<String, Object>();
                    if (res.next()) {
                        for (int i = 0; i < columnCount; i++) {
                            String key = rsmd.getColumnName(i);
                            Object value = res.getObject(key);
                            map.put(key, value);
                        }
                    }
                    return map;
                }
            }
        }
    }

    /**
     * 返回对象列表
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> queryList(String sql, Object[] params) throws SQLException {
        try (Connection conn = ConnectUtils.getInstance().getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet res = ps.executeQuery()) {
                    List<Map<String, Object>> list = new ArrayList<>();
                    ResultSetMetaData rsmd = res.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    Map<String, Object> map = new HashMap<String, Object>();
                    while (res.next()) {
                        for (int i = 0; i < columnCount; i++) {
                            String key = rsmd.getColumnName(i);
                            Object value = res.getObject(key);
                            map.put(key, value);
                        }
                        list.add(map);
                    }
                    return list;
                }
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object[] params) throws SQLException {
        if (params == null) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }

}
