package com.capMap.capMap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "`cross`")
public class cross {

    @Id
    private int id;

    @Getter
    @Setter
    private double x;

    @Getter
    @Setter
    private double y;
}
