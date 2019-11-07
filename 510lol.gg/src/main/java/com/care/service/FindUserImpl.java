package com.care.service;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.dto.DTO;
import com.care.dto.LeagueEntrydto;
import com.care.dto.MostCham;
import com.care.dto.SearchDTO;
import com.care.dto.userDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Service
public class FindUserImpl implements Services{
	
	private static final String namespace="com.care.mybatis.myMapper";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String nickname = request.getParameter("nickname");
		String nick= request.getParameter("nickname");
		String API_KEY = (String)map.get("APIKEY");
		BufferedReader br = null;
		BufferedReader br2 = null;
		BufferedReader br3 = null;
		
		userDTO temp = null;
		SearchDTO sdto = null;
		MostCham moo = null;
		ArrayList<MostCham> mostC = new ArrayList<MostCham>();
		
		ArrayList<LeagueEntrydto> leaguearr = new ArrayList<LeagueEntrydto>();
		
		DTO memberdto = sqlSession.selectOne(namespace+".findmember03", nick);
		if(memberdto== null) {
			SearchDTO nomemberdto = sqlSession.selectOne(namespace+".findnonemember03", nick);
			if(nomemberdto == null) {
				
				try{ 
			
					// nickname 검색
					String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ nickname +"?api_key="+API_KEY; 
					URL url = new URL(urlstr); 
					HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection(); 
					urlconnection.setRequestMethod("GET");
					br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
					//여기에 문자열을 받아와라. 
					String result = ""; 
					String line; 
					while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
						result = result + line; }
					JsonParser jsonParser = new JsonParser(); 
					JsonObject k = (JsonObject) jsonParser.parse(result); 
					int profileIconId = k.get("profileIconId").getAsInt();
					String name = k.get("name").getAsString(); 
					String puuid = k.get("puuid").getAsString(); 
					long summonerLevel = k.get("summonerLevel").getAsLong();
					long revisionDate = k.get("revisionDate").getAsLong(); 
					String id = k.get("id").getAsString();
					String accountId = k.get("accountId").getAsString(); 
					temp = new userDTO(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId); 
					
				// nickname으로 랭크, 티어 , 점수 출력	
					String urlstr2 = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key="+API_KEY;
					URL url2 = new URL(urlstr2);
					HttpURLConnection urlconnection2 = (HttpURLConnection) url2.openConnection(); 
					urlconnection2.setRequestMethod("GET");
					br2 = new BufferedReader(new InputStreamReader(urlconnection2.getInputStream(),"UTF-8"));
					String result2 = "";
					String line2; 
					while((line2 = br2.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
						result2 = result2 + line2; }
						JsonParser jsonParser2 = new JsonParser();
						JsonArray arr = (JsonArray) jsonParser2.parse(result2); 
						for(int i=0;i<arr.size();i++){
							LeagueEntrydto leagueInfo;
							JsonObject k2 = (JsonObject) arr.get(i);
							int wins = k2.get("wins").getAsInt(); 
							int losses = k2.get("losses").getAsInt(); 
							String rank = k2.get("rank").getAsString(); 
							String tier = k2.get("tier").getAsString(); 
							String queueType = k2.get("queueType").getAsString(); 
							int leaguePoints = k2.get("leaguePoints").getAsInt(); 
							String leagueId = k2.get("leagueId").getAsString(); 
							leagueInfo = new LeagueEntrydto(queueType, wins, losses, leagueId, rank,tier, leaguePoints);
							leaguearr.add(leagueInfo);
						
						}
						
					// Most5 출력	
						String urlstr3 = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"+id+"?api_key="+API_KEY;
						URL url3 = new URL(urlstr3);
						HttpURLConnection urlconnection3 = (HttpURLConnection) url3.openConnection(); 
						urlconnection3.setRequestMethod("GET");
						br3 = new BufferedReader(new InputStreamReader(urlconnection3.getInputStream(),"UTF-8"));
						String result3 = "";
						String line3; 
						while((line3 = br3.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
							result3 = result3 + line3;
						}
						JsonParser jsonParser3 = new JsonParser();
						JsonArray arr2 = (JsonArray) jsonParser3.parse(result3); 
						
						for(int i=0;i<5;i++){
							JsonObject k3 = (JsonObject) arr2.get(i);
							int most = k3.get("championId").getAsInt();
							moo = new MostCham(most);
							mostC.add(moo);
							
						}
						for(int i=0;i<leaguearr.size();i++) {
							if(leaguearr.get(i).getQueueType().equals("RANKED_SOLO_5x5")) {
								String queueType = leaguearr.get(i).getQueueType();
								int total = leaguearr.get(i).getWins() + leaguearr.get(i).getLosses();
								float winrate = (float)leaguearr.get(i).getWins()/total;
								
								String rank = leaguearr.get(i).getRank();
								String tier= leaguearr.get(i).getTier();
								int score = leaguearr.get(i).getLeaguePoints();
								int most1 = mostC.get(0).getMost1();
								int most2 = mostC.get(1).getMost1();
								int most3 = mostC.get(2).getMost1();
								int most4 = mostC.get(3).getMost1();
								int most5 = mostC.get(4).getMost1();
								int profileIconId2 = temp.getProfileIconId();
								sdto = new SearchDTO(queueType, nick, total, winrate, rank, tier, score, most1, most2, most3, most4, most5, profileIconId2);
								sqlSession.insert(namespace+".nonmember03", sdto);
								
							}
						}
				
				}catch(Exception e){
					System.out.println(e.getMessage()); 
				}
				
								
				model.addAttribute("imgURL", "http://ddragon.leagueoflegends.com/cdn/9.16.1/img/profileicon/"+temp.getProfileIconId()+".png");
				model.addAttribute("leagueInfo", sdto);
				
			}else {
				model.addAttribute("finduser", nomemberdto);
				model.addAttribute("imgURL", "http://ddragon.leagueoflegends.com/cdn/9.16.1/img/profileicon/"+nomemberdto.getProfileIconId()+".png");
				
			}
				
			}else {
				System.out.println(memberdto.getId());
		}
	
	}


}
