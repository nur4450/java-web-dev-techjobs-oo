package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job;
    Job anotherJob;
    Job newJob;
    Job jobForTestEmptyField;
    Job jobContainsOnlyIdField;
    @Before
    public void createJobObjects(){
        job = new Job();
        anotherJob = new Job();
        newJob = new Job("Product tester",new Employer("ACME"),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));
        jobForTestEmptyField = new Job("",new Employer(""),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId(){
        assertFalse(job.getId() == anotherJob.getId());
    }

    @Test
    public void testSettingJobIdDifferByOne(){
        assertTrue(anotherJob.getId() - job.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(newJob instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        Job equalToNewJob = new Job("Product tester",new Employer("ACME"),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertFalse(newJob.equals(equalToNewJob));
    }

    @Test
    public void testToStringReturnsStringWithBlankLine(){
        assertTrue(newJob.toString().startsWith("\n"));
        assertTrue(newJob.toString().endsWith("\n"));
    }

    @Test
    public void testToStringContainsLabels(){
        String expected = "\n" +
                "ID: " +
                newJob.getId() +
                "\n" +
                "Name: " +
                newJob.getName() +
                "\n" +
                "Employer: " +
                newJob.getEmployer() +
                "\n" +
                "Location: " +
                newJob.getLocation() +
                "\n" +
                "Position Type: " +
                newJob.getPositionType() +
                "\n" +
                "Core Competency: " +
                newJob.getCoreCompetency() +
                "\n";
        assertEquals(expected, newJob.toString());
    }

    @Test
    public void testToStringReturnsMessageForEmptyField(){
        int id = jobForTestEmptyField.getId();
        String expected = "\n" +
                "ID: " +
                id +
                "\n" +
                "Name: " +
                "Data not available" +
                "\n" +
                "Employer: " +
                "Data not available" +
                "\n" +
                "Location: " +
                jobForTestEmptyField.getLocation() +
                "\n" +
                "Position Type: " +
                jobForTestEmptyField.getPositionType() +
                "\n" +
                "Core Competency: " +
                jobForTestEmptyField.getCoreCompetency() +
                "\n";
        assertEquals(expected,jobForTestEmptyField.toString());
    }

    @Test
    public void testToStringForOnlyContainsIdField(){
        String expected = "OOPS! This job does not seem to exist";
        assertEquals(expected, job.toString());
    }

}
