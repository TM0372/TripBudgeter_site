package com.tm.TripBudgeter;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private  String name;

    @Column(name = "daily_usd", nullable = false)
    private Integer dailyUsd;

    public Integer getDailyUsd() {
        return dailyUsd;
    }

    public  Country() {
    }

}
