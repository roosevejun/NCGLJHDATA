package com.tongtu.gis;

import com.tongtu.bean.postgres.Reservation;
import com.tongtu.config.JsonConfig;
import com.tongtu.config.db.DatastoreFactoryConfig;
import com.tongtu.config.db.PostgresConfig;
import com.tongtu.config.db.SqlserverConfig;
import com.tongtu.repository.postgres.ReservationRepository;
import com.tongtu.repository.postgres.TtZrcEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PostgresConfig.class,SqlserverConfig.class , JsonConfig.class})
@ComponentScan("com.tongtu.config")
@RunWith(SpringRunner.class)
public class TtZrcEntityRestControllerTest {

    @MockBean
    private TtZrcEntityRepository zrcEntityRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getzrcEntitys() throws Exception {
        Mockito.when(this.zrcEntityRepository.findAll());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/ttzrcs").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value("4b3b7e9b-8b3b-4608-86bc-cfc3c8a15940"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].zrcmc").value("段新街村"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
