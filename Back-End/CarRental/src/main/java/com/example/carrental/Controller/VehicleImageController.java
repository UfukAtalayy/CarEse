package com.example.carrental.Controller;

import com.example.carrental.DTO.VehicleImageDTO;
import com.example.carrental.Service.VehicleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicleimages")
public class VehicleImageController {

    @Autowired
    private VehicleImageService vehicleImageService;

    @GetMapping
    public List<VehicleImageDTO> getAllVehicleImages(){
        return vehicleImageService.getAllVehicleImages();
    }

    @GetMapping("/{id}")
    public VehicleImageDTO getVehicleImageById(@PathVariable Long id){
        return vehicleImageService.getVehicleImageById(id);
    }

    @PostMapping
    public VehicleImageDTO createVehicleImage(@RequestBody VehicleImageDTO vehicleImageDTO){
        return vehicleImageService.createVehicleImage(vehicleImageDTO);
    }

    @PutMapping("/{id}")
    public VehicleImageDTO updateVehicleImage(@PathVariable Long id,@RequestBody VehicleImageDTO vehicleImageDTO){
        return vehicleImageService.updateVehicleImage(id, vehicleImageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleImage(@PathVariable Long id){
        vehicleImageService.deleteVehicleImage(id);
    }
}
