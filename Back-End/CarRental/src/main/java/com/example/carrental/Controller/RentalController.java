package com.example.carrental.Controller;

import com.example.carrental.DTO.RentalDTO;
import com.example.carrental.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<RentalDTO> getAllRentals(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public RentalDTO getRentalById(@PathVariable Long id){
        return rentalService.getRentalById(id);
    }

    @PostMapping
    public RentalDTO createRental(@RequestBody RentalDTO rentalDTO){
        return rentalService.createRental(rentalDTO);
    }

    @PutMapping("/{id}")
    public RentalDTO updateRental(@PathVariable Long id,@RequestBody RentalDTO rentalDTO){
        return rentalService.updateRental(id, rentalDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id){
        rentalService.deleteRental(id);
    }

}
