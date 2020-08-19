package org.nutritionist.patient;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientServiceImpl implements PatientService{
    ArrayList<Patient> patients = new ArrayList<Patient>();

    public void AddNewPatient(Patient patient) {
        patients.add(patient);
    }

    public ArrayList<Patient> GetPatients(){
        return patients;
    }
}
