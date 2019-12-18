package com.train.service;

import java.util.List;

import com.factory.dao.DaoFactory;
import com.train.dto.TrainResultDTO;

public class TrainResult {

	public TrainResult() {
	}

	public List<TrainResultDTO> getTrainResult(List<String> emp_id) {
		return DaoFactory.getTrainResultDAO().getTrainResult(emp_id);
	}

	public boolean saveResult(TrainResultDTO resultDTO) {
		return DaoFactory.getTrainResultDAO().saveResult(resultDTO);
	}
	
	public boolean updateResult(TrainResultDTO resultDTO) {
		return DaoFactory.getTrainResultDAO().updateResult(resultDTO);
	}
}
