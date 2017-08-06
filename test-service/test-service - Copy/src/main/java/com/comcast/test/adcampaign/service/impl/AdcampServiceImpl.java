package com.comcast.test.adcampaign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comcast.test.adcampaign.dao.AdcampDao;
import com.comcast.test.adcampaign.domains.AdCamp;
import com.comcast.test.adcampaign.service.AdcampService;

@Component
public class AdcampServiceImpl implements AdcampService{
	
	@Autowired
	AdcampDao adCampDao;

	public String addCampaign(AdCamp adCamp) {
		return adCampDao.addCampaign(adCamp);
		// TODO Auto-generated method stub
		//return null;
	}
	
	public String updateCampaign(AdCamp adCamp) {
		return adCampDao.updateCampaign(adCamp);
	}
	
	public String getCampaigns(String partnerId){
		return adCampDao.getCampaigns(partnerId);
	}

}
