package pl.javastart.equipy.service;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.dtos.UsersDto;
import pl.javastart.equipy.entity.Users;
import pl.javastart.equipy.exeptions.DoublePeselExeptions;
import pl.javastart.equipy.exeptions.UsersNotFounExeption;
import pl.javastart.equipy.mapper.UsersMapper;
import pl.javastart.equipy.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImp implements UsersService {

    UsersRepository usersRepository;

    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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
    public UsersDto updateUser(UsersDto usersDto) {

        findByPesel(usersDto.getPesel()).ifPresent(u->{
            if(!(u.getId() ==(usersDto.getId())))
                throw new DoublePeselExeptions();

        });

        Users users = UsersMapper.toUsers(usersDto);
        Users save = usersRepository.save(users);
        return UsersMapper.toUsersDto(save);

    }

    @Override
    public List<UsersDto> findByLastNameFr(String searchField) {
        return usersRepository.findUserBylastNameFr(searchField).
                stream().
                map(UsersMapper::toUsersDto).
                collect(Collectors.toList());
    }


    @Override
    public UsersDto finById(int id) {

        Optional<Users> userById = usersRepository.findById(id);
        if (userById.isPresent()) return UsersMapper.toUsersDto(userById.get());
        else throw new UsersNotFounExeption();
    }

    @Override
    public Optional<Users> findByPesel(String pesel) {
        return usersRepository.findByPesel(pesel);

    }
}