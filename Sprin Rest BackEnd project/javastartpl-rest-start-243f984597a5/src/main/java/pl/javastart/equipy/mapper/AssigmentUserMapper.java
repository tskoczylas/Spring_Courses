package pl.javastart.equipy.mapper;

import pl.javastart.equipy.dtos.AssigmentUserDto;
import pl.javastart.equipy.entity.Assignment;

public class AssigmentUserMapper {



    public static AssigmentUserDto toAssigmentAssetDto(Assignment assignment){

       AssigmentUserDto assigmentUserDto = new AssigmentUserDto();

        assigmentUserDto.setId(assignment.getId());
        assigmentUserDto.setStart(assignment.getStart());
        assigmentUserDto.setEnd(assignment.getEnd());
        assigmentUserDto.setUserId(assignment.getUsers().getId());
        assigmentUserDto.setFirstName(assignment.getUsers().getFirstName());
        assigmentUserDto.setLastName(assignment.getUsers().getLastName());
        assigmentUserDto.setPesel(assignment.getUsers().getPesel());






        return assigmentUserDto;
    }
}
