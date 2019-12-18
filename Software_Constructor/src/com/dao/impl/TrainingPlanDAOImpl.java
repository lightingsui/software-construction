package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.TrainingPlanDAO;
import com.train.base.ResultSetHandler;
import com.train.vo.MajorPlan;
import com.train.vo.TrainingPlan;
import com.util.db.JdbcTemplate;

public class TrainingPlanDAOImpl implements TrainingPlanDAO {
	private JdbcTemplate jdbcTemplate;

	public TrainingPlanDAOImpl() {
		jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public int add(TrainingPlan trainingPlan) throws SQLException {
		String sql1 = "INSERT INTO train_plan_info(TRAIN_PLAN_ID, TRAIN_PLAN_NAME, TRAIN_PLAN_YEAR, START_TIME, END_TIME, IS_FINISH) VALUES(?, ?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO train_plan_item(TRAIN_ITEM_ID, TRAIN_PLAN_ID, ZY_DIC_ID, ZY_NAME, TRAIN_PURPOSE, TRAIN_CONTENT, CLASS_COUNT, TEACHER) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int k1 = jdbcTemplate.update(sql1, trainingPlan.getId(),
				trainingPlan.getName(), trainingPlan.getPlanYear(),
				trainingPlan.getStartDate(), trainingPlan.getEndDate(),
				trainingPlan.getFinish());
		int k2 = jdbcTemplate.update(sql2, trainingPlan.getMajorPlan()
				.getTrain_item_id(), trainingPlan.getId(), trainingPlan
				.getMajorPlan().getMajorId(), trainingPlan.getMajorPlan()
				.getMajorName(), trainingPlan.getMajorPlan()
				.getTrainingPurpose(), trainingPlan.getMajorPlan()
				.getTrainingContent(), trainingPlan.getMajorPlan()
				.getClassHours(), trainingPlan.getMajorPlan().getTeacher());
		return k1 + k2;
	}

	@Override
	public int delete(String planId) throws SQLException {
		String sql1 = "DELETE FROM train_plan_item WHERE TRAIN_PLAN_ID=?";
		String sql2 = "DELETE FROM train_plan_info WHERE TRAIN_PLAN_ID=?";

		int k1 = jdbcTemplate.update(sql1, planId);
		int k2 = jdbcTemplate.update(sql2, planId);
		return k1 + k2;
	}

	@Override
	public int update(TrainingPlan trainingPlan) throws SQLException {
		String sql1 = "UPDATE train_plan_info SET TRAIN_PLAN_ID=?, TRAIN_PLAN_NAME=?, TRAIN_PLAN_YEAR=?, START_TIME=?,END_TIME=?, IS_FINISH=? WHERE TRAIN_PLAN_ID=?";
		String sql2 = "UPDATE train_plan_item SET TRAIN_ITEM_ID=?, TRAIN_PLAN_ID=?, ZY_DIC_ID=?, ZY_NAME=?, TRAIN_PURPOSE=?, TRAIN_CONTENT=?, CLASS_COUNT=?, TRACHER=? WHERE TRAIN_PLAN_ID=?";

		int k1 = jdbcTemplate.update(sql1, trainingPlan.getId(),
				trainingPlan.getName(), trainingPlan.getPlanYear(),
				trainingPlan.getStartDate(), trainingPlan.getEndDate(),
				trainingPlan.getFinish(), trainingPlan.getId());
		int k2 = jdbcTemplate.update(sql2, trainingPlan.getMajorPlan()
				.getTrain_item_id(), trainingPlan.getId(), trainingPlan
				.getMajorPlan().getMajorId(), trainingPlan.getMajorPlan()
				.getMajorName(), trainingPlan.getMajorPlan()
				.getTrainingPurpose(), trainingPlan.getMajorPlan()
				.getTrainingContent(), trainingPlan.getMajorPlan()
				.getClassHours(), trainingPlan.getMajorPlan().getTeacher(),
				trainingPlan.getId());
		return k1 + k2;
	}

