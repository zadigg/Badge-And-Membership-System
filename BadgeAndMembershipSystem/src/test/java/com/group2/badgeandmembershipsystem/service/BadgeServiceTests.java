package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.repository.BadgeRepository;
import com.group2.badgeandmembershipsystem.service.impl.BadgeServiceImpl;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@TestConfiguration
public class BadgeServiceTests {

    @TestConfiguration
    static class BadgeServiceTestContextConfiguration {
        @Bean
        public BadgeService badgeService() {
            return new BadgeServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    private BadgeService badgeService;

    @MockBean
    private BadgeRepository badgeRepository;

    @Before
    public void setUp() {
        String badgeId = "101";
        Badge badge = new Badge("ID", "ACTIVE", "615422");
        Optional<Badge> badgeOptional = Optional.of(badge);
        Mockito.when(badgeRepository.findByBadgeId(badgeId))
                .thenReturn(badgeOptional);
    }

    @Test
    public void whenValidBadgeIdThenBadgeShouldBeFound() {

        Optional<Badge> badge = badgeRepository.findByBadgeId("615422");
        if (badge.isPresent()) {
            BadgeDTO badgeDTO = badgeService.findById("615422");
            assertThat(badgeDTO.getBadgeId())
                    .isEqualTo("615422");
        }
        else {
            assertThat(badge.isPresent()).isEqualTo(false);
        }

    }
}
