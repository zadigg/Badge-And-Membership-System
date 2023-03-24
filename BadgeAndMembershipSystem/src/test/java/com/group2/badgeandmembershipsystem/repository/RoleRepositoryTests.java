package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.Role;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private RoleRepository roleRepository;



    @Test
    public void findByRoleId_thenReturnRole() {
        // First I have created a role and persist it
        Role role = new Role("student");
        entityManager.persist(role);
        entityManager.flush();
        Optional<Role> optionalRole = roleRepository.findById(role.getId());
        assertTrue(optionalRole.isPresent());
        Role found = optionalRole.get();
        AssertionsForInterfaceTypes.assertThat(found.getId()).isEqualTo(role.getId());
    }
}
