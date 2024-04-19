package go.seoul.serv.service;

import go.seoul.serv.entity.MainCulturalEvent;
import go.seoul.serv.repository.MainCulturalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCulturalEventService {
    @Autowired
    private MainCulturalEventRepository repository;

    public List<MainCulturalEvent> getAllEvents() {
        return repository.findAll();
    }

    public MainCulturalEvent getEventById(int id) {
        return repository.findById(id).orElse(null);
    }
}
