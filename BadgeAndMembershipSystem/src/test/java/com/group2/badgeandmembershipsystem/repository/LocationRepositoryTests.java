package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Location;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.group2.badgeandmembershipsystem.domain.enums.LocationType.GYMNASIUM;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void findByLocationId_thenReturnLocation() {
        // First I have created a location and persist it
        Location location = new Location("101", "gym", "physical exercise hall", 200, GYMNASIUM);
        entityManager.persist(location);
        entityManager.flush();
        Optional<Location> optionalLocation = locationRepository.findByLocationId(location.getLocationId());
        assertTrue(optionalLocation.isPresent());
        Location found = optionalLocation.get();
        AssertionsForInterfaceTypes.assertThat(found.getLocationId()).isEqualTo(location.getLocationId());
    }

}
