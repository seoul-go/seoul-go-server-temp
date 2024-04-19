package go.seoul.serv.controller;

import go.seoul.serv.entity.DetailCulturalEvent;
import go.seoul.serv.service.DetailCulturalEventService;
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
    private final DetailCulturalEventService service;

    @Autowired
    public DetailCulturalEventController(DetailCulturalEventService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetailCulturalEvent> getAllDetailCulturalEvents() {
        return service.getAllDetailCulturalEvents();
    }

    @GetMapping("/{id}")
    public DetailCulturalEvent getDetailCulturalEventById(@PathVariable("id") int id) {
        Optional<DetailCulturalEvent> detailCulturalEvent = service.getDetailCulturalEventById(id);
        return detailCulturalEvent.orElse(null); // 또는 존재하지 않는 id에 대해 예외 처리를 할 수 있습니다.
    }

}
