package back.domain.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import back.domain.enums.Situation;
import back.domain.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {

    @Query("SELECT obj FROM Title obj WHERE obj.user.id = :userId")
    List<Title> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT obj FROM Title obj WHERE obj.user.id = :userId AND obj.situation = :situation")
    List<Title> findByUserIdAndSituation(@Param("userId") Integer userId, @Param("situation") Situation situation);
}

