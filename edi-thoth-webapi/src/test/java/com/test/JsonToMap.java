//package com.test;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//
//public class JsonToMap
//{
//	ObjectMapper jsonMapper = new ObjectMapper();
//
//	@Test
//	public void Test_jsonMap() throws Exception
//	{
//		String json = "{ \"status\":\"0\", \"message\":\"ok\", \"total\":\"9628\", \"results\":[{ \"name\":\"外婆家(湖滨店)\"}]}";
//
//	}
//
//	@Test
//	public void  test()
//	{
//		String uri ="http://10.10.6.55/edi/edithothparent/";
//		while(uri.endsWith("/")) {
//			uri = uri.substring(0, uri.length() - 1);
//		}
//
//		int index = uri.indexOf("://");
//		if(index > 0 && !uri.substring(index + "://".length()).contains("/")) {
//			uri = uri + "/";
//		}
//
//		System.out.println(uri);
//
//	}
//	public String setUri(String uri) {
//		while(uri.endsWith("/")) {
//			uri = uri.substring(0, uri.length() - 1);
//		}
//
//		int index = uri.indexOf("://");
//		if(index > 0 && !uri.substring(index + "://".length()).contains("/")) {
//			uri = uri + "/";
//		}
//
//		return uri;
//	}
//
//
//}
