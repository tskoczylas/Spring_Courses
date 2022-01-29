package pl.toms.settingseciuirty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.toms.settingseciuirty.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findUserByUser(String user);

}
