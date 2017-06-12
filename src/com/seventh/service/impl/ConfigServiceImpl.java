package com.seventh.service.impl;

import com.seventh.dao.ConfigDAO;
import com.seventh.entity.Config;
import com.seventh.service.ConfigService;

public class ConfigServiceImpl implements ConfigService{
	private ConfigDAO configDao;
	@Override
	public Config init() {
		return this.configDao.init();
	}
	public ConfigDAO getConfigDao() {
		return configDao;
	}
	public void setConfigDao(ConfigDAO configDao) {
		this.configDao = configDao;
	}
	@Override
	public void update(Config config) {
		this.getConfigDao().update(config);
	}
	
}
