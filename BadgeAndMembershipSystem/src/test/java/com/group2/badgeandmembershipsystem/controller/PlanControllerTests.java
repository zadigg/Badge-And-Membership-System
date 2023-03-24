package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.PlanDTO;
import com.group2.badgeandmembershipsystem.repository.PlanRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.PlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanController.class)
@AutoConfigureMockMvc(addFilters = false)

public class PlanControllerTests {
    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;
    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    PlanService planService;

    @MockBean
    PlanRepository planRepository;

    @Test
    public void testGetPlanByPlanId() throws Exception {
        Mockito.when(planService.getPlan(0L)).thenReturn(new PlanDTO("All Meals", "A student is allowed to dine breakfast, lunch and dinner"));
        mock.perform(MockMvcRequestBuilders.get("/api/plans/0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("All Meals"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("A student is allowed to dine breakfast, lunch and dinner"));

    }

}
