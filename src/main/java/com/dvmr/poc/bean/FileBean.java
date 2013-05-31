package com.dvmr.poc.bean;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 
 * @author vreddy.fp
 *
 */
@XmlRootElement
public class FileBean {
	String filename;
	long size;
	String url;
	String contentType;
	Map<String, String> formFieldsMap;

	public FileBean(String filename, long size, String url, String contentType) {
		this.filename = filename;
		this.size = size;
		this.url = url;
		this.contentType = contentType;
	}

	public FileBean() {
	}

	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Map<String, String> getFormFieldsMap() {
		return formFieldsMap;
	}

	public void setFormFieldsMap(Map<String, String> formFieldsMap) {
		this.formFieldsMap = formFieldsMap;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("name", filename);
		obj.put("size", new Long(size));
		obj.put("url", url);
		obj.put("contentType", contentType);
		return obj;
	}
	
}
