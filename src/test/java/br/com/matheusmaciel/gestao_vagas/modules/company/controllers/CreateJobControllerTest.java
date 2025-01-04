package br.com.matheusmaciel.gestao_vagas.modules.company.controllers;


import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.matheusmaciel.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.matheusmaciel.gestao_vagas.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreateJobControllerTest {
      private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;


    @Before
    public void setup() {
           mvc = MockMvcBuilders.webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

    @Test
    public void should_be_able_to_create_a_new_job() throws Exception {
    
      var createdJobDTO = CreateJobDTO.builder()
      .description("Vaga para pessoa desenvolvedora júnior")
      .benefits("GymPass, Plano de saúde")
      .level("JUNIOR")
      .build();

      var result = mvc.perform(MockMvcRequestBuilders.post("/company/job/")
      .contentType(MediaType.APPLICATION_JSON)
      .content(TestUtils.objectToJson(createdJobDTO))
      .header("Authorization", TestUtils.generateToken(UUID.fromString("36081469-cfec-473c-a68e-7b901d05d44b"), "JAVAGAS_@123#"))
      )
      .andExpect(MockMvcResultMatchers.status().isOk());

       System.out.println(result);

    }

    private static String objectToJson(Object obj){
      try{
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
      }catch(Exception e){
        throw new RuntimeException(e);
      }
    }


}
