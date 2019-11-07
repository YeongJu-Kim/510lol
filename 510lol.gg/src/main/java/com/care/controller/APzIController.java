package com.care.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.net.HttpURLConnection; 
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.dto.LeagueEntrydto;
import com.care.dto.League_expDTO;
import com.care.dto.userDTO;
import com.care.service.FindUserImpl;
import com.care.service.Services;
import com.care.service.TierRankImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser; 




@Controller
public class APzIController {
	
	private Services ser;
	
	ApplicationContext applicationContext = ApplicationContextprovider.applicationContext;
	
	final static String API_KEY = "RGAPI-82374f62-3a25-42f6-afb5-8bb0aed0bb2c";
	
	@RequestMapping("FindUser")
	public String FindUser() {
		return "FindUser";
	}
	
	@RequestMapping("findUserRe")
	public String findUserRe(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		model.addAttribute("APIKEY", API_KEY);
		ser = applicationContext.getBean("findUserImpl",FindUserImpl.class);
		ser.execute(model);
		
		return "findUserRe";
	}
	
	@RequestMapping("League-exp")
	public String League_exp(){
		return "League-exp";
	}
	@RequestMapping("league-exp-re")
	public String league_exp_re(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		model.addAttribute("APIKEY", API_KEY);
		ser = applicationContext.getBean("tierRankImpl",TierRankImpl.class);
		ser.execute(model);
		
		
		return "league-exp-re";
	}
	
	}
