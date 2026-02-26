package com.tm.TripBudgeter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getCountries() {
        return  new ResponseEntity<>(countryService.all(), HttpStatus.OK);

    }
    @GetMapping("/calculate")
    public ResponseEntity<?> calculateTrip (

            @RequestParam Long countryId,
            @RequestParam int days
    ){
        Optional<Country> dbCountry  = countryService.findById(countryId);
        if (dbCountry .isEmpty()) {
            return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
        }
        if (days <= 0) {
            return new ResponseEntity<>("Days must be positive", HttpStatus.BAD_REQUEST);
        }
            int daily = dbCountry.get().getDailyUsd();
        int total  = daily * days;

        return new ResponseEntity<>("To " + days + " " + "days" + " " + " You need: " + total + "$", HttpStatus.OK);
    }
}
