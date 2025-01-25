package com.example.carrental.Controller;

import com.example.carrental.DTO.VehicleReviewDTO;
import com.example.carrental.Service.VehicleReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiclereviews")
public class VehicleReviewController {

    @Autowired
    private VehicleReviewService vehicleReviewService;
    @GetMapping
    public List<VehicleReviewDTO> getAllVehicleReviews(){
        return vehicleReviewService.getAllVehicleReviews();
    }
    @GetMapping("/{id}")
    public VehicleReviewDTO getVehicleReviewById(@PathVariable Long id){
        return vehicleReviewService.getVehicleReviewById(id);
    }

    @PostMapping
    public VehicleReviewDTO createVehicleReview(@RequestBody VehicleReviewDTO vehicleReviewDTO){
        return vehicleReviewService.createVehicleReview(vehicleReviewDTO);
    }

    @PutMapping("/{id}")
    public VehicleReviewDTO updateVehicleReview(@PathVariable Long id,@RequestBody VehicleReviewDTO vehicleReviewDTO){
        return vehicleReviewService.updateVehicleReview(id, vehicleReviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleReview(@PathVariable Long id){
        vehicleReviewService.deleteVehicleReview(id);
    }
}
