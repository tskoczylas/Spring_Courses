package pl.javastart.equipy.service;

import pl.javastart.equipy.dtos.AssigmentAssetDto;
import pl.javastart.equipy.dtos.AssigmentDto;
import pl.javastart.equipy.dtos.AssigmentUserDto;

import java.util.List;

public interface AssignmentService {

    List<AssigmentAssetDto> getListOfAssetsByUser(int  usersID);


    List<AssigmentUserDto> getListOfAssetsByAssets(int assetId);

    void addEndDatetoAssigment(int id);

    AssigmentDto save(AssigmentDto a);
}
