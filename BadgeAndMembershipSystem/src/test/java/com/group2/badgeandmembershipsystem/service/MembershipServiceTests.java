package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Membership;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import com.group2.badgeandmembershipsystem.repository.MembershipRepository;
import com.group2.badgeandmembershipsystem.service.impl.MembershipServiceImpl;
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

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@TestConfiguration
public class MembershipServiceTests {
    @TestConfiguration
    public static class MembershipServiceTestContextConfiguration{
        @Bean
        public MembershipService membershipService(){
            return new MembershipServiceImpl();
        }
        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    }
    @Autowired
    private MembershipService membershipService;
    @MockBean
    private MembershipRepository membershipRepository;

    @Before
    public void setUp(){
        long membershipId = 0L;
        Membership membership = new Membership( LocalDate.now(), LocalDate.now(),MembershipType.LIMITED, 20 );
        Optional<Membership> membershipOptional = Optional.of(membership);
        Mockito.when(membershipRepository.findById(membershipId)).thenReturn(membershipOptional);
    }
    @Test
    public void whenValidMembershipIdThenMembershipShouldBeFound(){
        Optional<Membership> membership = membershipRepository.findById(0L);
        if(membership.isPresent()){
            MembershipDTO membershipDTO = membershipService.getMembership(0L);
            assertThat(membershipDTO.getId())
                    .isEqualTo(0L);
        }
        else {
            assertThat(membership.isPresent()).isEqualTo(false);
        }


    }
}
