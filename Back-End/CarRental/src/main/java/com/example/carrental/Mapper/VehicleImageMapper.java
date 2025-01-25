package com.example.carrental.Mapper;

import com.example.carrental.DTO.VehicleImageDTO;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Entity.VehicleImage;
import org.springframework.stereotype.Component;

@Component
public class VehicleImageMapper {

    public VehicleImageDTO toDTO(VehicleImage vehicleImage){
        VehicleImageDTO dto = new VehicleImageDTO();
        dto.setId(vehicleImage.getId());
        dto.setVehicleId(vehicleImage.getVehicle().getId());
        dto.setImageUrl(vehicleImage.getImageUrl());
        dto.setUploadedAt(vehicleImage.getUploadedAt());
        return dto;
    }

    public VehicleImage toEntity(VehicleImageDTO vehicleImageDTO, Vehicle vehicle){
        VehicleImage vehicleImage = new VehicleImage();
        vehicleImage.setId(vehicleImageDTO.getId());
        vehicleImage.setVehicle(vehicle);
        vehicleImage.setImageUrl(vehicleImageDTO.getImageUrl());
        vehicleImage.setUploadedAt(vehicleImageDTO.getUploadedAt());
        return vehicleImage;
    }
}
