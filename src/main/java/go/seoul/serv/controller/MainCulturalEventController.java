package go.seoul.serv.controller;

import go.seoul.serv.entity.MainCulturalEventEntity;
import go.seoul.serv.service.MainCulturalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mainCulturalEvents")
public class MainCulturalEventController {
    @Autowired
    private MainCulturalEventService service;

    @GetMapping
    public List<MainCulturalEventEntity> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public MainCulturalEventEntity getEventById(@PathVariable int id) {
        return service.getEventById(id);
    }

    //마감이 한달 이내인 행사 조회
    @GetMapping("/ending-soon")
    public List<MainCulturalEventEntity> getEndingSoonEvents() {
        return service.getEventsEndingWithinAMonth();
    }

    //최근에 올라온 행사 조회
    @GetMapping("/recently-started")
    public List<MainCulturalEventEntity> getRecentlyStartedEvents() {
        return service.getEventsStartedWithinTwoWeeks();
    }
}
