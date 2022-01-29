package pl.toms.settingseciuirty.service;

import org.springframework.stereotype.Service;
import pl.toms.settingseciuirty.entity.User;
import pl.toms.settingseciuirty.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {
    UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findUserByUser(String user) {
        return userRepo.findUserByUser(user);
    }
}
