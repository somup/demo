package com.comcast.test.adcampaign.service;

import com.comcast.test.adcampaign.domains.AdCamp;

public interface AdcampService {
	
	public String addCampaign(AdCamp adCamp);
	public String updateCampaign(AdCamp adCamp);
	public String getCampaigns(String partnerId);

}
