package com.WS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WS.dao.AchievementDao;
import com.WS.pojo.Achievement;
import com.WS.pojo.Agent;
import com.WS.pojo.Page;
import com.WS.pojo.Performance;


@Service
public class AchievementService {
	@Autowired
	private AchievementDao achievementDao;
	public List<Achievement> getAchievementByAgent(int agent){
		return achievementDao.getAchievementByAgent(agent);
	}
	public boolean addAchievement(Achievement achievement){
		return achievementDao.addAchievement(achievement);
	}
	public boolean updateAchievement(Achievement achievement){
		return achievementDao.updateAchievement(achievement);
	}
	
	public List<Performance> getPerformanceByPage(Page page){
		return achievementDao.getPerformanceByPage(page);
	}
	public List<Achievement> getAchievementAll(){
		return achievementDao.getAchievementAll();
	}
	public int getAchievementCount(Page page){
		return achievementDao.getAchievementCount(page);
	}
	public boolean deleteAllAchievement(){
		return achievementDao.deleteAllAchievement();
	}
	public List<Performance> getAchievementByPid(Agent agent){
		return achievementDao.getAchievementByPid(agent);
	}
	public List<Performance> getAchievementByid(Agent agent){
		return achievementDao.getAchievementByid(agent);
	}
}

