package go.seoul.serv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {

    @JsonProperty("MAIN_IMG")
    private String mainImg;

    @JsonProperty("CODENAME")
    private String codename;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("DATE")
    private String date;

    @JsonProperty("PLACE")
    private String place;
}
