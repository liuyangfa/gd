package org.gateway.gd.domain;

import java.io.Serializable;

/**
 * 系统日志权限
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
public class Systemlog implements Serializable {

	// ---------------field------------------------
	private Long id;
	private String ipAddr; // ip地址
	private String host;// 主机名
	private String path;// 请求路径
	private String date; // 请求的时间
	private String param;// 请求的参数
	private User user;	 //操作用户

	// ================setter and getter method==============================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
