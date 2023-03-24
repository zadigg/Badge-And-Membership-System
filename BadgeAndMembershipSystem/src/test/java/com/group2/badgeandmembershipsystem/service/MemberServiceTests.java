package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.domain.Member;
import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.dto.MemberDTO;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.service.impl.MemberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@TestConfiguration
public class MemberServiceTests {

    @TestConfiguration
    static class MemberServiceTestContextConfiguration {
        @Bean
        public MemberService memberService() {
            return new MemberServiceImpl();
        }

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @Before
    public void setUp() {
        long id = 0L;
        Member member = new Member("Samsom","Abraham","samsom.tesfabrhan1@gmail.com","abcdefg");
        Optional<Member> memberOptional = Optional.of(member);
        Mockito.when(memberRepository.findById(id))
                .thenReturn(memberOptional);
    }

    @Test
    public void whenValidMemberIdThenMemberShouldBeFound() {

        Optional<Member> member = memberRepository.findById(0L);
        if (member.isPresent()) {
            MemberDTO memberDTO = memberService.getMember(0L);
            assertThat(memberDTO.getId())
                    .isEqualTo(0L);
        }
        else {
            assertThat(member.isPresent()).isEqualTo(false);
        }

    }
}
