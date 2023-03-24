package com.group2.badgeandmembershipsystem.repository;


import com.group2.badgeandmembershipsystem.domain.Plan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@RunWith(SpringRunner.class)
public class PlanRepositoryTests {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    PlanRepository planRepository;
    @Test
    public void findByPlanId(){
        Plan plan = new Plan("All Meals", "A student is allowed to dine breakfast, lunch and dinner");
        entityManager.persist(plan);
        entityManager.flush();

        Optional<Plan> foundPlan = planRepository.findById(plan.getId());
        assertThat(foundPlan.get().getId()).isEqualTo(plan.getId());

    }
}
