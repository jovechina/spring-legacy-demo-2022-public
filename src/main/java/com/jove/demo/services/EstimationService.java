package com.jove.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jove.demo.models.Estimation;
import com.jove.demo.persistence.EstimationMapper;

@Service
public class EstimationService {
	
	@Autowired
	EstimationMapper estimationMapper;
	
	public int insert(Estimation est) {
		est.setCreateDate(new Date());
		estimationMapper.insert(est);
		return est.getEstimationId();
	}
	
	public boolean update(Estimation est) {
		est.setUpdateDate(new Date());
		return estimationMapper.update(est);
	}
	
	public boolean del(int id) {
		return estimationMapper.delete(id);
	}
	
	public Estimation selectOne(int id) {
		return estimationMapper.selectEstimationById(id);
	}
	
	public List<Estimation> selectToSearchResult() {
		return estimationMapper.selectToSearchResult();
	}

}
