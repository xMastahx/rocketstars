
package aiss.model.lol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AggregatedStats {

    private Integer totalChampionKills;
    private Integer totalTurretsKilled;
    private Integer totalAssists;
    private Integer totalMinionKills;
    private Integer totalNeutralMinionsKilled;

    public Integer getTotalChampionKills() {
        return totalChampionKills;
    }

    public void setTotalChampionKills(Integer totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    public Integer getTotalTurretsKilled() {
        return totalTurretsKilled;
    }

    public void setTotalTurretsKilled(Integer totalTurretsKilled) {
        this.totalTurretsKilled = totalTurretsKilled;
    }

    public Integer getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(Integer totalAssists) {
        this.totalAssists = totalAssists;
    }

    public Integer getTotalMinionKills() {
        return totalMinionKills;
    }

    public void setTotalMinionKills(Integer totalMinionKills) {
        this.totalMinionKills = totalMinionKills;
    }

    public Integer getTotalNeutralMinionsKilled() {
        return totalNeutralMinionsKilled;
    }

    public void setTotalNeutralMinionsKilled(Integer totalNeutralMinionsKilled) {
        this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
    }

}
