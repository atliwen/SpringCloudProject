package com.test;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToMap
{
	ObjectMapper jsonMapper = new ObjectMapper();

	@Test
	public void Test_jsonMap() throws Exception
	{
		String json = "{ \"status\":\"0\", \"message\":\"ok\", \"total\":\"9628\", \"results\":[{ \"name\":\"外婆家(湖滨店)\"}]}";

	}

}
