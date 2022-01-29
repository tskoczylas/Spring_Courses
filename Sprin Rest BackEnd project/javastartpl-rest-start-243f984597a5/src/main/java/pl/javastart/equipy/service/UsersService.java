package pl.javastart.equipy.service;

import pl.javastart.equipy.dtos.UsersDto;
import pl.javastart.equipy.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<UsersDto> getAllUsers();

    List<UsersDto> findByLastName(String searchField);

    UsersDto saveUser(UsersDto usersDto);

    UsersDto updateUser(UsersDto usersDto);

    List<UsersDto> findByLastNameFr(String searchField);



    UsersDto finById(int id);

    Optional<Users> findByPesel(String pesel);

}
