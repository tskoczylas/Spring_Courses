package pl.javastart.equipy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.javastart.equipy.dtos.AssigmentAssetDto;
import pl.javastart.equipy.dtos.AssigmentDto;
import pl.javastart.equipy.dtos.AssigmentUserDto;
import pl.javastart.equipy.service.AssignmentService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AssigmentController {

    AssignmentService assignmentService;

    public AssigmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/api/users/{userId}/assignments")
    ResponseEntity<List<AssigmentAssetDto>>
    getAllAssigmentByUserId(@PathVariable("userId")int userId)
    {
        return ResponseEntity
                .ok()
                .body(assignmentService.getListOfAssetsByUser(userId));
    }

    @GetMapping("/api/assets/{assetId}/assignments")
    ResponseEntity<List<AssigmentUserDto>> getAllAssigmentsByAssetsId(
            @PathVariable("assetId") int assetId){

        return ResponseEntity
                .ok()
                .body(assignmentService.getListOfAssetsByAssets(assetId));

    }

    @PostMapping("/api/assignments")
    ResponseEntity<AssigmentDto> assignUsertoAsset(@RequestBody AssigmentDto a){



        AssigmentDto save = assignmentService.save(a);


        return ResponseEntity.ok().body(save);
    }

    @PostMapping("/api/assignments/{id}/end")
   ResponseEntity<LocalDateTime> addEndToAssigment(
            @PathVariable("id") int id )
    {
              assignmentService.addEndDatetoAssigment(id);

        return ResponseEntity.ok().body(LocalDateTime.now());
    }



}
