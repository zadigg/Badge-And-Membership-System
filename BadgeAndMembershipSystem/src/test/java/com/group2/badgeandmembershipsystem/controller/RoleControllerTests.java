package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.RoleService;
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
@WebMvcTest(RoleController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RoleControllerTests {

    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;
    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    RoleService roleService;

    @MockBean
    RoleRepository roleRepository;

    @Test
    public void testGetRoleByRoleId() throws Exception {
        Mockito.when(roleService.getRole(10000001)).thenReturn(new RoleDTO("student"));
        mock.perform(MockMvcRequestBuilders.get("/api/roles/10000001"))
                .andExpect(status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10000001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("student"));

    }
}
