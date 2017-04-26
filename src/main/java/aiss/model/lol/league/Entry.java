package aiss.model.lol.league;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"isFreshBlood",
"division",
"isVeteran",
"miniSeries",
"wins",
"losses",
"playerOrTeamId",
"playerOrTeamName",
"isInactive",
"isHotStreak",
"leaguePoints"
})
public class Entry {

@JsonProperty("isFreshBlood")
private Boolean isFreshBlood;
@JsonProperty("division")
private String division;
@JsonProperty("isVeteran")
private Boolean isVeteran;
@JsonProperty("miniSeries")
private MiniSeries miniSeries;
@JsonProperty("wins")
private Integer wins;
@JsonProperty("losses")
private Integer losses;
@JsonProperty("playerOrTeamId")
private String playerOrTeamId;
@JsonProperty("playerOrTeamName")
private String playerOrTeamName;
@JsonProperty("isInactive")
private Boolean isInactive;
@JsonProperty("isHotStreak")
private Boolean isHotStreak;
@JsonProperty("leaguePoints")
private Integer leaguePoints;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("isFreshBlood")
public Boolean getIsFreshBlood() {
return isFreshBlood;
}

@JsonProperty("isFreshBlood")
public void setIsFreshBlood(Boolean isFreshBlood) {
this.isFreshBlood = isFreshBlood;
}

@JsonProperty("division")
public String getDivision() {
return division;
}

@JsonProperty("division")
public void setDivision(String division) {
this.division = division;
}

@JsonProperty("isVeteran")
public Boolean getIsVeteran() {
return isVeteran;
}

@JsonProperty("isVeteran")
public void setIsVeteran(Boolean isVeteran) {
this.isVeteran = isVeteran;
}

@JsonProperty("miniSeries")
public MiniSeries getMiniSeries() {
return miniSeries;
}

@JsonProperty("miniSeries")
public void setMiniSeries(MiniSeries miniSeries) {
this.miniSeries = miniSeries;
}

@JsonProperty("wins")
public Integer getWins() {
return wins;
}

@JsonProperty("wins")
public void setWins(Integer wins) {
this.wins = wins;
}

@JsonProperty("losses")
public Integer getLosses() {
return losses;
}

@JsonProperty("losses")
public void setLosses(Integer losses) {
this.losses = losses;
}

@JsonProperty("playerOrTeamId")
public String getPlayerOrTeamId() {
return playerOrTeamId;
}

@JsonProperty("playerOrTeamId")
public void setPlayerOrTeamId(String playerOrTeamId) {
this.playerOrTeamId = playerOrTeamId;
}

@JsonProperty("playerOrTeamName")
public String getPlayerOrTeamName() {
return playerOrTeamName;
}

@JsonProperty("playerOrTeamName")
public void setPlayerOrTeamName(String playerOrTeamName) {
this.playerOrTeamName = playerOrTeamName;
}

@JsonProperty("isInactive")
public Boolean getIsInactive() {
return isInactive;
}

@JsonProperty("isInactive")
public void setIsInactive(Boolean isInactive) {
this.isInactive = isInactive;
}

@JsonProperty("isHotStreak")
public Boolean getIsHotStreak() {
return isHotStreak;
}

@JsonProperty("isHotStreak")
public void setIsHotStreak(Boolean isHotStreak) {
this.isHotStreak = isHotStreak;
}

@JsonProperty("leaguePoints")
public Integer getLeaguePoints() {
return leaguePoints;
}

@JsonProperty("leaguePoints")
public void setLeaguePoints(Integer leaguePoints) {
this.leaguePoints = leaguePoints;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}