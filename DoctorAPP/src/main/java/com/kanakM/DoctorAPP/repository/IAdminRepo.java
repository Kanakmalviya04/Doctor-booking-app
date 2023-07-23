package com.kanakM.DoctorAPP.repository;

import com.kanakM.DoctorAPP.modal.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Long> {
}
