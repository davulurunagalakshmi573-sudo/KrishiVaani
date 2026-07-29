package com.krishivaani.repository;

import com.krishivaani.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {

}