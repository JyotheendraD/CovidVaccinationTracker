package io.covidVaccinationTracker.covidvaccinationTracker.model;

import java.time.LocalDate;

public class Stats {
    private String locations;
    private LocalDate date;
    private String vaccine;
    private String sourceUrl;
    private long totalVaccines;
    private long peopleVaccinated;
    private long peopleFullyVaccinated;

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public long getTotalVaccines() {
        return totalVaccines;
    }

    public void setTotalVaccines(long totalVaccines) {
        this.totalVaccines = totalVaccines;
    }

    public long getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(long peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public long getPeopleFullyVaccinated() {
        return peopleFullyVaccinated;
    }

    public void setPeopleFullyVaccinated(long peopleFullyVaccinated) {
        this.peopleFullyVaccinated = peopleFullyVaccinated;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "locations='" + locations + '\'' +
                ", date='" + date + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", totalVaccines=" + totalVaccines +
                ", peopleVaccinated=" + peopleVaccinated +
                ", peopleFullyVaccinated=" + peopleFullyVaccinated +
                '}';
    }
}
