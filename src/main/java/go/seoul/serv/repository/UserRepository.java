package go.seoul.serv.repository;

import go.seoul.serv.entity.UserEntity;
import go.seoul.serv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //쿼리 작성
    UserEntity findByUsername(String username);
}
