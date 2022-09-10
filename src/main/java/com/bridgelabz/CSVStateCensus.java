package com.bridgelabz;

public class CSVStateCensus {
    String state;
    long population;
    int areaInSqKm;
    double densityPerSqKm;

    public CSVStateCensus(String state, long population, int areaInSqKm, double densityPerSqKm) {
        super();
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "CSVStateCensus [state=" + state + ", population=" + population + ", areaInSqKm=" + areaInSqKm
                + ", densityPerSqKm=" + densityPerSqKm + "]";
    }
}
