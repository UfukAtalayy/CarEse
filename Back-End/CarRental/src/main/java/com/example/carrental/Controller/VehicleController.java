package com.example.carrental.Controller;

import com.example.carrental.DTO.VehicleDTO;
import com.example.carrental.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<VehicleDTO> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Long id){
        return vehicleService.getVehicleById(id);
    }

    @PostMapping
    public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.createVehicle(vehicleDTO);
    }

    @PutMapping("/{id}")
    public VehicleDTO updateVehicle(@PathVariable Long id,@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.updateVehicle(id, vehicleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
    }
}
