package pl.javastart.equipy.mapper;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.dtos.AssigmentAssetDto;
import pl.javastart.equipy.dtos.AssigmentDto;
import pl.javastart.equipy.entity.Assets;
import pl.javastart.equipy.entity.Assignment;
import pl.javastart.equipy.entity.Users;
import pl.javastart.equipy.service.AssetsService;
import pl.javastart.equipy.service.UsersService;


@Component
public class AssigmentMapper {

    UsersService usersService;
    AssetsService assetsService;
    AssetsMapper assetsMapper;

    public AssigmentMapper(UsersService usersService, AssetsService assetsService, AssetsMapper assetsMapper) {
        this.usersService = usersService;
        this.assetsService = assetsService;
        this.assetsMapper = assetsMapper;
    }

    public AssigmentAssetDto toAssigmentDto(Assignment assignment){


        AssigmentAssetDto assigmentAssetDto = new AssigmentAssetDto();
        assigmentAssetDto.setAssetId(assignment.getId());
        assigmentAssetDto.setStart(assignment.getStart());
        assigmentAssetDto.setEnd(assignment.getEnd());
        assigmentAssetDto.setAssetId((int) assignment.getAssets().getId());
        assigmentAssetDto.setAssetName(assignment.getAssets().getName());
        assigmentAssetDto.setId(assignment.getId());
        assigmentAssetDto.setAssetSerialNumber(assignment.getAssets().getSerialNumber());



        return assigmentAssetDto;


    }



    public Assignment toAssigment(AssigmentDto a){

        Users users = UsersMapper.
                toUsers
                        (usersService.
                                finById
                                        (a.getUserId()));
        Assets assetsById = assetsMapper.
                toAssets(assetsService.
                        findAssetsById(a.getAssetId()));

        Assignment assignment= new Assignment();
        assignment.setAssets(assetsById);
        assignment.setUsers(users);


        return assignment;
    }




}
