package com.musalasoft.drone.mgt.api.controller;

import com.musalasoft.drone.mgt.api.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DroneControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DroneService droneService;

    @Test
    void getDroneBatteryLevel() throws Exception {

        given(droneService.getDroneBatteryLevel(anyLong())).willReturn("25.4%");
        ResultActions response = mvc.perform(get("/api/1/drones/1/battery"));
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("25.4%"))
        ;
    }
}