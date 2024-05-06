package go.seoul.serv.repository;

import go.seoul.serv.entity.SearchCulturalEventEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SearchCulturalEventRepository extends JpaRepository<SearchCulturalEventEntity, Integer> {
    @Query("SELECT s FROM SearchCulturalEventEntity s WHERE s.codename = :codename AND s.endDate > :today")
    List<SearchCulturalEventEntity> findActiveEventsByCodename(@Param("codename") String codename, @Param("today") Date today);
}
