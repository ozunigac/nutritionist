package org.nutritionist.patient;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientServiceImpl implements PatientService{
    ArrayList<Patient> patients = new ArrayList<Patient>();

    public void AddNewPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient GetPatientByName(String name) throws Exception{
        for (int i=0; i < patients.size() ; i++){
            if(patients.get(i).getName().equals(name)){
                return patients.get(i);
            }
        }
        throw new Exception ("No patient was found.");
    }
}
