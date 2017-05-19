
package aiss.model.lol.match;

import java.util.List;

public class Team {

    private Long teamId;
    private String win;
    private Boolean firstBlood;
    private Boolean firstTower;
    private Boolean firstInhibitor;
    private Boolean firstBaron;
    private Boolean firstDragon;
    private Boolean firstRiftHerald;
    private Long towerKills;
    private Long inhibitorKills;
    private Long baronKills;
    private Long dragonKills;
    private Long vilemawKills;
    private Long riftHeraldKills;
    private Long dominionVictoryScore;
    private List<Ban> bans = null;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Boolean getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(Boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    public Boolean getFirstTower() {
        return firstTower;
    }

    public void setFirstTower(Boolean firstTower) {
        this.firstTower = firstTower;
    }

    public Boolean getFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor(Boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    public Boolean getFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron(Boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    public Boolean getFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon(Boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    public Boolean getFirstRiftHerald() {
        return firstRiftHerald;
    }

    public void setFirstRiftHerald(Boolean firstRiftHerald) {
        this.firstRiftHerald = firstRiftHerald;
    }

    public Long getTowerKills() {
        return towerKills;
    }

    public void setTowerKills(Long towerKills) {
        this.towerKills = towerKills;
    }

    public Long getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(Long inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public Long getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(Long baronKills) {
        this.baronKills = baronKills;
    }

    public Long getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(Long dragonKills) {
        this.dragonKills = dragonKills;
    }

    public Long getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills(Long vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    public Long getRiftHeraldKills() {
        return riftHeraldKills;
    }

    public void setRiftHeraldKills(Long riftHeraldKills) {
        this.riftHeraldKills = riftHeraldKills;
    }

    public Long getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore(Long dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public List<Ban> getBans() {
        return bans;
    }

    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

}
