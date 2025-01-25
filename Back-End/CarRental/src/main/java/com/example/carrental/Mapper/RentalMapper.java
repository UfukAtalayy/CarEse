package com.example.carrental.Mapper;

import com.example.carrental.DTO.RentalDTO;
import com.example.carrental.Entity.Rental;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {
    public RentalDTO toDTO(Rental rental){
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setUserId(rental.getUser().getId());
        dto.setVehicleId(rental.getVehicle().getId());
        dto.setRentalStartDate(rental.getRentalStartDate());
        dto.setRentalEndDate(rental.getRentalEndDate());
        dto.setTotalPrice(rental.getTotalPrice());
        dto.setCreatedAt(rental.getCreatedAt());
        dto.setStatus(rental.getStatus());
        return dto;
    }

    public Rental toEntity(RentalDTO rentalDTO, User user, Vehicle vehicle){
        Rental rental = new Rental();
        rental.setId(rentalDTO.getId());
        rental.setUser(user);
        rental.setVehicle(vehicle);
        rental.setRentalStartDate(rentalDTO.getRentalStartDate());
        rental.setRentalEndDate(rentalDTO.getRentalEndDate());
        rental.setStatus(rentalDTO.getStatus());
        rental.setTotalPrice(rentalDTO.getTotalPrice());
        rental.setCreatedAt(rentalDTO.getCreatedAt());
        return rental;
    }

}

