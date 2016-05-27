package com.WS.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.WS.pojo.Agent;
import com.WS.pojo.Page;
import com.WS.service.AgentService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class AgentAction extends ActionSupport implements SessionAware,ServletResponseAware{
	private Agent agent;
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Agent getAgent() {
		return agent;
	}
	private int id;
	private String name;
	private int level;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	private String newpassword;
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Autowired
	private AgentService agentService;
	
	public String login() throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONObject jb =new JSONObject();
		try{
			List<Agent> la=agentService.login(agent);
			if(la.size()>0){
				session.put("agent", la.get(0));
				jb.put("code", 1);
			}else{
				jb.put("code", 0);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			jb.put("code", 0);
		}
		PrintWriter out=response.getWriter();
		out.print(jb);
		out.flush();  
	    out.close(); 
		return null;
	}	
	public String getAgentByAgwxnum() throws IOException{
		List<Agent> lg=agentService.getAgentByAgwxnum(agent.getAgwxnum());
		response.setCharacterEncoding("utf-8");
		JSONObject jb =new JSONObject();
		if(lg.size()>0){
			jb.put("code", 1);
			session.put("pagent", lg.get(0));
			jb.put("agent", lg.get(0));
		}else{
			jb.put("code", 0);
		}
		PrintWriter out=response.getWriter();
		out.print(jb);
		out.flush();  
	    out.close(); 
		return null;
	}
	
	public String getAgentTreeData() throws IOException{
		JSONObject json =new JSONObject();
		response.setCharacterEncoding("utf-8");
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		if(id==-2){
			id=((Agent)session.get("agent")).getAgid();
			System.out.println("id:"+id);
		}
		List<Agent> lg=agentService.getAgentByagpid(id);
		for(int i = 0;i < lg.size(); i ++){
			HashMap<String,Object> hm = new HashMap<String,Object>();   //最外层，父节点           
			hm.put("id", lg.get(i).getAgid());
			if(lg.get(i).getAglevel()==0){
			hm.put("name", lg.get(i).getAgname()+"(总代)");
			}else{
				hm.put("name", lg.get(i).getAgname()+"("+lg.get(i).getAglevel()+"级代理)");
			}
			hm.put("pId",id);
			if(lg.get(i).getAgcount()>0){
				hm.put("isParent", true);
				hm.put("icon", "img/diy/10.png");
			}else{
				hm.put("isParent", false);
				hm.put("icon", "img/diy/11.png");
			}
			list.add(hm);
		}	
		JSONArray arr = new JSONArray().fromObject(list);
		try {
			json.put("success", true);
			json.put("arr", arr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.write(arr.toString());
		out.flush();
		out.close();
		return null;
	}
	public String change() throws IOException{
		JSONObject jb =new JSONObject();
		response.setCharacterEncoding("utf-8");
		List<Agent> la=agentService.login(agent);
		if(la.size()>0){
			if(agentService.changePassword(la.get(0), newpassword)){
				jb.put("code",1);
			}else{
				jb.put("code", 0);
			}
		}else{
			jb.put("code", -1);
		}
		PrintWriter out=response.getWriter();
		out.print(jb);
		out.flush();
		out.close();
		return null;
		
	}
	private ServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
}
