package com.seventh.service.impl;

import java.util.List;

import com.seventh.dao.ChoiceMapDAO;
import com.seventh.entity.ChoiceMap;
import com.seventh.service.ChoiceMapService;

public class ChoiceMapServiceImpl implements ChoiceMapService{
	private ChoiceMapDAO choiceMapDao;

	public ChoiceMapDAO getChoiceMapDao() {
		return choiceMapDao;
	}

	public void setChoiceMapDao(ChoiceMapDAO choiceMapDao) {
		this.choiceMapDao = choiceMapDao;
	}

	@Override
	public List<ChoiceMap> findByStudentId(String id) {
		return this.getChoiceMapDao().findByStudentId(id);
	}

	@Override
	public List<ChoiceMap> findByTopicId(int id) {
		return this.getChoiceMapDao().findByTopicId(id);
	}

	@Override
	public void save(ChoiceMap choiceMap) {
		this.getChoiceMapDao().save(choiceMap);
	}

	@Override
	public void update(ChoiceMap choiceMap) {
		this.getChoiceMapDao().update(choiceMap);
	}

	@Override
	public void delete(ChoiceMap choiceMap) {
		this.getChoiceMapDao().delete(choiceMap);
	}

	@Override
	public ChoiceMap findChoiceMapById(int id) {
		return this.getChoiceMapDao().findChoiceMapById(id);
	}
	
}
