package com.comcast.test.adcampaign.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.comcast.test.adcampaign.dao.AdcampDao;
import com.comcast.test.adcampaign.domains.AdCamp;
import com.comcast.test.adcampaign.domains.Partner;
import com.google.gson.Gson;

@Component
public class AdcampDaoImpl implements AdcampDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	Gson gson;
	
	@Transactional
	public String addCampaign(AdCamp adCamp) {
		/*if(null == adCamp.getAdCampId()){
			adCamp.setAdCampId("1234");
		}*/
		entityManager.persist(adCamp);
		return "success";
	}
	
	@Transactional
	public String updateCampaign(AdCamp adCamp) {

		String partnerId = null;
		if(null != adCamp.getAdCampId()){
			AdCamp oldAdCamp = entityManager.find(AdCamp.class, adCamp.getAdCampId());
			entityManager.merge(adCamp);
			
		}else{
			entityManager.persist(adCamp);
		}
		return "success";
	}
	
	
	@Transactional
	public String getCampaigns(String partnerId){
		Partner partner = entityManager.find(Partner.class, partnerId);
		if(null != partner.getList()){
			return gson.toJson(partner.getList());
		}
		return null;
	}
	
}
