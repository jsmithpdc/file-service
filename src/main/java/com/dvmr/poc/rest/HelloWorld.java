package com.dvmr.poc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.dvmr.poc.bean.GridObject;
import com.dvmr.poc.bean.Todo;

@Path("/helloworld")
public class HelloWorld {
	

	public HelloWorld() {
	}

	// Specifies that the method processes HTTP GET requests
	@GET
	@Produces("text/plain")
	public String sayHello() {
		return "Hello World!";
	}

	// Specifies that the method processes HTTP GET requests
	@GET
	@Path("sayHelloWithName")
	@Produces("text/plain")
	public String sayHelloWithName(@QueryParam("name") String name) {
		return String.format("Hello %s", name.toUpperCase());
	}
	
	@GET
	@Path("getTodoXml")
	@Produces( { MediaType.APPLICATION_JSON})
	public Todo getHTML() {
		Todo todo = new Todo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo");
		return todo;
	}
	
	@GET
	@Path("getGridData")
	@Produces( { MediaType.APPLICATION_JSON})
	public JSONArray getGridByJson() throws JSONException{
		JSONArray arr = new JSONArray();
		for(int i=0; i< 100; i++){
		    arr.put(new GridObject("Task "+i, "5 days", i * 1, "01/01/2009", "01/05/2009", i % 5==0).toJson());
		  }
        return arr;
	}
	
}
