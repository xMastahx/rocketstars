
package aiss.model.lol;

import java.util.List;

public class SummonerSummary {

    private Integer summonerId;
    private List<PlayerStatSummary> playerStatSummaries = null;

    public Integer getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Integer summonerId) {
        this.summonerId = summonerId;
    }

    public List<PlayerStatSummary> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    public void setPlayerStatSummaries(List<PlayerStatSummary> playerStatSummaries) {
        this.playerStatSummaries = playerStatSummaries;
    }

}
