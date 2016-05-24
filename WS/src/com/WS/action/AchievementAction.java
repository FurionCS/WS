package com.WS.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.WS.pojo.Achievement;
import com.WS.pojo.Agent;
import com.WS.pojo.Page;
import com.WS.pojo.Performance;
import com.WS.service.AchievementService;
import com.WS.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AchievementAction extends ActionSupport implements SessionAware,ServletResponseAware{
	@Autowired
	private AchievementService achievementService;
	
	private Achievement achievement;
	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}
	public Achievement getAchievement() {
		return achievement;
	}
	private Page page;
	public void setPage(Page page) {
		this.page = page;
	}
	public Page getPage() {
		return page;
	}
	
	public String getAchievementByAgent() throws IOException{
	
		response.setCharacterEncoding("utf-8");
		JSONObject jb =new JSONObject();
		Agent agent=(Agent)session.get("agent");
		try{
			List<Performance> la=achievementService.getAchievementByid(agent);
			if(la.size()>0){
			jb.put("code", 1);
			jb.put("achievement",la.get(0));
			jb.put("achievementTeam", achievementService.getAchievementByPid(agent));
		}else{
			jb.put("code", 0);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		response=arg0;
	}
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}
}
