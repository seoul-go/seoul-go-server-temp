package go.seoul.serv.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "culturalEventInfo")
public class CulturalEventInfoResponse {

    private List<EventDto> eventList;

    @XmlElement(name = "eventList")
    public List<EventDto> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventDto> eventList) {
        this.eventList = eventList;
    }
}

