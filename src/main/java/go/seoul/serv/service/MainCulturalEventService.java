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

    // 한 달 이내에 종료되는 행사
    public List<MainCulturalEventEntity> getEventsEndingWithinAMonth() {
        Date today = new Date();
        Date oneMonthLater = org.apache.commons.lang3.time.DateUtils.addMonths(today, 1);
        return repository.findEventsEndingWithinAMonth(today, oneMonthLater);
    }
    // 최근 2주 이내에 시작된 행사
    public List<MainCulturalEventEntity> getEventsStartedWithinTwoWeeks() {
        Date today = new Date();
        Date twoWeeksAgo = org.apache.commons.lang3.time.DateUtils.addWeeks(today, -2);
        return repository.findEventsStartedWithinTwoWeeks(twoWeeksAgo, today);
    }

}
