package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.lol.Summoner;
import aiss.model.lol.SummonerSummary;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;
import aiss.model.lol.league.League;
import aiss.model.lol.match.Match;
import aiss.model.lol.matchlist.Matchlist;
import aiss.model.lol.rune.RuneSummary;
import aiss.model.lol.runes.RunesSummary;

public class LoLResource {
	private static final String LOL_API_KEY = "RGAPI-ad93d607-ea76-4425-bc3f-9a4f9f23e1f1";
	private static final String LOL_API_KEY2 = "RGAPI-01DE0062-F07C-4A50-89BB-8167AE54EE8B";
	private static final String LOL_URI = "https://euw1.api.riotgames.com/lol";
	private static final Logger log = Logger.getLogger(LoLResource.class.getName());
	
	public Summoner getSummoner(String name) throws UnsupportedEncodingException {
		ClientResource cr = new ClientResource(LOL_URI + "/summoner/v3/summoners/by-name/"+name+"?api_key="+LOL_API_KEY);
		Summoner res = cr.get(Summoner.class);
		return res;
	}
	
	public SummonerSummary getSummonerSummary(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource("https://euw1.api.riotgames.com/api/lol/euw/v1.3/stats/by-summoner/"+ summonerID+"/summary?api_key="+LOL_API_KEY);
		SummonerSummary res = cr.get(SummonerSummary.class);
		return res;
	}
	
	public ChampionMastery[] getChampionMastery(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource(LOL_URI + "/champion-mastery/v3/champion-masteries/by-summoner/"+summonerID+"?api_key="+LOL_API_KEY);
		ChampionMastery[] res = cr.get(ChampionMastery[].class);
		return res;
	}
	
	public Champion getChampionData(Long championID,boolean b) throws UnsupportedEncodingException{
		ClientResource cr = null;
		if(b){
			cr = new ClientResource(LOL_URI + "/static-data/v3/champions/"+championID+"?champData=image&api_key="+LOL_API_KEY2);
		}else{
			cr = new ClientResource(LOL_URI + "/static-data/v3/champions/"+championID+"?champData=image&api_key="+LOL_API_KEY);
		}
		return cr.get(Champion.class);
	}
	
	public League getLeagueData(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource(LOL_URI + "/EUW/v2.5/league/by-summoner/"+summonerID+"/entry?api_key=RGAPI-01DE0062-F07C-4A50-89BB-8167AE54EE8B");
		return cr.get(League.class);
	}
	
	public RunesSummary getRunes(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource(LOL_URI + "/platform/v3/runes/by-summoner/"+summonerID+"?api_key="+LOL_API_KEY);
		RunesSummary res = cr.get(RunesSummary.class);
		return res;
	}
	
	public RuneSummary getRune(Integer runeID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource(LOL_URI + "/static-data/v3/runes/"+runeID+"?api_key="+LOL_API_KEY+"&runeData=image");
		RuneSummary res = cr.get(RuneSummary.class);
		return res;
	}
	
	public Matchlist getMatchListV3(Integer summonerID) throws UnsupportedEncodingException{
		System.out.print("pus");
		ClientResource cr = new ClientResource(LOL_URI + "/match/v3/matchlists/by-account/" + summonerID+"?api_key="+LOL_API_KEY);
		System.out.print("sup");
		return cr.get(Matchlist.class);
	}
	
	public Match getMatchV3(Long gameID) throws UnsupportedEncodingException{
		System.out.print("sup1");
		ClientResource cr = new ClientResource(LOL_URI + "/match/v3/matches/" + gameID+"?api_key="+LOL_API_KEY);
		System.out.print("sup2");
		return cr.get(Match.class);
	}
}
