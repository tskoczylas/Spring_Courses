package pl.javastart.equipy.mapper;

import pl.javastart.equipy.dtos.AssigmentDto;
import pl.javastart.equipy.entity.Assignment;

public class AssigmentSavedMapper {

    public static AssigmentDto toAssigmentDto(Assignment assignment){

        AssigmentDto assigmentDto = new AssigmentDto();
        assigmentDto.setId(assignment.getId());
        assigmentDto.setAssetId((int) assignment.getAssets().getId());
        assigmentDto.setUserId(assignment.getUsers().getId());



        return assigmentDto;
    }

}
