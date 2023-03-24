package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

   Optional<Location> findByLocationId(String locationId);
   Location findByLocationIdIgnoreCase(String locationId);
   List<Location> findByLocationType(LocationType locationType);

}
