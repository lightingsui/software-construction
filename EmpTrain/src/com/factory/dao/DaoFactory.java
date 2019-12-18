package com.factory.dao;

import com.train.persistence.DepartmentDao;
import com.train.persistence.PlanItemDao;
import com.train.persistence.TrainEmpDao;
import com.train.persistence.TrainResultDao;
import com.train.persistence.TrainingPlanDao;
import com.train.persistence.UserDao;

/**
 * DAO工厂
 * 
 * @author Sui
 *
 */
public class DaoFactory {

	public DaoFactory() {
	}

	public static UserDao getUserDAO() {
		return new UserDao();
	}

	public static TrainingPlanDao getTrainingPlanDAO() {
		return new TrainingPlanDao();
	}

	public static PlanItemDao getPlanItemDAO() {
		return new PlanItemDao();
	}

	public static DepartmentDao getDepartmentDAO() {
		return new DepartmentDao();
	}

	public static TrainEmpDao getTrainEmpDAO() {
		return new TrainEmpDao();
	}
	
	public static TrainResultDao getTrainResultDAO() {
		return new TrainResultDao();
	}
}
