package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.repository.LocationRepository;
import com.group2.badgeandmembershipsystem.service.impl.LocationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.group2.badgeandmembershipsystem.domain.enums.LocationType.GYMNASIUM;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@TestConfiguration
public class LocationServiceTests {
    @TestConfiguration
    static class LocationServiceTestContextConfiguration {
        @Bean
        public LocationService locationService() {
            return new LocationServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    private LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;

    @Before
    public void setUp() {
        String locationId = "101";
        Location location = new Location("101", "gym", "physical exercise hall", 200, GYMNASIUM);
        Optional<Location> locationOptional = Optional.of(location);
        Mockito.when(locationRepository.findByLocationId(locationId))
                .thenReturn(locationOptional);
    }

    @Test
    public void whenValidLocationIdThenLocationShouldBeFound() {
        String locationId = "101";
        LocationDTO found = locationService.getLocation("101");
        assertThat(found.getLocationId())
                .isEqualTo(locationId);
    }
}
