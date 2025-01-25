package com.example.carrental.Service;

import com.example.carrental.DTO.VehicleReviewDTO;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Entity.VehicleReview;
import com.example.carrental.Mapper.VehicleReviewMapper;
import com.example.carrental.Repository.UserRepository;
import com.example.carrental.Repository.VehicleRepository;
import com.example.carrental.Repository.VehicleReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleReviewService {

    @Autowired
    private VehicleReviewRepository vehicleReviewRepository;

    @Autowired
    private VehicleReviewMapper vehicleReviewMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleReviewDTO> getAllVehicleReviews(){
        return vehicleReviewRepository.findAll()
                .stream()
                .map(vehicleReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VehicleReviewDTO getVehicleReviewById(Long id){
        VehicleReview vehicleReview = vehicleReviewRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle review not found with id:"+id));
        return vehicleReviewMapper.toDTO(vehicleReview);
    }

    public VehicleReviewDTO createVehicleReview(VehicleReviewDTO vehicleReviewDTO){
        User user = userRepository.findById(vehicleReviewDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        Vehicle vehicle = vehicleRepository.findById(vehicleReviewDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        VehicleReview vehicleReview = vehicleReviewMapper.toEntity(vehicleReviewDTO,vehicle,user);
        return vehicleReviewMapper.toDTO(vehicleReviewRepository.save(vehicleReview));
    }

    public VehicleReviewDTO updateVehicleReview(Long id,VehicleReviewDTO dto){
        VehicleReview vehicleReview = vehicleReviewRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle review not found"));
        vehicleReview.setComment(dto.getComment());
        vehicleReview.setRating(dto.getRating());
        vehicleReview.setCreatedAt(dto.getCreatedAt());

        Vehicle vehicleId = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        vehicleReview.setVehicle(vehicleId);

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        vehicleReview.setUser(userId);
        return vehicleReviewMapper.toDTO(vehicleReviewRepository.save(vehicleReview));
    }

    public void deleteVehicleReview(Long id){
        vehicleReviewRepository.deleteById(id);
    }
}
