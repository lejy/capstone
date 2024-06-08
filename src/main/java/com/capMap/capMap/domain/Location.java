package com.capMap.capMap.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {

    private String x;

    private String y;

    public Location(String x, String y){
        this.x = x;
        this.y = y;

    }
}
