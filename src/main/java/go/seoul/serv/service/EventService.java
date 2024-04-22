package go.seoul.serv.service;

import go.seoul.serv.dto.CulturalEventInfoResponse;
import go.seoul.serv.dto.EventDto;
import go.seoul.serv.entity.Event;
import go.seoul.serv.repository.EventRepository;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        updateEventsFromApi();
    }

    @Scheduled(fixedRate = 3600000)
    public void updateEventsFromApi() {
        HttpURLConnection conn = null;
        BufferedReader rd = null;

        try {
            String apiKey = "";
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
            urlBuilder.append("/").append(apiKey);
            urlBuilder.append("/xml/culturalEventInfo/1/5");

            URL url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                JAXBContext jaxbContext = JAXBContext.newInstance(CulturalEventInfoResponse.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                CulturalEventInfoResponse response = (CulturalEventInfoResponse) jaxbUnmarshaller.unmarshal(rd);

                if (response != null && response.getEventList() != null && !response.getEventList().isEmpty()) {
                    List<Event> eventList = convertToEntities(response.getEventList());
                    eventRepository.saveAll(eventList);
                    System.out.println("Successfully updated events from API");
                } else {
                    System.out.println("No events found from API");
                }
            } else {
                System.out.println("API call failed with HTTP status: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private List<Event> convertToEntities(List<EventDto> events) {
        return events != null ? events.stream()
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