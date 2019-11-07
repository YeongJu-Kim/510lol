package com.care.dto;

public class SearchDTO {
	private String queueType;
	private String nick;
	private int total;
	private float winrate;
	private String rank;
	private String tier;
	private int score;
	private int most1;
	private int most2;
	private int most3;
	private int most4;
	private int most5;
	private int profileIconId;
	
	public SearchDTO(String queueType, String nick, int total, float winrate, String rank, String tier, int score, int most1, int most2, int most3, int most4, int most5, int profileIconId) {
		this.queueType = queueType;
		this.nick = nick;
		this.total = total;
		this.winrate = winrate;
		this.rank = rank;
		this.tier = tier;
		this.score = score;
		this.most1 = most1;
		this.most2 = most2;
		this.most3 = most3;
		this.most4 = most4;
		this.most5 = most5;
		this.profileIconId =profileIconId;
	}
	
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getMost1() {
		return most1;
	}
	public void setMost1(int most1) {
		this.most1 = most1;
	}
	public int getMost2() {
		return most2;
	}
	public void setMost2(int most2) {
		this.most2 = most2;
	}
	public int getMost3() {
		return most3;
	}
	public void setMost3(int most3) {
		this.most3 = most3;
	}
	public int getMost4() {
		return most4;
	}
	public void setMost4(int most4) {
		this.most4 = most4;
	}
	public int getMost5() {
		return most5;
	}
	public void setMost5(int most5) {
		this.most5 = most5;
	}
	public float getWinrate() {
		return winrate;
	}
	public void setWinrate(float winrate) {
		this.winrate = winrate;
	}
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	
	
}
