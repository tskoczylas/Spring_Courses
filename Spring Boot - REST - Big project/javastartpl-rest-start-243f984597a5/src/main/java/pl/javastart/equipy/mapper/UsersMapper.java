package pl.javastart.equipy.mapper;

import pl.javastart.equipy.dtos.UsersDto;
import pl.javastart.equipy.entity.Users;

 public class UsersMapper {

   public static UsersDto toUsersDto(Users users){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setFirstName(users.getFirstName());
        usersDto.setLastName(users.getLastName());
        usersDto.setPesel(users.getPesel());
    return usersDto;
    }

    public static Users toUsers(UsersDto usersDto){
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setPesel(usersDto.getPesel());
        return users;

    }


}
