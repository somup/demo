package com.comcast.test.adcampaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.test.adcampaign.domains.AdCamp;
import com.comcast.test.adcampaign.domains.Partner;
import com.comcast.test.adcampaign.service.AdcampService;
import com.google.gson.Gson;

@RestController
public class AdCampaignController {
	
	@Autowired
	AdcampService adCampService;
	
	@Autowired
	Gson gson;

	
	@RequestMapping(value = "/addAdCampaign", method = RequestMethod.POST, consumes="application/json")
	public String addCampaign(@RequestBody String json) {
		
		AdCamp adCamp = gson.fromJson(json, AdCamp.class);
		Partner partner = gson.fromJson(json, Partner.class);
		adCamp.setPartner(partner);
		
		return adCampService.addCampaign(adCamp);
	
	}

	@RequestMapping(value = "/updateAdCampaign", method = RequestMethod.POST, consumes="application/json")
	public String updateAdCampaign(@RequestBody String json) {
		
		AdCamp adCamp = gson.fromJson(json, AdCamp.class);
		Partner partner = gson.fromJson(json, Partner.class);
		adCamp.setPartner(partner);
		
		return adCampService.updateCampaign(adCamp);
	
	}

	
	@RequestMapping(value = "/getCampaign", method = RequestMethod.GET)
	public String getCampaigns(@RequestParam("partnerId") String partnerId) {
	
		return adCampService.getCampaigns(partnerId);
		
	}
	
}
