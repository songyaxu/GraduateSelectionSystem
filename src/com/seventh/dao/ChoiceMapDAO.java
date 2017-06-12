package com.seventh.dao;

import java.util.List;

import com.seventh.entity.ChoiceMap;

public interface ChoiceMapDAO {
	public List<ChoiceMap> findByStudentId(String id);
	public List<ChoiceMap> findByTopicId(int id);
	public ChoiceMap findChoiceMapById(int id);
	public void save(ChoiceMap choiceMap);
	public void update(ChoiceMap choiceMap);
	public void delete(ChoiceMap choiceMap);
	
}
