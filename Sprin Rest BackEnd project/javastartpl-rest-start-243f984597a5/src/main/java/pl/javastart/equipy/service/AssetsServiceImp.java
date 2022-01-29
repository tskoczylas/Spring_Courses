package pl.javastart.equipy.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.equipy.dtos.AssetsDto;
import pl.javastart.equipy.entity.Assets;
import pl.javastart.equipy.mapper.AssetsMapper;
import pl.javastart.equipy.repository.AssertsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AssetsServiceImp implements AssetsService{


    AssertsRepository assertsRepository;
    AssetsMapper assetsMapper;

    public AssetsServiceImp(AssertsRepository assertsRepository, AssetsMapper assetsMapper) {
        this.assertsRepository = assertsRepository;
        this.assetsMapper = assetsMapper;
    }

    @Override
    public List<AssetsDto> getAssets() {
        return assertsRepository.
                findAll().
                stream().
                map(assetsMapper::toAssetsDto).
                collect(Collectors.toList());
    }

    public Optional<List<Assets>> findAssetsByNameOrSerialNumber(String searchField){

        return assertsRepository.
                findAssetsByName(searchField);

    }

    @Override
    public AssetsDto saveAssets(AssetsDto assetsDto) {

        Assets assets = assetsMapper.toAssets(assetsDto);
        Assets save = assertsRepository.save(assets);
        AssetsDto savedAssetsDto = assetsMapper.toAssetsDto(save);
        return savedAssetsDto;
    }

    @Override
    public Optional<Assets> findSerialNumber(String serialNumber) {

        return assertsRepository.findAssetsBySerialNumber(serialNumber);
    }

    @Override
    public AssetsDto findAssetsById(long id) {

        Optional<Assets> assetsById = assertsRepository.findAssetsById(id);

        if(!assetsById.isPresent())
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Nie znaleziono Assets z podanym id");

        else return assetsMapper.toAssetsDto(assetsById.get());

    }

    @Override
    public AssetsDto editAssets(AssetsDto assetsDto) {
        Optional<Assets> assetsBySerialNumber =
                assertsRepository.
                        findAssetsBySerialNumber(assetsDto.getSerialNumber());

        assetsBySerialNumber.ifPresent(assets -> {
            if(assets.getId()!=(assetsDto.getId()))
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Podany numer seryjny już istniej"); });

        Assets savedAssets = assertsRepository.
                save(assetsMapper.toAssets(assetsDto));

        AssetsDto savedAssetsDto = assetsMapper.
                toAssetsDto(savedAssets);


        return savedAssetsDto;
                }

    }



