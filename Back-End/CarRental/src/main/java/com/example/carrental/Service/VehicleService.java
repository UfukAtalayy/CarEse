package com.example.carrental.Service;

import com.example.carrental.DTO.VehicleDTO;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Mapper.VehicleMapper;
import com.example.carrental.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    public List<VehicleDTO> getAllVehicles(){
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VehicleDTO getVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle not found with id:"+id));
        return vehicleMapper.toDTO(vehicle);
    }

    public VehicleDTO createVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        return vehicleMapper.toDTO(vehicleRepository.save(vehicle));
    }

    public VehicleDTO updateVehicle(Long id,VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle not found "));
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setFuelType(vehicleDTO.getFuelType());
        vehicle.setPricePerDay(vehicleDTO.getPricePerDay());
        vehicle.setPriceForSale(vehicleDTO.getPriceForSale());
        vehicle.setStatus(vehicleDTO.getStatus());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setLocation(vehicleDTO.getLocation());
        vehicle.setCreatedAt(vehicleDTO.getCreatedAt());
        vehicle.setUpdatedAt(vehicleDTO.getUpdatedAt());
        return vehicleMapper.toDTO(vehicleRepository.save(vehicle));

    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }
}
