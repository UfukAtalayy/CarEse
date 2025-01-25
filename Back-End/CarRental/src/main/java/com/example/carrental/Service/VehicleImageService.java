package com.example.carrental.Service;

import com.example.carrental.DTO.VehicleImageDTO;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Entity.VehicleImage;
import com.example.carrental.Mapper.VehicleImageMapper;
import com.example.carrental.Repository.VehicleImageRepository;
import com.example.carrental.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleImageService {

    @Autowired
    private VehicleImageRepository vehicleImageRepository;

    @Autowired
    private VehicleImageMapper vehicleImageMapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleImageDTO> getAllVehicleImages(){
        return vehicleImageRepository.findAll()
                .stream()
                .map(vehicleImageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VehicleImageDTO getVehicleImageById(Long id){
        VehicleImage vehicleImage = vehicleImageRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle image not found with idÇ"+id));
        return vehicleImageMapper.toDTO(vehicleImage);
    }

    public VehicleImageDTO createVehicleImage(VehicleImageDTO vehicleImageDTO){
        Vehicle vehicle = vehicleRepository.findById(vehicleImageDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        VehicleImage vehicleImage = vehicleImageMapper.toEntity(vehicleImageDTO,vehicle);
        return vehicleImageMapper.toDTO(vehicleImageRepository.save(vehicleImage));
    }

    public VehicleImageDTO updateVehicleImage(Long id,VehicleImageDTO vehicleImageDTO){
        VehicleImage vehicleImage = vehicleImageRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicle image not found"));
        vehicleImage.setImageUrl(vehicleImageDTO.getImageUrl());
        vehicleImage.setUploadedAt(vehicleImageDTO.getUploadedAt());

        Vehicle vehicleId = vehicleRepository.findById(vehicleImageDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        vehicleImage.setVehicle(vehicleId);
        return vehicleImageMapper.toDTO(vehicleImageRepository.save(vehicleImage));
    }

    public void deleteVehicleImage(Long id){
        vehicleImageRepository.deleteById(id);
    }
}
