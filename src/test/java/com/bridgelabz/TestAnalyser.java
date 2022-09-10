package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class TestAnalyser {
    @Test
    public void givenCSVFileShouldLoadData() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        boolean flag;
        try {
            flag = analyser.loadData();
        } catch (InvalidFileException|InvalidFileTypeException|InvalidDelimiterException|InvalidHeaderException e) {
            flag = false;
        }
        Assert.assertEquals(true,flag);
    }
}
