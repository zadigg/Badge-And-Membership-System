package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.domain.Plan;
import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.repository.BadgeRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.BadgeService;
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

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BadgeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BadgeControllerTests {

    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;
    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    BadgeService badgeService;

    @MockBean
    BadgeRepository badgeRepository;

    @Test
    public void testGetBadgeByBadgeId() throws Exception {
        Mockito.when(badgeService.findById("615422")).thenReturn(new BadgeDTO("ID", "ACTIVE", "615422"));
        mock.perform(MockMvcRequestBuilders.get("/api/badges/615422"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.badgeId").value("615422"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ACTIVE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ID"));
    }


}