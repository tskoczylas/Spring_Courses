package pl.javastart.equipy.mapper;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.dtos.AssetsDto;
import pl.javastart.equipy.entity.Assets;
import pl.javastart.equipy.entity.Category;
import pl.javastart.equipy.service.CategoryService;

import java.util.Optional;

@Component
public class AssetsMapper {


    CategoryService categoryService;

    public AssetsMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    public  AssetsDto toAssetsDto(Assets assets){
        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setId(assets.getId());
        assetsDto.setName(assets.getName());
        assetsDto.setDescription(assets.getDescription());

        if(assets.getCategory()!=null)assetsDto.setCategory( assets.getCategory().getName());
        assetsDto.setSerialNumber(assets.getSerialNumber());

        return assetsDto;
    }

    public  Assets toAssets(AssetsDto assetsDto){
        Optional<Category> categoryByName =
                categoryService.
                        findCategoryByName(assetsDto.getCategory());

        Assets assets = new Assets();

        assets.setId(assetsDto.getId());
        assets.setName(assetsDto.getName());
        assets.setDescription(assetsDto.getDescription());
        categoryByName.ifPresent
                (assets::setCategory);
        assets.setSerialNumber(assetsDto.getSerialNumber());

        return assets;
    }

}
