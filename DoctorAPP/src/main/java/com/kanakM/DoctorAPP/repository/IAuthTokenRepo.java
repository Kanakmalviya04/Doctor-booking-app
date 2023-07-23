package com.kanakM.DoctorAPP.repository;

import com.kanakM.DoctorAPP.modal.AuthenticationToken;
import com.kanakM.DoctorAPP.modal.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByPatient(Patient patient);
}