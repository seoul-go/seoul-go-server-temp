package go.seoul.serv.service;

import go.seoul.serv.entity.DetailCulturalEventEntity;
import go.seoul.serv.repository.DetailCulturalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailCulturalEventService {
    private final DetailCulturalEventRepository repository;

    @Autowired
    public DetailCulturalEventService(DetailCulturalEventRepository repository) {
        this.repository = repository;
    }

    public List<DetailCulturalEventEntity> getAllDetailCulturalEvents() {
        return repository.findAll();
    }

    public DetailCulturalEventEntity getDetailCulturalEventById(int id) {
        return repository.findById(id).orElse(null);
    }

}