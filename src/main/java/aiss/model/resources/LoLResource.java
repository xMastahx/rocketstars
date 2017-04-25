package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.lol.Summoner;
import aiss.model.lol.SummonerSummary;
import aiss.model.lol.champion.Champion;
import aiss.model.lol.champion.ChampionMastery;

public class LoLResource {
	private static final String LOL_API_KEY = "RGAPI-ad93d607-ea76-4425-bc3f-9a4f9f23e1f1";
	private static final Logger log = Logger.getLogger(LoLResource.class.getName());
	
	public Summoner getSummoner(String name) throws UnsupportedEncodingException {
		ClientResource cr = new ClientResource("https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key="+LOL_API_KEY);
		Summoner res = cr.get(Summoner.class);
		return res;
	}
	
	public SummonerSummary getSummonerSummary(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource("https://euw1.api.riotgames.com/api/lol/euw/v1.3/stats/by-summoner/"+ summonerID+"/summary?api_key="+LOL_API_KEY);
		SummonerSummary res = cr.get(SummonerSummary.class);
		return res;
	}
	
	public ChampionMastery[] getChampionMastery(Integer summonerID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource("https://euw1.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/"+summonerID+"?api_key="+LOL_API_KEY);
		ChampionMastery[] res = cr.get(ChampionMastery[].class);
		return res;
	}
	
	public Champion getChampionData(Long championID) throws UnsupportedEncodingException{
		ClientResource cr = new ClientResource("https://euw1.api.riotgames.com/lol/static-data/v3/champions/"+championID+"?champData=image&api_key="+LOL_API_KEY);
		return cr.get(Champion.class);
	}
	
}
