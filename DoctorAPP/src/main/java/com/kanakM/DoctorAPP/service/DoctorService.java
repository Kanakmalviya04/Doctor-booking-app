package com.kanakM.DoctorAPP.service;


import com.kanakM.DoctorAPP.modal.Doctor;
import com.kanakM.DoctorAPP.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepo doctorRepo;

    public void addDoctor(Doctor doc) {
        doctorRepo.save(doc);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }
}
