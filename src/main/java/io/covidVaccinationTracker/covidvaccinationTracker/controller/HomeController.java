package io.covidVaccinationTracker.covidvaccinationTracker.controller;


import io.covidVaccinationTracker.covidvaccinationTracker.model.Stats;
import io.covidVaccinationTracker.covidvaccinationTracker.services.coronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    coronaVirusDataService dataService;

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Stats> allStats = dataService.getAllStats();
        int totalVaccine = allStats.stream().mapToInt(stat -> (int) stat.getTotalVaccines()).sum();

        model.addAttribute("Stats", allStats);


        return "home";
    }



}
