package com.example.carrental.Controller;

import com.example.carrental.DTO.PaymentDTO;
import com.example.carrental.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO){
        return paymentService.createPayment(paymentDTO);
    }

    @PutMapping("/{id}")
    public PaymentDTO updatePayment(@PathVariable Long id,@RequestBody PaymentDTO paymentDTO){
        return paymentService.updatePayment(id, paymentDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
    }
}
