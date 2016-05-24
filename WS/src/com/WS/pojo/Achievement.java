package com.WS.pojo;

import java.util.Date;
/**
 * 
 * @业绩表
 * @author cs
 *
 */
public class Achievement {
	private int aid;       //业绩id
	private Agent agent;  //总代ID
	private double money;  //业绩
	private double proportion;  //比例
	private Date lasttime;      //最新更新时间
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getProportion() {
		return proportion;
	}
	public void setProportion(double proportion) {
		this.proportion = proportion;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	
}
