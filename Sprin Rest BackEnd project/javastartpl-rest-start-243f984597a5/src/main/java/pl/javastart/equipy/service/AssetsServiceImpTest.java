package pl.javastart.equipy.service;

import org.junit.jupiter.api.Test;
import pl.javastart.equipy.mapper.AssetsMapper;
import pl.javastart.equipy.repository.AssertsRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AssetsServiceImpTest {

    @Test
    void getAssets() {
        //givven
        AssertsRepository assertsRepository = mock(AssertsRepository.class);
        AssetsMapper assetsMapper = mock(AssetsMapper.class);

        AssetsService assetsService = new AssetsServiceImp(assertsRepository,assetsMapper);

        //then

        assertThat(assetsService.getAssets(),hasSize(0));


    }

    @Test
    void findAssetsByNameOrSerialNumber() {
    }

    @Test
    void saveAssets() {
    }

    @Test
    void findSerialNumber() {
    }

    @Test
    void findAssetsById() {
    }

    @Test
    void editAssets() {
    }
}