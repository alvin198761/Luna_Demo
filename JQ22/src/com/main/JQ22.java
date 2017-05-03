package com.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.utils.SpiderUtil;

public class JQ22 {

	private static String url = "http://www.jq22.com/";

	public static void main(String[] args) throws Exception {
		login();
	}


	private static Response response;
	public static void login() throws Exception{
		//主页
		response = SpiderUtil.getResponse(url, null);
		Map<String, String> map = new HashMap<String, String>();
		map.put("em", "2509024314@qq.com");
		map.put("pw", "wasd1234");
		//登陆
		response = SpiderUtil.getResponse(url + "emdl.aspx", null, map, Method.POST);
		//cookies
		Map<String, String> cookies = response.cookies();
		//个人中心  http://www.jq22.com/signIn.aspx   ***__VIEWSTATE***__VIEWSTATEGENERATOR***__EVENTVALIDATION***
		response = SpiderUtil.getResponse(url + "signIn.aspx", null, cookies);
		Document doc = Jsoup.parse(response.parse().html());
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("Button1", "签 到");
		mp.put("__VIEWSTATE", doc.select("input[name=__VIEWSTATE]").val());
		mp.put("__VIEWSTATEGENERATOR", doc.select("input[name=__VIEWSTATEGENERATOR]").val());
		mp.put("__EVENTVALIDATION", doc.select("input[name=__EVENTVALIDATION]").val());
		//签到signIn.aspx
		response = SpiderUtil.getResponse(url + "signIn.aspx", null, cookies, mp, Method.POST);
//		writerHTMLtoFile(response.parse().html(), "C:/Users/Administrator/Desktop/sucai.html");
	}

	public static void writerHTMLtoFile(String entity, String pathName) {
		try {
			FileWriter writer = new FileWriter(pathName, false);
			writer.write(entity);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
