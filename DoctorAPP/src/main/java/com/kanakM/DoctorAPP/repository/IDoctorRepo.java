package com.kanakM.DoctorAPP.repository;

import com.kanakM.DoctorAPP.modal.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor, Long> {
}
