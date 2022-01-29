package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.equipy.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findUsersByLastName(String shearchField);
    Optional<Users> findByPesel(String pesel);
    Optional<Users> findById(int id);

    @Query(value = "select * from users where last_name like %:search%" ,nativeQuery = true)
    List<Users> findUserBylastNameFr(@Param("search") String search);

}
