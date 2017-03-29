import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Menu, Icon, Row, Col} from 'antd';

const SubMenu = Menu.SubMenu;

const Header = (props) => {
  return (
    <div className="ant-layout-header">
      <Row>
        <Col span="2" push="22">
          <Menu mode="horizontal">
            <SubMenu key="user" title={<span> <Icon type="user"/> <span>用户</span></span>}>
              <Menu.Item key="2">设置</Menu.Item>
              <Menu.Item key="1"><a href="j_spring_security_logout">退出登录</a></Menu.Item>
            </SubMenu>
          </Menu>
        </Col>
      </Row>
    </div>
  );
};

Header.propTypes = {};

export default Header;
