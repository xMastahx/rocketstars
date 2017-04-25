
package aiss.model.lol.champion;


public class ChampionMastery {

    private Long playerId;
    private Long championId;
    private Long championLevel;
    private Long championPoints;
    private Long lastPlayTime;
    private Long championPointsSinceLastLevel;
    private Long championPointsUntilNextLevel;
    private Boolean chestGranted;
    private Long tokensEarned;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public Long getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(Long championLevel) {
        this.championLevel = championLevel;
    }

    public Long getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(Long championPoints) {
        this.championPoints = championPoints;
    }

    public Long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(Long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public Long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public void setChampionPointsSinceLastLevel(Long championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public Long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(Long championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public Boolean getChestGranted() {
        return chestGranted;
    }

    public void setChestGranted(Boolean chestGranted) {
        this.chestGranted = chestGranted;
    }

    public Long getTokensEarned() {
        return tokensEarned;
    }

    public void setTokensEarned(Long tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

}
