
package aiss.model.lol.runes;

import java.util.List;

public class RunesSummary {

    private Integer summonerId;
    private List<Page> pages = null;

    public Integer getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Integer summonerId) {
        this.summonerId = summonerId;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

}
