package go.seoul.serv.controller;

import go.seoul.serv.entity.DetailCulturalEvent;
import go.seoul.serv.entity.MainCulturalEvent;
import go.seoul.serv.service.DetailCulturalEventService;
import go.seoul.serv.service.MainCulturalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detailCulturalEvents")
public class DetailCulturalEventController {
    @Autowired
    private DetailCulturalEventService service;

    @GetMapping
    public List<DetailCulturalEvent> getAllEvents() {
        return service.getAllDetailCulturalEvents();
    }

    @GetMapping("/{id}")
    public DetailCulturalEvent getEventById(@PathVariable int id) {
        return service.getAllDetailCulturalEvents().get(id);
    }
}










