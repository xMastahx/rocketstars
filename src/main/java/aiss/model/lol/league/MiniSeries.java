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
"wins",
"losses",
"target",
"progress"
})
public class MiniSeries {

@JsonProperty("wins")
private Integer wins;
@JsonProperty("losses")
private Integer losses;
@JsonProperty("target")
private Integer target;
@JsonProperty("progress")
private String progress;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

@JsonProperty("target")
public Integer getTarget() {
return target;
}

@JsonProperty("target")
public void setTarget(Integer target) {
this.target = target;
}

@JsonProperty("progress")
public String getProgress() {
return progress;
}

@JsonProperty("progress")
public void setProgress(String progress) {
this.progress = progress;
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