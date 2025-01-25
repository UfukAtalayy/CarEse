package com.example.carrental.Mapper;

import com.example.carrental.DTO.VehicleReviewDTO;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Entity.VehicleReview;
import org.springframework.stereotype.Component;

@Component
public class VehicleReviewMapper {

    public VehicleReviewDTO toDTO(VehicleReview vehicleReview){
        VehicleReviewDTO dto = new VehicleReviewDTO();
        dto.setId(vehicleReview.getId());
        dto.setVehicleId(vehicleReview.getVehicle().getId());
        dto.setUserId(vehicleReview.getUser().getId());
        dto.setComment(vehicleReview.getComment());
        dto.setRating(vehicleReview.getRating());
        dto.setCreatedAt(vehicleReview.getCreatedAt());
        return dto;
    }

    public VehicleReview toEntity(VehicleReviewDTO vehicleReviewDTO, Vehicle vehicle, User user){
        VehicleReview vehicleReview = new VehicleReview();
        vehicleReview.setId(vehicleReviewDTO.getId());
        vehicleReview.setVehicle(vehicle);
        vehicleReview.setUser(user);
        vehicleReview.setComment(vehicleReviewDTO.getComment());
        vehicleReview.setRating(vehicleReviewDTO.getRating());
        vehicleReview.setCreatedAt(vehicleReviewDTO.getCreatedAt());
        return vehicleReview;
    }
}