	@Override
	public TrainingPlan findById(String planId) throws SQLException {
		String sql1 = "SELECT * FROM train_plan_info WHERE TRAIN_PLAN_ID=?";
		String sql2 = "SELECT * FROM train_plan_item WHERE TRAIN_PLAN_ID=?";

		TrainingPlan trainingPlan = (TrainingPlan) jdbcTemplate.query(sql1,
				new ResultSetHandler() {

					@Override
					public Object doHandler(ResultSet rs) throws SQLException {
						TrainingPlan trainingPlan = null;

						if (rs.next()) {
							trainingPlan = new TrainingPlan();
							trainingPlan.setId(rs.getString("TRAIN_PLAN_ID"));
							trainingPlan.setName(rs
									.getString("TRAIN_PLAN_NAME"));
							trainingPlan.setPlanYear(rs
									.getString("TRAIN_PLAN_YEAR"));
							trainingPlan.setStartDate(rs.getDate("START_TIME"));
							trainingPlan.setEndDate(rs.getDate("END_TIME"));
							trainingPlan.setFinish(rs.getString("IS_FINISH"));
						}
						return trainingPlan;
					}
				}, planId);

		MajorPlan majorPlan = (MajorPlan) jdbcTemplate.query(sql2,
				new ResultSetHandler() {

					@Override
					public Object doHandler(ResultSet rs) throws SQLException {
						MajorPlan majorPlan = null;

						if (rs.next()) {
							majorPlan = new MajorPlan();
							majorPlan.setTrain_item_id(rs
									.getString("TRAIN_ITEM_ID"));
							majorPlan.setMajorId(rs.getString("ZY_DIC_ID"));
							majorPlan.setMajorName(rs.getString("ZY_NAME"));
							majorPlan.setTrainingPurpose(rs
									.getString("TRAIN_PURPOSE"));
							majorPlan.setTrainingContent(rs
									.getString("TRAIN_CONTENT"));
							majorPlan.setClassHours(rs.getString("CLASS_COUNT"));
							majorPlan.setTeacher(rs.getString("TEACHER"));
						}
						return majorPlan;
					}
				}, trainingPlan);

		trainingPlan.setMajorPlan(majorPlan);
		return trainingPlan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainingPlan> find() throws SQLException {
		String sql1 = "SELECT * FROM train_plan_info";
		String sql2 = "SELECT * FROM train_plan_item WHERE TRAIN_PLAN_ID=?";

		List<TrainingPlan> trainingPlans = (List<TrainingPlan>) jdbcTemplate
				.query(sql1, new ResultSetHandler() {

					@Override
					public Object doHandler(ResultSet rs) throws SQLException {
						List<TrainingPlan> trainingPlans = new ArrayList<TrainingPlan>();
						TrainingPlan trainingPlan = null;

						if (rs.next()) {
							trainingPlan = new TrainingPlan();
							trainingPlan.setId(rs.getString("TRAIN_PLAN_ID"));
							trainingPlan.setName(rs
									.getString("TRAIN_PLAN_NAME"));
							trainingPlan.setPlanYear(rs
									.getString("TRAIN_PLAN_YEAR"));
							trainingPlan.setStartDate(rs.getDate("START_TIME"));
							trainingPlan.setEndDate(rs.getDate("END_TIME"));
							trainingPlan.setFinish(rs.getString("IS_FINISH"));
							trainingPlans.add(trainingPlan);
						}
						return trainingPlans;
					}
				});

		for (int i = 0; i < trainingPlans.size(); i++) {
			MajorPlan majorPlan = (MajorPlan) jdbcTemplate.query(sql2,
					new ResultSetHandler() {

						@Override
						public Object doHandler(ResultSet rs)
								throws SQLException {
							MajorPlan majorPlan = null;

							if (rs.next()) {
								majorPlan = new MajorPlan();
								majorPlan.setTrain_item_id(rs
										.getString("TRAIN_ITEM_ID"));
								majorPlan.setMajorId(rs.getString("ZY_DIC_ID"));
								majorPlan.setMajorName(rs.getString("ZY_NAME"));
								majorPlan.setTrainingPurpose(rs
										.getString("TRAIN_PURPOSE"));
								majorPlan.setTrainingContent(rs
										.getString("TRAIN_CONTENT"));
								majorPlan.setClassHours(rs
										.getString("CLASS_COUNT"));
								majorPlan.setTeacher(rs.getString("TEACHER"));
							}
							return majorPlan;
						}
					}, trainingPlans.get(i).getId());
			trainingPlans.get(i).setMajorPlan(majorPlan);
		}
		return trainingPlans;
	}
}
