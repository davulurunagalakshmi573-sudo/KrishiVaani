package com.krishivaani.repository;

import com.krishivaani.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByCropName(String cropName);

}