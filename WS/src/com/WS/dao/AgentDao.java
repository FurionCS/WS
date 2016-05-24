package com.WS.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.WS.pojo.Agent;
import com.WS.pojo.Page;



@Service
public class AgentDao extends BaseDao{
	
	
	/**
	 * 登录
	 * @param agent
	 * @return
	 */
	public List<Agent> login(Agent agent){
		Query query=getSession().createQuery("From Agent where agwxnum=? and agpassword=?");
		query.setString(0, agent.getAgwxnum());
		query.setString(1, agent.getAgpassword());
		return query.list();
	}
	/**
	 * 得到代理通过微信号
	 * @param agwxnum
	 * @return
	 */
	public List<Agent> getAgentByAgwxnum(String agwxnum){
		Query query=getSession().createQuery("From Agent where agwxnum=?");
		query.setString(0, agwxnum);
		List<Agent> lg=query.list();
		return lg;
	}
	
	
	/**
	 * 得到代理
	 * @param id
	 * @return
	 */
	public Agent getAgentByID(int id){
		return (Agent)getSession().get(Agent.class, id);
	}
	/**
	 * 通过夫id 得到下属代理
	 * @param pid
	 * @return
	 */
	public List<Agent> findHAgent(int pid){
		try{
			Query query=getSession().createQuery("from Agent where agpid=?");
			query.setInteger(0, pid);
			return query.list();
		}catch(Exception e){
			System.out.println(e.getMessage()); 
			return null;
		}
	}
	/**
	 * 得到所有代理
	 * @return
	 */
	public List<Agent> getAgentAllOrderBy(){
		try{
			Query query=getSession().createQuery("from Agent order by agpid ");
			return query.list();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	/**
	 * 
	 * @param agpid
	 * @return
	 */
	public List<Agent> getAgentByagpid(int agpid){
		try{
			Query query=getSession().createQuery("from Agent where agpid=? order by aglevel");
			query.setInteger(0, agpid);
			return query.list();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	public boolean changePassword(Agent agent,String newpassword){
		try{
		 Agent ag= (Agent) getSession().load(Agent.class, agent.getAgid());
		 ag.setAgpassword(newpassword);
		 getSession().update(ag);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
