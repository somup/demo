package com.comcast.test.adcampaign.domains;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.List;

@Entity
@Table(name = "PARTNER")
public class Partner {

	@Id
    @Column(name = "partnerId")
    private String partnerId;
	
    @Column(name = "partnerName")
    private String partnerName;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<AdCamp> list;

	public List<AdCamp> getList() {
		return list;
	}

	public void setList(List<AdCamp> list) {
		this.list = list;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
    
    
}
