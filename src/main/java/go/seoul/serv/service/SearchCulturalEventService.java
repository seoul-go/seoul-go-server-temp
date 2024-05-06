package go.seoul.serv.service;

import go.seoul.serv.entity.SearchCulturalEventEntity;
import go.seoul.serv.repository.SearchCulturalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCulturalEventService {
    private final SearchCulturalEventRepository repository;

    @Autowired
    public SearchCulturalEventService(SearchCulturalEventRepository repository) {
        this.repository = repository;
    }

    public List<SearchCulturalEventEntity> getAllSearchCulturalEvents() {
        return repository.findAll();
    }

    public SearchCulturalEventEntity getSearchCulturalEventById(int id) {
        return repository.findById(id).orElse(null);
    }
}
