package com.capMap.capMap.Repository;

import com.capMap.capMap.domain.cross;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface crossLocRepository extends JpaRepository<cross, Integer> {

    @Query("SELECT c FROM `cross` c WHERE (6371 * acos(cos(radians(:y)) * cos(radians(c.y)) * cos(radians(c.x) - radians(:x)) + sin(radians(:y)) * sin(radians(c.y)))) < :distance")
    List<cross> findCoordinatesWithinDistance(
            @Param("x") double x,
            @Param("y") double y,
            @Param("distance") double distance);
}

