package go.seoul.serv.controller;

import go.seoul.serv.entity.DetailCulturalEventEntity;
import go.seoul.serv.service.DetailCulturalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detailCulturalEvents")
public class DetailCulturalEventController {
    @Autowired
    private DetailCulturalEventService service;

    @GetMapping
    public List<DetailCulturalEventEntity> getAllEvents() {
        return service.getAllDetailCulturalEvents();
    }

    @GetMapping("/{id}")
    public DetailCulturalEventEntity getEventById(@PathVariable int id) {
        return service.getAllDetailCulturalEvents().get(id);
    }
}










