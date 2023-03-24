package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.repository.LocationRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.LocationService;
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

import static com.group2.badgeandmembershipsystem.domain.enums.LocationType.GYMNASIUM;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LocationControllerTests {

    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;
    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    LocationService locationService;

    @MockBean
    LocationRepository locationRepository;
    @Test
    public void testGetLocationByLocationId() throws Exception {
        Mockito.when(locationService.getLocation("101")).thenReturn(new LocationDTO("101", "gym", "physical exercise hall", 200, GYMNASIUM));
        mock.perform(MockMvcRequestBuilders.get("/api/locations/101"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.locationId").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("gym"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("physical exercise hall"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capacity").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.locationType").value(GYMNASIUM.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("physical exercise hall"));
    }
}
