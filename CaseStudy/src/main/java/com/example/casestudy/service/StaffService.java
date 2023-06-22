package com.example.casestudy.service;

import com.example.casestudy.model.dao.StaffDao;
import com.example.casestudy.model.dto.StaffDto;
import com.example.casestudy.model.entity.Staff;

import java.util.List;

public class StaffService {
    private StaffDao staffDao = null;
    public StaffService() {
        staffDao = new StaffDao();
    }

    public List<StaffDto> findAll(){
        return staffDao.selectAllStaff();
    }

   public StaffDto find(int id){
        return staffDao.selectStaff(id);
   }

    public void add(StaffDto staffDto){
        StaffDto newStaffDto = new StaffDto(staffDto.getName(), staffDto.getBirthday(), staffDto.getSex(), staffDto.getPhoneNumber(),
          staffDto.getEmail(), staffDto.getAddress());
        staffDao.insertStaff(newStaffDto);
    }

}
