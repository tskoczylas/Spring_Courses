package pl.javastart.equipy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.equipy.dtos.AssetsDto;
import pl.javastart.equipy.entity.Assets;
import pl.javastart.equipy.mapper.AssetsMapper;
import pl.javastart.equipy.service.AssetsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/assets")
public class AssetsController {

    AssetsService assetsService;
    AssetsMapper assetsMapper;

    public AssetsController(AssetsService assetsService,AssetsMapper assetsMapper) {
        this.assetsService = assetsService;
        this.assetsMapper = assetsMapper;
    }

    @GetMapping
    ResponseEntity<List<AssetsDto>> getAssets(
            @RequestParam(name = "text",required =false) String searchField)
    {
        Optional<List<Assets>> assetsByNameOrSerialNumber =
                assetsService.findAssetsByNameOrSerialNumber(searchField);

        return assetsByNameOrSerialNumber.map(
                assets -> ResponseEntity.ok().body(assets.
                stream().
                map(assetsMapper::toAssetsDto).
                collect(Collectors.toList()))).
                orElseGet(() -> ResponseEntity.ok().body(assetsService.getAssets()));



    }

    @PostMapping
    ResponseEntity<AssetsDto> saveAssets(@RequestBody AssetsDto assetsDto){
        System.out.println(assetsDto.getId());

        Optional<Assets> assetsrSerialNumber =
                assetsService.findSerialNumber(assetsDto.getSerialNumber());


        assetsrSerialNumber.ifPresent(a->{
            if(a.getSerialNumber().equals(assetsDto.getSerialNumber()))
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT,
                            "Wyposażenie z takim numerem seryjnym już istnijee");
        });

        if(assetsDto.getId()!=0){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Wyposażenie z takim numerem id już istnieje");}
        AssetsDto savedAssetsDto=assetsService.saveAssets(assetsDto);



        return ResponseEntity.ok().body(assetsDto);
    }

    @GetMapping("{id}")
    ResponseEntity<AssetsDto> supplyAssetsForEdit(@PathVariable long id)
    {

    AssetsDto assetsDto =
            assetsService.findAssetsById(id);

        return ResponseEntity.ok().body(assetsDto);
    }

    @PutMapping("{id}")
    ResponseEntity<AssetsDto> editAssets(
            @PathVariable long id,
            @RequestBody AssetsDto assetsDto){

        if(id!=assetsDto.getId()) throw new ResponseStatusException
                (HttpStatus.BAD_REQUEST,
        "Podany numer id nie jest zgodny z przesłanymi danymi");
        else
            return ResponseEntity.ok().body(
                    assetsService.editAssets(assetsDto) );

    }


}
