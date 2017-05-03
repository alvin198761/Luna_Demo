package com.utils;

import java.net.Proxy;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;



public class SpiderUtil {
    public static Response getJustResponse(String url, Proxy proxy) {
        Connection con = null;
        try {
            con = Jsoup.connect(url);
        } catch (Exception e) {
            return null;
        }
        con.referrer(url);
        con.timeout(600000);
        con.method(Method.GET);
//        con.followRedirects(false);
        con.ignoreHttpErrors(true);
        con.ignoreContentType(true);
        con.header("Connection", "keep-alive");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        con.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        int x = 0;
        Response res = null;
        while (x < 3) {
            try {
                res = con.execute();
                break;
            } catch (Exception e) {
                x++;
                sleep(5);  
                System.err.println(url + " >> " + proxy + " >> " + x + " >> " + e.getMessage());
            }
        }
        return res;
    }


    public static Response getResponse(String url, Proxy proxy) {
        Connection con = null;
        try {
            con = Jsoup.connect(url);
            
        } catch (Exception e) {
            return null;
        }
        con.referrer(url);
        con.timeout(30000);
        con.method(Method.GET);
        con.ignoreHttpErrors(true);
        con.ignoreContentType(true);
        con.header("Connection", "keep-alive");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        con.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        int x = 0;
        Response res = null;
        while (x < 5) {
            try {
                res = con.execute();
                int sc = res.statusCode();  
                String sm = res.statusMessage();
                if (sc == 404 || sc >= 500) {
                    System.err.println(url + " >> " + proxy + " >> " + sc + " >> " + sm);
                    return null;
                }
                break;
            } catch (Exception e) {
                x++;
                sleep(5);  
                System.err.println(url + " >> " + proxy + " >> " + x + " >> " + e.getMessage());
                res = null;
            }
        }
        return res;
    }

    public static Response getResponse(String url, Proxy proxy, Map<String, String> cookies) {
        Connection con = null;
        try {
            con = Jsoup.connect(url);
        } catch (Exception e) {
            return null;
        }
        con.referrer(url);
        con.timeout(600000);
        con.cookies(cookies);
        con.method(Method.GET);
        con.ignoreHttpErrors(true);
        con.ignoreContentType(true);
        con.header("Connection", "keep-alive");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        con.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        int x = 0;
        Response res = null;
        while (x < 5) {
            try {
                res = con.execute();
                int sc = res.statusCode();
                String sm = res.statusMessage();
                if (sc == 404 || sc >= 500) {
                    System.err.println(url + " >> " + proxy + " >> " + sc + " >> " + sm);
                    return null;
                }
                break;
            } catch (Exception e) {
                x++;
                sleep(5);
                System.err.println(url + " >> " + proxy + " >> " + x + " >> " + e.getMessage());
            }
        }
        return res;
    }

    public static Response getResponse(String url, Proxy proxy, Map<String, String> data, Method method) {
        Connection con = null;
        try {
            con = Jsoup.connect(url);
        } catch (Exception e) {
            return null;
        }
        con.data(data);
        con.referrer(url);
        con.method(method);
        con.timeout(600000);
        con.ignoreHttpErrors(true);
        con.ignoreContentType(true);
        con.header("Connection", "keep-alive");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        con.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        Response res = null;
        int x = 0;
        while (x < 5) {
            try {
                res = con.execute();
                int sc = res.statusCode();
                String sm = res.statusMessage();
                if (sc == 404 || sc >= 500) {
                    System.err.println(data + " >> " + proxy + " >> " + sc + " >> " + sm);
                    return null;
                }
                break;
            } catch (Exception e) {
                x++;
                sleep(5);
                System.err.println(data + " >> " + proxy + " >> " + x + " >> " + e.getMessage());
            }
        }
        return res;
    }

    public static Response getResponse(String url, Proxy proxy, Map<String, String> data, Map<String, String> cookies, Method method) {
        Connection con = null;
        try {
            con = Jsoup.connect(url);
        } catch (Exception e) {
            return null;
        }
        con.data(data);
        con.referrer(url);
        con.method(method);
        con.timeout(600000);
        con.cookies(cookies);
        con.ignoreHttpErrors(true);
        con.ignoreContentType(true);
        con.header("Connection", "keep-alive");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        con.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        Response res = null;
        int x = 0;
        while (x < 5) {
            try {
                res = con.execute();
                int sc = res.statusCode();
                String sm = res.statusMessage();
                if (sc == 404 || sc >= 500) {
                    System.err.println(data + " >> " + proxy + " >> " + sc + " >> " + sm);
                    return null;
                }
                break;
            } catch (Exception e) {
                x++;
                sleep(5);
                System.err.println(data + " >> " + proxy + " >> " + x + " >> " + e.getMessage());
            }
        }
        return res;
    }

    static void sleep(int x) {
        try {
            Thread.sleep(x * 1000);
        } catch (Exception e) {
        }
    }


}
