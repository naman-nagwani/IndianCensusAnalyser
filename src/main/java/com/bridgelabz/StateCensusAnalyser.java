package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {
    List<CSVStateCensus> censusData = new ArrayList<>();
    public boolean loadData() throws InvalidFileException,InvalidFileTypeException,InvalidDelimiterException,InvalidHeaderException{
        boolean flag=false;
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndiaStateCensusData.csv"));
            String[] record;
            record = reader.readNext();
            if (!checkHeader(record))
                throw new InvalidHeaderException(" This is an invalid header");
            while ((record = reader.readNext()) != null) {
                if (record.length!=4)
                    throw new InvalidDelimiterException("Invalid Delimiter");
                censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
                        Double.parseDouble(record[3])));
            }

            for (CSVStateCensus data : censusData) {
                System.out.println(data);
            }
            if (censusData.size()==29)
                flag = true;

        } catch (FileNotFoundException|CsvValidationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            throw new InvalidFileException("This is a Invalid File");
        } catch (NumberFormatException e){
            throw new InvalidFileTypeException("This is a Invalid File");
        }
        return flag;
    }

    public boolean checkHeader(String[] record) {
        return (record[0].compareTo("State") + record[1].compareTo("Population") + record[2].compareTo("AreaInSqKm")
                + record[3].compareTo("DensityPerSqKm") == 0);
    }
}
