package go.seoul.serv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDto {
    @XmlElement(name = "MAIN_IMG")
    private String mainImg;

    @XmlElement(name = "CODENAME")
    private String codename;

    @XmlElement(name = "TITLE")
    private String title;

    @XmlElement(name = "DATE")
    private String date;

    @XmlElement(name = "PLACE")
    private String place;

    // 기타 필드와 getter/setter
}
