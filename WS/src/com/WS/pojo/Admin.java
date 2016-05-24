package com.WS.pojo;

import java.util.Date;
/**
 * 管理员表
 * @author cs
 *
 */
public class Admin {
	private int adid;               //管理员id
	private String adname;          //管理员名字
	private String adpassword;      //管理员密码
	private String adtel;           //管理员电话
	private Date lasttime;          //管理员最后登入时间
	private int power;              //管理员权限等级
	public Admin() {
		super();
	}
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdpassword() {
		return adpassword;
	}
	public void setAdpassword(String adpassword) {
		this.adpassword = adpassword;
	}
	public String getAdtel() {
		return adtel;
	}
	public void setAdtel(String adtel) {
		this.adtel = adtel;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
