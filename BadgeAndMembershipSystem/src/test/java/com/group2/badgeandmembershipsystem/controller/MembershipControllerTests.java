package com.group2.badgeandmembershipsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import com.group2.badgeandmembershipsystem.repository.MembershipRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.MembershipService;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MembershipController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MembershipControllerTests {
    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtHelper jwtHelper;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MembershipService membershipService;

    @MockBean
    private MembershipRepository membershipRepository;

    @Test
    public void testGetMembershipByMembershipId() throws Exception {
        Mockito.when(membershipService.getMembership(1)).thenReturn(new MembershipDTO(LocalDate.of(2023,12,10), LocalDate.of(2023,12,30), MembershipType.LIMITED, 20 ));
        mock.perform(MockMvcRequestBuilders.get("/api/memberships/1"))
                .andExpect(status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.membershipType").value("LIMITED"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfAllowances").value(20));
    }
}
