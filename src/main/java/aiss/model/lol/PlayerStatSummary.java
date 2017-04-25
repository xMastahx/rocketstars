
package aiss.model.lol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PlayerStatSummary {

    private String playerStatSummaryType;
    private Integer wins;
 //   private Integer modifyDate;
    private AggregatedStats aggregatedStats;
    private Integer losses;

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType(String playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

//    public Integer getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Integer modifyDate) {
//        this.modifyDate = modifyDate;
//    }

    public AggregatedStats getAggregatedStats() {
        return aggregatedStats;
    }

    public void setAggregatedStats(AggregatedStats aggregatedStats) {
        this.aggregatedStats = aggregatedStats;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

}
