package com.group2.badgeandmembershipsystem.repository;
import com.group2.badgeandmembershipsystem.domain.Membership;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MembershipRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MembershipRepository membershipRepository;

    @Test
    public void findByMembershipId_thenReturnMembership() {
        Membership membership = new Membership(LocalDate.of(2023,12,10), LocalDate.of(2023,12,30), MembershipType.LIMITED, 20 );
        entityManager.persist(membership);
        entityManager.flush();
        Optional<Membership> found = membershipRepository.findById(membership.getId());
        assertTrue(found.isPresent());
        AssertionsForInterfaceTypes.assertThat(found.get().getId())
                .isEqualTo(membership.getId());

    }

}
