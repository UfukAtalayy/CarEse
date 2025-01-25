package com.example.carrental.Controller;

import com.example.carrental.DTO.SaleDTO;
import com.example.carrental.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SaleDTO> getAllSales(){
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public SaleDTO getSaleById(@PathVariable Long id){
        return saleService.getSaleById(id);
    }

    @PostMapping
    public SaleDTO createSale(@RequestBody SaleDTO saleDTO){
        return saleService.createSale(saleDTO);
    }

    @PutMapping("/{id}")
    public SaleDTO updateSale(@PathVariable Long id,@RequestBody SaleDTO saleDTO){
        return saleService.updateSale(id, saleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id){
        saleService.deleteSale(id);
    }
}
