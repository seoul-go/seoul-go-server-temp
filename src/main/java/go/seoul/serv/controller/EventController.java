package go.seoul.serv.controller;

import go.seoul.serv.entity.Event;
import go.seoul.serv.exception.ResourceNotFoundException;
import go.seoul.serv.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // 클라이언트가 모든 이벤트를 불러올 수 있는 API
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // ID에 해당하는 단일 이벤트를 불러오는 API
    @GetMapping("{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
    }
}
