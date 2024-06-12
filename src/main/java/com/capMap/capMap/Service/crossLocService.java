package com.capMap.capMap.Service;
import com.capMap.capMap.Repository.crossLocRepository;
import com.capMap.capMap.domain.cross;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class crossLocService {

    @Autowired
    private crossLocRepository crossLocRepository;

    public boolean isCoordinateWithinDistance(double x, double y, double distance) {
        List<cross> coordinates = crossLocRepository.findCoordinatesWithinDistance(x, y, distance);
        return !coordinates.isEmpty();
    }

}
