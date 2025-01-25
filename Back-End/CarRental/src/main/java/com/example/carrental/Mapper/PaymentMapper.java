package com.example.carrental.Mapper;

import com.example.carrental.DTO.PaymentDTO;
import com.example.carrental.Entity.Payment;
import com.example.carrental.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDTO toDTO(Payment payment){
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setStatus(payment.getStatus());
        dto.setUserId(payment.getUser().getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setTransactionId(payment.getTransactionId());
        return dto;
    }

    public Payment toEntity(PaymentDTO paymentDTO, User user){
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setUser(user);
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus());
        payment.setTransactionId(paymentDTO.getTransactionId());
        return payment;
    }
}
