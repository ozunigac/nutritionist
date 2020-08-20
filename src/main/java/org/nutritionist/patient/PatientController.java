package org.nutritionist.patient;

import org.nutritionist.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("/getPatientByName")
    public ModelMap GetPatientByName(@RequestParam String name){
        ModelMap modelMap = new ModelMap();
        try {
            modelMap.addAttribute("patient", patientService.GetPatientByName(name));
        }catch(Exception ex){
            modelMap.addAttribute("Error", ex);
        }
        return modelMap;
    }
}
