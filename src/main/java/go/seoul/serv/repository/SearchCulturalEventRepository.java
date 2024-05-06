package go.seoul.serv.repository;

import go.seoul.serv.entity.SearchCulturalEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchCulturalEventRepository extends JpaRepository<SearchCulturalEventEntity, Integer> {
}
