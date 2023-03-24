package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.domain.Member;
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
public class MemberRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findByBadgeId_thenReturnBadge() {
        Member member = new Member("Samsom","Abraham","samsom.tesfabrhan1@gmail.com","abcdefg");
        entityManager.persist(member);
        entityManager.flush();
        Optional<Member> found = memberRepository.findById(member.getId());
        assertTrue(found.isPresent());
        AssertionsForInterfaceTypes.assertThat(found.get().getId())
                .isEqualTo(member.getId());

    }

}
