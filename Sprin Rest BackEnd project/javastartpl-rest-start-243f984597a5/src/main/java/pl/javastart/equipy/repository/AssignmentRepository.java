package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.equipy.entity.Assignment;
import pl.javastart.equipy.entity.Users;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {

    List<Assignment> findAssignmentByUsers(Users users);

    @Query(value = "select * from assignment where asset_id = :asset order by start desc ",
            nativeQuery = true)
    List<Assignment> findAssignmentByAssets(@Param("asset") int id);

    Optional<Assignment> findAssignmentByAssetsIdAndEndNull(long id);




}
