package pl.javastart.equipy.service;

import pl.javastart.equipy.dtos.AssetsDto;
import pl.javastart.equipy.entity.Assets;

import java.util.List;
import java.util.Optional;

public interface AssetsService {

    List<AssetsDto> getAssets();

    Optional<List<Assets>> findAssetsByNameOrSerialNumber(String searchField);

    AssetsDto saveAssets(AssetsDto assetsDto);

    Optional<Assets> findSerialNumber(String serialNumber);

    AssetsDto findAssetsById(long id);

    AssetsDto editAssets(AssetsDto assetsDto);
}
