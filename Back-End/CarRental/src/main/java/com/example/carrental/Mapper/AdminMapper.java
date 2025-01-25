package com.example.carrental.Mapper;

import com.example.carrental.DTO.AdminDTO;
import com.example.carrental.Entity.Admin;
import com.example.carrental.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public AdminDTO toDTO(Admin admin){
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setActivity(admin.getActivity());
        dto.setUserId(admin.getUser().getId());
        dto.setPerformedAt(admin.getPerformedAt());
        return dto;
    }

    public Admin toEntity(AdminDTO adminDTO, User user){
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUser(user);
        admin.setActivity(adminDTO.getActivity());
        admin.setPerformedAt(adminDTO.getPerformedAt());
        return admin;
    }
}
