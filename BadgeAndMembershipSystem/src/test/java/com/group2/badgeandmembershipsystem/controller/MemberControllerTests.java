package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.MemberDTO;
import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.MemberService;
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
@WebMvcTest(MemberController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MemberControllerTests {

    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtHelper jwtHelper;

    @MockBean
    MemberService memberService;

    @MockBean
    MemberRepository memberRepository;

    @Test
    public void testGetMemberByMemberId() throws Exception {
        Mockito.when(memberService.getMember(10000001)).thenReturn(new MemberDTO("Samsom","Abraham","samsom.tesfabrhan1@gmail.com"));
        mock.perform(MockMvcRequestBuilders.get("/api/members/10000001"))
                .andExpect(status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10000001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Samsom"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Abraham"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.emailAddress").value("samsom.tesfabrhan1@gmail.com"));


    }
}
