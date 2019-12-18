package com.train.service;

import com.factory.dao.DaoFactory;
import com.train.dto.PlanItemDTO;

public class PlanItem {

	public PlanItem() {

	}

	/* 针对PlanItem的CRUD实现 */
	public boolean savePlanItem(PlanItemDTO planItemDTO) {
		boolean result = false;

		result = DaoFactory.getPlanItemDAO().savePlanItem(planItemDTO);
		return result;
	}

	public boolean deletePlanItem(String train_item_id) {
		return DaoFactory.getPlanItemDAO().deletePlanItem(train_item_id);
	}

	public boolean updatePlanItem(PlanItemDTO planItemDTO) {
		return DaoFactory.getPlanItemDAO().updatePlanItem(planItemDTO);
	}

	public PlanItemDTO getPlanItem(String train_plan_id) {
		return DaoFactory.getPlanItemDAO().getPlanItem(train_plan_id, null);
	}

	public PlanItemDTO getPlanItem(String train_plan_id, String zy_name) {
		PlanItemDTO item = null;

		item = DaoFactory.getPlanItemDAO().getPlanItem(train_plan_id, zy_name);
		return item;
	}
	
}
