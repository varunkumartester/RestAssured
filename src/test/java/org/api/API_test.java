 package org.api;

import org.codehaus.groovy.ast.builder.AstStringCompiler;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class API_test {
	public static void main(String[] args) {
		
		
		RestAssured.baseURI="http://www.c2ta.co.in";
		
		
		//post method
		
		 RequestSpecification v = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "\"title\": \"Project Manager\" ,\r\n"
				+ "\"body\": \"selenium\",\r\n"
				+ "\"author\": \"joshi\"\r\n"
				+ "}\r\n"
				+ "").log().all();
		
		String m = v.post("/api/insert.php").getBody().asString();
		
		System.out.println(m);
		
		
				
		
		
		
		//put method
		
		RequestSpecification x = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "        \"id\": \"1212\",\r\n"
				+ "        \"title\": \"web\",\r\n"
				+ "        \"body\": \"Selenium\",\r\n"
				+ "        \"author\": \"roshan\"\r\n"
				+ "    }\r\n"
				+ "").log().all();
		
		Response o = x.put("/api/update.php");
		System.out.println(o.getBody().asString());
		
		 
		
		
		//get method

		Response response = RestAssured.get("/api/read.php?id=1212");
		
		
		String r = response.getBody().asPrettyString();
		
		System.out.println(r);
		
	}
}
