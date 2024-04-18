package go.seoul.serv.service;

import go.seoul.serv.dto.EventDto;
import go.seoul.serv.entity.Event;
import go.seoul.serv.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void updateEventsFromApi() {
        String apiUrl = "여기에 Open API URL을 넣으세요";
        EventDto[] events = restTemplate.getForObject(apiUrl, EventDto[].class);
        List<Event> eventList = convertToEntities(events);
        eventRepository.saveAll(eventList);
    }

    private List<Event> convertToEntities(EventDto[] events) {
        return events != null ? Arrays.stream(events)
                .map(e -> {
                    Event event = new Event();
                    event.setMainImg(e.getMainImg());
                    event.setCodename(e.getCodename());
                    event.setTitle(e.getTitle());
                    event.setDate(e.getDate());
                    event.setPlace(e.getPlace());
                    return event;
                }).collect(Collectors.toList()) : new ArrayList<>();
    }
}
