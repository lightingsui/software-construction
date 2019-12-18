package com.train.service;

import java.util.List;

import com.factory.dao.DaoFactory;
import com.train.dto.TrainEmpDTO;

public class TrainEmp {

	public TrainEmp() {
	}

	public boolean saveTrainEmp(TrainEmpDTO trainEmpDTO) {
		return DaoFactory.getTrainEmpDAO().saveTrainEmp(trainEmpDTO);
	}

	public Integer countNumOfEmp(String train_item_id) {
		return DaoFactory.getTrainEmpDAO().countNumOfEmp(train_item_id);
	}

	public List<TrainEmpDTO> getTrainEmp(String train_item_id) {
		return DaoFactory.getTrainEmpDAO().getTrainEmp(train_item_id);
	}

	public boolean deleteTrainEmp(String train_item_id, String emp_id) {
		return DaoFactory.getTrainEmpDAO()
				.deleteTrainEmp(train_item_id, emp_id);
	}

	public List<String> getTrainEmpId(String train_item_id) {
		return DaoFactory.getTrainEmpDAO().getTrainEmpId(train_item_id);
	}
}
