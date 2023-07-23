package com.kanakM.DoctorAPP.repository;

import com.kanakM.DoctorAPP.modal.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient, Long> {
    Patient findFirstByPatientEmail(String newEmail);
}
