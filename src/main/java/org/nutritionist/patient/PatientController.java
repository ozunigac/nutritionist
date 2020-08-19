package org.nutritionist.patient;

import org.nutritionist.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/addPatient")
    public Response AddPatient(@RequestParam String name, String age, String weight, String height){
        Patient patient = new Patient(name,age,weight,height);
        patientService.AddNewPatient(patient);
        return new Response("A new patient was added");
    }
    @GetMapping("/getPatients")
    public ArrayList<Patient> GetPatients(){
        return patientService.GetPatients();
    }
}
