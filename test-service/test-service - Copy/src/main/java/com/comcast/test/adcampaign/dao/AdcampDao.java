package com.comcast.test.adcampaign.dao;

import com.comcast.test.adcampaign.domains.AdCamp;

public interface AdcampDao {

	public String addCampaign(AdCamp adCamp);
	public String updateCampaign(AdCamp adCamp);
	public String getCampaigns(String partnerId);
	
}
