package com.kanakM.DoctorAPP.repository;

import com.kanakM.DoctorAPP.modal.Appointment;
import com.kanakM.DoctorAPP.modal.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment, Long> {

    Appointment findFirstByPatient(Patient patient);
}
