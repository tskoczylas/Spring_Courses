package pl.javastart.equipy.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.equipy.dtos.AssigmentAssetDto;
import pl.javastart.equipy.dtos.AssigmentDto;
import pl.javastart.equipy.dtos.AssigmentUserDto;
import pl.javastart.equipy.entity.Assets;
import pl.javastart.equipy.entity.Assignment;
import pl.javastart.equipy.entity.Users;
import pl.javastart.equipy.mapper.AssigmentMapper;
import pl.javastart.equipy.mapper.AssigmentSavedMapper;
import pl.javastart.equipy.mapper.AssigmentUserMapper;
import pl.javastart.equipy.repository.AssertsRepository;
import pl.javastart.equipy.repository.AssignmentRepository;
import pl.javastart.equipy.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImp implements AssignmentService {

AssignmentRepository assignmentRepository;
UsersRepository usersRepository;
AssertsRepository assertsRepository;
AssigmentMapper assigmentMapper;

    public AssignmentServiceImp(AssignmentRepository assignmentRepository, UsersRepository usersRepository, AssertsRepository assertsRepository, AssigmentMapper assigmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.usersRepository = usersRepository;
        this.assertsRepository = assertsRepository;
        this.assigmentMapper = assigmentMapper;
    }

    public List<AssigmentAssetDto> getListOfAssetsByUser(int  usersID){

        Optional<Users> usersByid = usersRepository.findById(usersID);


       if (!usersByid.isPresent())
           throw new ResponseStatusException(HttpStatus.CONFLICT);

           else return assignmentRepository.
               findAssignmentByUsers(usersByid.get()).
                   stream().
                   map(assigmentMapper::toAssigmentDto).
                   collect(Collectors.toList());
    }

    @Override
    public List<AssigmentUserDto> getListOfAssetsByAssets(int assetId) {
        Optional<Assets> assetsById = assertsRepository.findAssetsById(assetId);



        if (!assetsById.isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        else return assignmentRepository.
                findAssignmentByAssets((int) assetsById.get().getId()).
                stream().
                map(AssigmentUserMapper::toAssigmentAssetDto).
                collect(Collectors.toList());
    }

    @Override
    public void addEndDatetoAssigment(int id) {
        Optional<Assignment> byId = assignmentRepository.findById(id);
        byId.ifPresentOrElse(assignment ->
                {
                    Optional<Assignment> assignmentByAssetsIdAndEndNull = assignmentRepository.
                            findAssignmentByAssetsIdAndEndNull(assignment.getAssets().getId());
                    if(!assignmentByAssetsIdAndEndNull.isPresent()) throw
                            new ResponseStatusException(HttpStatus.BAD_REQUEST," " +
                                    "wyposażenie ma już przypisaną datę zwrotu");

                    assignment.setEnd(LocalDateTime.now());

                    assignmentRepository.save(assignment);


                },
                ()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"assignmentId nie wskazuje" +
                        " na żadne wypożyczenie,");});


    }

    @Override
    public AssigmentDto save(AssigmentDto a) {

        Optional<Assignment> assignmentByAssetsIdAndEndNull =
                assignmentRepository.
                        findAssignmentByAssetsIdAndEndNull(a.getAssetId());

      if(assignmentByAssetsIdAndEndNull.isPresent()) throw  new
              ResponseStatusException(HttpStatus.BAD_REQUEST,
              "Podany użytkownik ma już przypisany i nie oddany przedmiot ");

        if(a.getAssetId()==0||
                a.getUserId()==0
        ) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Assignment save = assignmentRepository.
                save(assigmentMapper.
                        toAssigment(a));

        return AssigmentSavedMapper.toAssigmentDto(save);
    }

}
