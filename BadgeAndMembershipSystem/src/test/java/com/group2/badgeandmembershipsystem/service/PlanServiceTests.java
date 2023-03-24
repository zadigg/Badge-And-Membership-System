package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Plan;
import com.group2.badgeandmembershipsystem.dto.PlanDTO;
import com.group2.badgeandmembershipsystem.repository.PlanRepository;
import com.group2.badgeandmembershipsystem.service.impl.PlanServiceImpl;
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
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

@RunWith(SpringRunner.class)
@TestConfiguration
public class PlanServiceTests {

    @TestConfiguration
    static class testApplicationContext{
        @Bean
        public PlanService planService(){
            return new PlanServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    }

    @Autowired
    private PlanService planService;

    @MockBean
    private PlanRepository planRepository;

    @Before
    public void setup(){
        long planId = 123L;
        Plan plan = new Plan("All Meals", "A student is allowed to dine breakfast, lunch and dinner");
        Optional<Plan> foundPlan = Optional.of(plan);
        Mockito.when(planRepository.findById(planId)).thenReturn(foundPlan);
    }

    @Test
    public void testGetPlan(){
        long planId = 0L;
        Optional<Plan> plan = planRepository.findById(planId);
        if(plan.isPresent()){
            PlanDTO planDTO = planService.getPlan(planId);
            assertThat(planDTO.getId()).isEqualTo(planId);
        }
        else {
            assertThat(plan.isPresent()).isEqualTo(false);
        }
    }
}
