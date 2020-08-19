package org.nutritionist.patient;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void AddPatientsShouldReturnSuccessMessage() throws  Exception{
        this.mockMvc.perform( get("/addPatient")
                    .param("name","Patricia")
                    .param("age", "25")
                    .param("weight","10")
                    .param("height","10")
                ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("A new patient was added"));

        this.mockMvc.perform( get("/addPatient")
                .param("name","Oscar")
                .param("age", "25")
                .param("weight","1.89")
                .param("height","100")
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("A new patient was added"));
    }

}
