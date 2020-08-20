package org.nutritionist.patient;


import java.util.ArrayList;

public interface PatientService {
    public void AddNewPatient(Patient patient);
    public Patient GetPatientByName(String name) throws Exception;
}
