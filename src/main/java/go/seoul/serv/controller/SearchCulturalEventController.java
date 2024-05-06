package go.seoul.serv.controller;

import go.seoul.serv.entity.SearchCulturalEventEntity;
import go.seoul.serv.service.SearchCulturalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/searchCulturalEvents")
public class SearchCulturalEventController {
    @Autowired
    private SearchCulturalEventService service;

    @GetMapping
    public List<SearchCulturalEventEntity> getAllEvents() {
        return service.getAllSearchCulturalEvents();
    }

    @GetMapping("/{id}")
    public SearchCulturalEventEntity getEventById(@PathVariable int id) {
        return service.getSearchCulturalEventById(id);
    }
}
