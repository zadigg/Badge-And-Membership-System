package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.Role;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.repository.LocationRepository;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.service.impl.LocationServiceImpl;
import com.group2.badgeandmembershipsystem.service.impl.RoleServiceImpl;
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
public class RoleServiceTests {
    @TestConfiguration
    static class RoleServiceTestContextConfiguration {
        @Bean
        public RoleService roleService() {
            return new RoleServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }
    @Autowired
    private RoleService roleService;

    @MockBean
    private RoleRepository roleRepository;

    @Before
    public void setUp() {
        long id = 0L;
        Role role = new Role("student");
        Optional<Role> roleOptional = Optional.of(role);
        Mockito.when(roleRepository.findById(id))
                .thenReturn(roleOptional);
    }

    @Test
    public void whenValidRoleIdThenRoleShouldBeFound() {
        long roleId = 0L;
        RoleDTO found = roleService.getRole(0L);
        assertThat(found.getId())
                .isEqualTo(roleId);
    }
}
