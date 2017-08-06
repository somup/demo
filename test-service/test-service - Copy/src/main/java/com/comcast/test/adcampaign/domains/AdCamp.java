package com.comcast.test.adcampaign.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ADCAMP")
public class AdCamp {

    @Column(name = "adTitle")
    private String adTitle;
    
	@Column(name = "creationtime")
    private String creationTime;
    
    @Column(name = "adContent")
    private String adContent;
	
    @Column(name = "adStatus")
    private String adStatus;
    
    @Column(name = "duration")
    private String duration;
    
/*    @Column(name="adCampId")
    private String adCampId;*/
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTNERID", nullable = false)
	private Partner partner;
    
    
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "adCampId", unique = true, nullable = false)
	private String adCampId;
	
	public String getAdCampId() {
		return this.adCampId;
	}
	
	public void setAdCampId(String adCampId) {
		this.adCampId = adCampId;
	}
	
    public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public String getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}


	
	
}
