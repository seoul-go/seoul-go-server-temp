package go.seoul.serv.controller;

import go.seoul.serv.entity.MainCulturalEvent;
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
    public List<MainCulturalEvent> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public MainCulturalEvent getEventById(@PathVariable int id) {
        return service.getEventById(id);
    }
}
