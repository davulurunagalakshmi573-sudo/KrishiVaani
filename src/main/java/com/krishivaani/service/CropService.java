package com.krishivaani.service;

import com.krishivaani.entity.Crop;
import com.krishivaani.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }
}