package com.tm.TripBudgeter;

import com.tm.TripBudgeter.Country;
import org.springframework.data.repository.CrudRepository;

    public interface CountryRepository extends CrudRepository<Country, Long> {
    }
