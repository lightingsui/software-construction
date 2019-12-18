package com.daofactory;

import com.dao.TrainingPlanDAO;
import com.dao.UserDAO;
import com.dao.impl.TrainingPlanDAOImpl;
import com.dao.impl.UserDAOImpl;

public class DAOFactory {
	
	public static UserDAO getUserDAOInstance() {
		return new UserDAOImpl();
	}
	
	public static TrainingPlanDAO getPlanDaoInstance() {
		return new TrainingPlanDAOImpl();
	}
}
