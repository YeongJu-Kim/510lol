package com.care.dto;

public class userDTO {
	private int profileIconId;
	private String name;
	private String puuid;
	private long summonerLevel; 
	private long revisionDate;
	private String id;
	private String accountId;
	public userDTO(int profileIconId,String name, String puuid,long summonerLevel, long revisionDate, String id, String accountId) {
		this.profileIconId = profileIconId;
		this.name = name;
		this.puuid = puuid;
		this.summonerLevel = summonerLevel;
		this.revisionDate = revisionDate;
		this.id = id;
		this.accountId = accountId;
		
	}
	
	
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	

	
}
