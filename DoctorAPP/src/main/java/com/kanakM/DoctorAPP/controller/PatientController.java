package com.kanakM.DoctorAPP.controller;

import com.kanakM.DoctorAPP.modal.Appointment;
import com.kanakM.DoctorAPP.modal.Patient;
import com.kanakM.DoctorAPP.modal.dto.SignInInput;
import com.kanakM.DoctorAPP.modal.dto.SignUpOutput;
import com.kanakM.DoctorAPP.service.AuthenticationService;
import com.kanakM.DoctorAPP.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authenticationService;



    @PostMapping("patient/signup")
    public SignUpOutput signUpPatient(@RequestBody Patient patient)
    {

        return patientService.signUpPatient(patient);
    }

    @PostMapping("patient/signIn")
    public String sigInPatient(@RequestBody @Valid SignInInput signInInput)
    {
        return patientService.signInPatient(signInInput);
    }

    @DeleteMapping("patient/signOut")
    public String sigOutPatient(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return patientService.sigOutPatient(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @GetMapping("patients")
    List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PostMapping("appointment/schedule")
    public String  scheduleAppointment(@RequestBody Appointment appointment, String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            boolean status = patientService.scheduleAppointment(appointment);
            return status ? "appointment scheduled":"error occurred during scheduling appointment";
        }
        else
        {
            return "Scheduling failed because invalid authentication";
        }
    }

    @DeleteMapping("appointment/cancel")
    public String  cancelAppointment(String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            patientService.cancelAppointment(email);
            return "canceled Appointment successfully";
        }
        else
        {
            return "Scheduling failed because invalid authentication";
        }
    }
}