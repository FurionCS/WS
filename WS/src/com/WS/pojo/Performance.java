package com.WS.pojo;

import java.io.Serializable;

public class Performance implements Serializable{
	private int agid;
	private String agname;
	private String agwxnum;
	private double money;
	private double team;
	private double personmoney;
	private double moneyperson; //个人业绩
	public double getMoneyperson() {
		return moneyperson;
	}

	public void setMoneyperson(double moneyperson) {
		this.moneyperson = moneyperson;
	}
	private int agpid;
	
	public Performance() {
		super();
	}
	public Performance(int agid, String agname, String agwxnum, double money,
			double team, double personmoney, double moneyperson, int agpid) {
		super();
		this.agid = agid;
		this.agname = agname;
		this.agwxnum = agwxnum;
		this.money = money;
		this.team = team;
		this.personmoney = personmoney;
		this.moneyperson = moneyperson;
		this.agpid = agpid;
	}

	public int getAgid() {
		return agid;
	}
	public void setAgid(int agid) {
		this.agid = agid;
	}
	public String getAgname() {
		return agname;
	}
	public void setAgname(String agname) {
		this.agname = agname;
	}
	public String getAgwxnum() {
		return agwxnum;
	}
	public void setAgwxnum(String agwxnum) {
		this.agwxnum = agwxnum;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getTeam() {
		return team;
	}
	public void setTeam(double team) {
		this.team = team;
	}
	public double getPersonmoney() {
		return personmoney;
	}
	public void setPersonmoney(double personmoney) {
		this.personmoney = personmoney;
	}
	public int getAgpid() {
		return agpid;
	}
	public void setAgpid(int agpid) {
		this.agpid = agpid;
	}
	

}
