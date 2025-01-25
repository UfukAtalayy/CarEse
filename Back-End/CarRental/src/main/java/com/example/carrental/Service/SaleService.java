package com.example.carrental.Service;

import com.example.carrental.DTO.SaleDTO;
import com.example.carrental.Entity.Sale;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Mapper.SaleMapper;
import com.example.carrental.Repository.SaleRepository;
import com.example.carrental.Repository.UserRepository;
import com.example.carrental.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<SaleDTO> getAllSales(){
        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SaleDTO getSaleById(Long id){
        Sale sale = saleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Sale not found with id:"+id));
        return saleMapper.toDTO(sale);
    }

    public SaleDTO createSale(SaleDTO saleDTO){
        User user = userRepository.findById(saleDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        Vehicle vehicle = vehicleRepository.findById(saleDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));

        Sale sale = saleMapper.toEntity(saleDTO,user,vehicle);
        return saleMapper.toDTO(saleRepository.save(sale));
    }

    public SaleDTO updateSale(Long id,SaleDTO saleDTO){
        Sale sale = saleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Sale not found"));
        sale.setSaleDate(saleDTO.getSaleDate());
        sale.setPrice(saleDTO.getPrice());
        sale.setPaymentStatus(saleDTO.getPaymentStatus());
        sale.setCreatedAt(saleDTO.getCreatedAt());

        User userId = userRepository.findById(saleDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        sale.setUser(userId);

        Vehicle vehicleId = vehicleRepository.findById(saleDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        sale.setVehicle(vehicleId);
        return saleMapper.toDTO(saleRepository.save(sale));
    }

    public void deleteSale(Long id){
        saleRepository.deleteById(id);
    }
}
