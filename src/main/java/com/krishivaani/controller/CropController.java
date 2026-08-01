package com.krishivaani.controller;

import com.krishivaani.entity.Crop;
import com.krishivaani.service.CropService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public Crop addCrop(@Valid @RequestBody Crop crop) {
        return cropService.saveCrop(crop);
    }

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id,
                           @Valid @RequestBody Crop crop) {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public String deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return "Crop deleted successfully!";
    }
    @GetMapping("/search/{cropName}")
    public List<Crop> searchCrop(@PathVariable String cropName) {
        return cropService.getCropByName(cropName);
}
}