package go.seoul.serv.repository;

import go.seoul.serv.entity.MainCulturalEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MainCulturalEventRepository extends JpaRepository<MainCulturalEventEntity, Integer> {
    // 한 달 이내에 종료되는 행사 조회
    @Query("SELECT m FROM MainCulturalEventEntity m WHERE m.endDate BETWEEN :start AND :end")
    List<MainCulturalEventEntity> findEventsEndingWithinAMonth(Date start, Date end);

    // 최근 2주 이내에 시작된 행사 조회
    @Query("SELECT m FROM MainCulturalEventEntity m WHERE m.startDate BETWEEN :start AND :end")
    List<MainCulturalEventEntity> findEventsStartedWithinTwoWeeks(Date start, Date end);
}
