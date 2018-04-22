package com.dazhumei.love.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.web.dao.LabelMapper;
import com.dazhumei.love.web.entity.Label;
import com.dazhumei.love.web.service.LabelService;

@Service
@Transactional
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelMapper labelDao;

	public boolean addLabel(Label label) {
		if (labelDao.addLabel(label) == 1) {
			return true;
		}
		return false;
	}

	public List<Label> selectAllLabelByUserId(Integer userId) {
		return labelDao.selectAllLabelByUserId(userId);
	}

	public List<Label> selectAllThemeByUserId(Integer userId) {
		return labelDao.selectAllThemeByUserId(userId);
	}

	public List<Label> selectAllUrlByUserId(Integer userId) {
		return labelDao.selectAllUrlByUserId(userId);
	}

}
