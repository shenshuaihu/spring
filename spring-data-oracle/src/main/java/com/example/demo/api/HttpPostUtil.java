package com.example.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class HttpPostUtil {


	public static String post(Map<String, String> parmMap, String strurl) {
		String result = null;
		try {
//			URL url = new URL(strurl);
//			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			HttpClient client = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(strurl);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			if (parmMap != null && !parmMap.isEmpty()) {
				Set<String> keys = parmMap.keySet();
				for (String key : keys) {
					params.add(new BasicNameValuePair(key, parmMap.get(key)));
				}
			}
			httppost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
			httppost.setConfig(RequestConfig.DEFAULT);
			HttpResponse response = client.execute(httppost);
			Reader reader = new InputStreamReader(response.getEntity().getContent(), "utf-8");
			result = IOUtils.toString(reader);
		} catch (Exception e) {
			log.error("连接云平台:请求异常,参数" + parmMap + "请求地址" + strurl, e);
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		//String post = HttpPostUtil.post(null, "http://www.mftcc.cn/home.html");

		Map<String, String> map = new HashMap<>();
		String url = "https://parents.yhkdz.cn/ConsumeInfo/Statistics";
		map.put("Cookie", "openidValue=openid=o2Q-kwd36fAlz0yEMIUHbRNFevcM; parentClient=platform=1" +
				"&SchoolID=67" +
				"&SchoolName=%e8%a5%84%e5%9f%8e%e5%8e%bf%e5%ae%9e%e9%aa%8c%e9%ab%98%e4%b8%ad" +
				"&openid=o2Q-kwd36fAlz0yEMIUHbRNFevcM" +
				"&StudentNum=16977" +
				"&IPAddress=tGt5URfb8ZUzHGqPOUF2kQ==" +
				"&LoginName=d3g6DD8nF/w=" +
				"&DatabasePass=SG4mbANR95Q=" +
				"&ConnectionName=BhdA2yeowXXJBcpceT6y9NblJtVuc+VW");
		try {
			//String post =	HttpClientUtil.sendPost(map, url);
			String post =	postMap(url, map, map);
			System.out.println(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String postMap(String url,Map<String,String> headerMap,Map<String, String> contentMap) {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		List<NameValuePair> content = new ArrayList<NameValuePair>();
		Iterator iterator = contentMap.entrySet().iterator();           //将content生成entity
		while(iterator.hasNext()){
			Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
			content.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
		}
		CloseableHttpResponse response = null;
		try {
			Iterator headerIterator = headerMap.entrySet().iterator();          //循环增加header
			while(headerIterator.hasNext()){
				Map.Entry<String,String> elem = (Map.Entry<String, String>) headerIterator.next();
				post.addHeader(elem.getKey(),elem.getValue());
			}
			if(content.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(content,"UTF-8");
				post.setEntity(entity);
			}
			response = httpClient.execute(post);            //发送请求并接收返回数据
			if(response != null && response.getStatusLine().getStatusCode() == 200)
			{
				HttpEntity entity = response.getEntity();       //获取response的body部分
				result = EntityUtils.toString(entity);          //读取reponse的body部分并转化成字符串
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				httpClient.close();
				if(response != null)
				{
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
