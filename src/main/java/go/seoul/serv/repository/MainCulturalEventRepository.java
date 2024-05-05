package go.seoul.serv.repository;

import go.seoul.serv.entity.MainCulturalEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MainCulturalEventRepository extends JpaRepository<MainCulturalEventEntity, Integer> {
    List<MainCulturalEventEntity> findAllByEndDateBetween(Date start, Date end);
    List<MainCulturalEventEntity> findAllByStartDateBetween(Date start, Date end);
}
