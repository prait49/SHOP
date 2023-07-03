package com.example.timeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
public class TimeController {

    @GetMapping("/")
    public String getCurrentTime() {
        LocalDate currentDate  = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  currentDate.format(formatter);
    }

}
