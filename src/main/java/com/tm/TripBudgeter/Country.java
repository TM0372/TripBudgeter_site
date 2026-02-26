package com.tm.TripBudgeter.country;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "daily_usd")
    private Integer dailyUsd;
}