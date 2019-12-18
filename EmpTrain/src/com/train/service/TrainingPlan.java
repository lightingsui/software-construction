package com.train.service;

import java.util.List;

import com.factory.dao.DaoFactory;
import com.train.dto.TrainingPlanDTO;

public class TrainingPlan {
	public TrainingPlan() {
	}

	public boolean saveTrainingPlan(TrainingPlanDTO planDTO) {
		boolean success = false;
		success = DaoFactory.getTrainingPlanDAO().saveTrainingPlan(planDTO);
		return success;
	}

	public boolean deleteTrainingPlan(String train_plan_id) {
		return DaoFactory.getTrainingPlanDAO().deleteTrainingPlan(train_plan_id);
	}

	public boolean updateTrainingPlan(TrainingPlanDTO planDTO) {
		return DaoFactory.getTrainingPlanDAO().updateTrainingPlan(planDTO);
	}

	public TrainingPlanDTO getTrainingPlan(TrainingPlanDTO planDTO) {
		return DaoFactory.getTrainingPlanDAO().getTrainingPlan(planDTO);
	}

	public TrainingPlanDTO getPlan(String train_plan_id) {
		return DaoFactory.getTrainingPlanDAO().getPlan(train_plan_id);
	}
	
	
	public List<TrainingPlanDTO> getAllTrainingPlan(Object... params) {
		List<TrainingPlanDTO> allPlan = null;

		allPlan = DaoFactory.getTrainingPlanDAO().getAllTrianingPlan(params);

		return allPlan;
	}
	
}
