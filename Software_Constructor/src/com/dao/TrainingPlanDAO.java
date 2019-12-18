package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.train.vo.TrainingPlan;

public interface TrainingPlanDAO {
	public int add(TrainingPlan trainingPlan) throws SQLException;
	
	public int delete(String planId) throws SQLException;
	
	public int update(TrainingPlan trainingPlan) throws SQLException;
	
	public TrainingPlan findById(String planId) throws SQLException;
	
	public List<TrainingPlan> find() throws SQLException;
}
