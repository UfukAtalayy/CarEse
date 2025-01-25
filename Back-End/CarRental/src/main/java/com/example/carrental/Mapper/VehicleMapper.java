package com.example.carrental.Mapper;

import com.example.carrental.DTO.VehicleDTO;
import com.example.carrental.Entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDTO toDTO(Vehicle vehicle){
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setFuelType(vehicle.getFuelType());
        dto.setPricePerDay(vehicle.getPricePerDay());
        dto.setPriceForSale(vehicle.getPriceForSale());
        dto.setStatus(vehicle.getStatus());
        dto.setMileage(vehicle.getMileage());
        dto.setLocation(vehicle.getLocation());
        dto.setCreatedAt(vehicle.getCreatedAt());
        dto.setUpdatedAt(vehicle.getUpdatedAt());
        return dto;
    }

    public Vehicle toEntity(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
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
        return vehicle;
    }
}