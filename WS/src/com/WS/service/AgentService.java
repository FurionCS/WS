package com.WS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WS.dao.AgentDao;
import com.WS.pojo.Agent;
import com.WS.pojo.Page;


@Service
public class AgentService {
	@Autowired
	private AgentDao agentDao;
	
	public List<Agent> getAgentByAgwxnum(String agwxnum){
		return agentDao.getAgentByAgwxnum(agwxnum);
	}
	public Agent getAgentByID(int id){
		return agentDao.getAgentByID(id);
	}
	public List<Agent> findHAgent(int pid){
		return agentDao.findHAgent(pid);
	}
	public List<Agent> getAgentByagpid(int agpid){
		return agentDao.getAgentByagpid(agpid);
	}
	public List<Agent> login(Agent agent){
		return agentDao.login(agent);
	}
	public boolean changePassword(Agent agent,String newpassword){
		return agentDao.changePassword(agent, newpassword);
	}
}
