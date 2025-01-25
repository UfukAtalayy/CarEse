package com.example.carrental.Service;

import com.example.carrental.DTO.AdminDTO;
import com.example.carrental.Entity.Admin;
import com.example.carrental.Entity.User;
import com.example.carrental.Mapper.AdminMapper;
import com.example.carrental.Repository.AdminRepository;
import com.example.carrental.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserRepository userRepository;

    public List<AdminDTO> getAllAdmins(){
        return adminRepository.findAll()
                .stream()
                .map(adminMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdminDTO getAdminById(Long id){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Admin not found with id:"+id));
        return adminMapper.toDTO(admin);
    }

    public AdminDTO createAdmin(AdminDTO adminDTO){
        User user = userRepository.findById(adminDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        Admin admin = adminMapper.toEntity(adminDTO,user);
        return adminMapper.toDTO(adminRepository.save(admin));
    }

    public AdminDTO updateAdmin(Long id,AdminDTO dto){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Admin not found"));
        admin.setActivity(dto.getActivity());
        admin.setPerformedAt(dto.getPerformedAt());

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        admin.setUser(userId);
        return adminMapper.toDTO(adminRepository.save(admin));
    }

    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }
}
