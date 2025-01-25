package com.example.carrental.Mapper;

import com.example.carrental.DTO.SaleDTO;
import com.example.carrental.Entity.Sale;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper {

    public SaleDTO toDTO(Sale sale){
        SaleDTO dto =new SaleDTO();
        dto.setId(sale.getId());
        dto.setUserId(sale.getUser().getId());
        dto.setVehicleId(sale.getVehicle().getId());
        dto.setPrice(sale.getPrice());
        dto.setPaymentStatus(sale.getPaymentStatus());
        dto.setSaleDate(sale.getSaleDate());
        dto.setCreatedAt(sale.getCreatedAt());
        return dto;
    }

    public Sale toEntity(SaleDTO saleDTO, User user, Vehicle vehicle){
        Sale sale = new Sale();
        sale.setId(saleDTO.getId());
        sale.setUser(user);
        sale.setVehicle(vehicle);
        sale.setSaleDate(saleDTO.getSaleDate());
        sale.setPaymentStatus(saleDTO.getPaymentStatus());
        sale.setPrice(saleDTO.getPrice());
        sale.setCreatedAt(saleDTO.getCreatedAt());
        return sale;
    }
}
