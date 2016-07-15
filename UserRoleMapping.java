package com.springmvcexample.model;

public class UserRoleMapping {
	
	private int userid;
	private int roleid;
	private String username;
	private String rolename;
	private int mappingid;
	private String useremailid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public int getMappingid() {
		return mappingid;
	}
	public void setMappingid(int mappingid) {
		this.mappingid = mappingid;
	}
	public String getUseremailid() {
		return useremailid;
	}
	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}
	
}
