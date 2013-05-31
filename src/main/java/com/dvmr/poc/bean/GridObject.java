package com.dvmr.poc.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class GridObject {
	private String title, duration;
	private int percentComplete;
	private boolean effortDriven;
	private String start, finish;

	
	public GridObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GridObject(String title, String duration, int percentComplete,
			String start, String finish, boolean effortDriven) {
		this.title = title;
		this.duration = duration;
		this.percentComplete = percentComplete;
		this.start = start;
		this.finish = finish;
		this.effortDriven = effortDriven;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getPercentComplete() {
		return percentComplete;
	}

	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}

	public boolean isEffortDriven() {
		return effortDriven;
	}

	public void setEffortDriven(boolean effortDriven) {
		this.effortDriven = effortDriven;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public JSONObject toJson() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("title", title);
		obj.put("duration", duration);
		obj.put("percentComplete", new Integer(percentComplete));
		obj.put("start", start);
		obj.put("finish", finish);
		obj.put("effortDriven", new Boolean(effortDriven));
		return obj;
	}

}
