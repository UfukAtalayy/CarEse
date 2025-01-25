package com.example.carrental.Service;

import com.example.carrental.DTO.RentalDTO;
import com.example.carrental.Entity.Rental;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Mapper.RentalMapper;
import com.example.carrental.Repository.RentalRepository;
import com.example.carrental.Repository.UserRepository;
import com.example.carrental.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalMapper rentalMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<RentalDTO> getAllRentals(){
        return rentalRepository.findAll()
                .stream()
                .map(rentalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RentalDTO getRentalById(Long id){
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Rental not found with id:"+id));
        return rentalMapper.toDTO(rental);
    }

    public RentalDTO createRental(RentalDTO rentalDTO){
        User user = userRepository.findById(rentalDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        Vehicle vehicle = vehicleRepository.findById(rentalDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));

        Rental rental = rentalMapper.toEntity(rentalDTO,user,vehicle);
        return rentalMapper.toDTO(rentalRepository.save(rental));
    }

    public RentalDTO updateRental(Long id,RentalDTO dto){
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Rental not found"));
        rental.setStatus(dto.getStatus());
        rental.setRentalStartDate(dto.getRentalStartDate());
        rental.setRentalEndDate(dto.getRentalEndDate());
        rental.setCreatedAt(dto.getCreatedAt());
        rental.setTotalPrice(dto.getTotalPrice());

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        rental.setUser(userId);

        Vehicle vehicleId = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        rental.setVehicle(vehicleId);
        return rentalMapper.toDTO(rentalRepository.save(rental));
    }

    public void deleteRental(Long id){
        rentalRepository.deleteById(id);
    }
}
