package go.seoul.serv.service;

import go.seoul.serv.entity.MainCulturalEventEntity;
import go.seoul.serv.repository.MainCulturalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class MainCulturalEventService {
    @Autowired
    private MainCulturalEventRepository repository;

    public List<MainCulturalEventEntity> getAllEvents() {
        return repository.findAll();
    }

    public MainCulturalEventEntity getEventById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<MainCulturalEventEntity> getEventsEndingWithinAMonth() {
        Date today = new Date();
        Date oneMonthLater = org.apache.commons.lang3.time.DateUtils.addMonths(today, 1);

        return repository.findAllByEndDateBetween(today, oneMonthLater);
    }
}
