package org.nutritionist.patient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("spring-data-jpa")
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void AddPatientsShouldReturnSuccessMessage() throws  Exception{
        mockMvc.perform( get("/addPatient")
                .param("name","Oscar Ismael")
                .param("age", "25")
                .param("weight","10")
                .param("height","10")
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("A new patient was added"));
    }


    @Test
    public void GetPatientsShouldReturnAListOfPatients() throws  Exception{

        mockMvc.perform(get("/getPatientByName")
                    .param("name","Oscar Ismael")
                )
                .andExpect(model().attribute("patient", hasProperty("name", is("Oscar Ismael"))))
                .andExpect(model().attribute("patient", hasProperty("age", is("25"))))
                .andExpect(model().attribute("patient", hasProperty("weight", is("10"))))
                .andExpect(model().attribute("patient", hasProperty("height", is("10"))))
                .andExpect(view().name("patient/patientDetail"));
    }

}
