package com.example.carrental.Service;

import com.example.carrental.DTO.PaymentDTO;
import com.example.carrental.Entity.Payment;
import com.example.carrental.Entity.Rental;
import com.example.carrental.Entity.User;
import com.example.carrental.Entity.Vehicle;
import com.example.carrental.Mapper.PaymentMapper;
import com.example.carrental.Repository.PaymentRepository;
import com.example.carrental.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private UserRepository userRepository;

    public List<PaymentDTO> getAllPayments(){
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Payment not found with id:"+id));
        return paymentMapper.toDTO(payment);
    }

    public PaymentDTO createPayment(PaymentDTO paymentDTO){
        User user = userRepository.findById(paymentDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        Payment payment = paymentMapper.toEntity(paymentDTO,user);
        return paymentMapper.toDTO(paymentRepository.save(payment));
    }

    public PaymentDTO updatePayment(Long id,PaymentDTO dto){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Payment not found"));
        payment.setStatus(dto.getStatus());
        payment.setTransactionId(dto.getTransactionId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentDate(dto.getPaymentDate());

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        payment.setUser(userId);
        return paymentMapper.toDTO(paymentRepository.save(payment));
    }

    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
    }
}
