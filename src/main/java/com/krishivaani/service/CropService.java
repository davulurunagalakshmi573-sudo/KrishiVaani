package com.krishivaani.service;

import com.krishivaani.entity.Crop;
import com.krishivaani.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    public Crop getCropById(Long id) {
    return cropRepository.findById(id).orElse(null);
}
public Crop updateCrop(Long id, Crop updatedCrop) {
    Crop crop = cropRepository.findById(id).orElse(null);

    if (crop != null) {
        crop.setCropName(updatedCrop.getCropName());
        crop.setQuantity(updatedCrop.getQuantity());
        crop.setPrice(updatedCrop.getPrice());
        crop.setFarmerName(updatedCrop.getFarmerName());

        return cropRepository.save(crop);
    }

    return null;
}
public void deleteCrop(Long id) {
    cropRepository.deleteById(id);
}
public List<Crop> getCropByName(String cropName) {
    return cropRepository.findByCropName(cropName);
}
public Page<Crop> getAllCrops(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return cropRepository.findAll(pageable);
}
}