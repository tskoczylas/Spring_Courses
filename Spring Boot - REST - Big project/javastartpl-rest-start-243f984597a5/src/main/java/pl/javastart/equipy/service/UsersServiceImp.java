package pl.javastart.equipy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.dtos.UsersDto;
import pl.javastart.equipy.entity.Users;
import pl.javastart.equipy.mapper.UsersMapper;
import pl.javastart.equipy.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UsersDto> getAllUsers() {
        return usersRepository.findAll().stream().map(UsersMapper::toUsersDto).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findByLastName(String searchField) {

        return usersRepository.findUsersByLastName(searchField).
                stream().
                map(UsersMapper::toUsersDto).
                collect(Collectors.toList());
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) {


        Users users = UsersMapper.toUsers(usersDto);
        Users save = usersRepository.save(users);
        return UsersMapper.toUsersDto(save);

    }

    @Override
    public Optional<UsersDto> finById(int id) {

      return usersRepository.findById(id).map(UsersMapper::toUsersDto);
    }

    @Override
    public Optional<Users> findByPesel(String pesel) {
        return usersRepository.findByPesel(pesel);

    }
}