package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.equipy.entity.Assets;

import java.util.List;
import java.util.Optional;

public interface AssertsRepository extends JpaRepository<Assets,Long>{

    @Query(value = "select * from assets where name like %:search% or serial_number like %:search%"
            ,nativeQuery = true)
Optional<List<Assets>> findAssetsByName(@Param("search") String searchField);


Optional<Assets> findAssetsBySerialNumber(String serialNumber);


Optional<Assets> findAssetsById(long id);
}

