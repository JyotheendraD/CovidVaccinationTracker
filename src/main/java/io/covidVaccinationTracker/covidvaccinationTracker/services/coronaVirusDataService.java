package io.covidVaccinationTracker.covidvaccinationTracker.services;

import io.covidVaccinationTracker.covidvaccinationTracker.model.Stats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service  // makes this normal service to spring service
public class coronaVirusDataService {

    private static String vaccinationDataUrl = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/vaccinations/country_data/India.csv";
    private List<Stats> allStats = new ArrayList<>();

    public List<Stats> getAllStats() {
        return allStats;
    }

    @PostConstruct // when class is constructed execute the below method
    @Scheduled(cron = "* 10 * * * *")
    public void fetchVaccinationData() throws IOException, InterruptedException {
        List<Stats> newStats = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(vaccinationDataUrl))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {
            Stats stats = new Stats();
            stats.setLocations(record.get("location"));
            stats.setDate(LocalDate.parse(record.get("date")));
            stats.setVaccine(record.get("vaccine"));
            stats.setSourceUrl(record.get("source_url"));
            stats.setTotalVaccines(Integer.parseInt(record.get("total_vaccinations")));
            stats.setPeopleVaccinated(Integer.parseInt(record.get(("people_vaccinated"))));
            stats.setPeopleFullyVaccinated(Integer.parseInt(record.get("people_fully_vaccinated")));
            newStats.add(stats);
        }

        this.allStats = newStats;

    }


}
