package go.seoul.serv.service;

import go.seoul.serv.entity.DetailCulturalEvent;
import go.seoul.serv.repository.DetailCulturalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailCulturalEventService {
    private final DetailCulturalEventRepository repository;

    @Autowired
    public DetailCulturalEventService(DetailCulturalEventRepository repository) {
        this.repository = repository;
    }

    public List<DetailCulturalEvent> getAllDetailCulturalEvents() {
        return repository.findAll();
    }

    public Optional<DetailCulturalEvent> getDetailCulturalEventById(int id) {
        return repository.findById(id);
    }
}
