package com.kanakM.DoctorAPP.controller;

import com.kanakM.DoctorAPP.modal.Doctor;
import com.kanakM.DoctorAPP.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("doctor")
    void addDoctor(@RequestBody Doctor doc){
        doctorService.addDoctor(doc);
    }

    @GetMapping("doctors")
    List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

}
