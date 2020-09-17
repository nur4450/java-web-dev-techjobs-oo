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
    public void ToStringReturnsStringContainsBlankLineBeforeAndAfterJobInformation(){
        assertTrue(newJob.toString().startsWith("\n"));
        assertTrue(newJob.toString().endsWith("\n"));
    }

    @Test
    public void ToStringContainsLabels(){
        String expected = "\nID: " +
                newJob.getId() +
                "\nName: " +
                newJob.getName() +
                "\nEmployer: " +
                newJob.getEmployer() +
                "\nLocation: " +
                newJob.getLocation() +
                "\nPosition Type: " +
                newJob.getPositionType() +
                "\nCore Competency: " +
                newJob.getCoreCompetency() +
                "\n";
        assertEquals(expected, newJob.toString());
    }

    @Test
    public void ToStringReturnsMessageForEmptyField(){
        int id = jobForTestEmptyField.getId();
        String expected = "\nID: " +
                id +
                "\nName: " +
                "Data not available" +
                "\nEmployer: " +
                "Data not available" +
                "\nLocation: " +
                jobForTestEmptyField.getLocation() +
                "\nPosition Type: " +
                jobForTestEmptyField.getPositionType() +
                "\nCore Competency: " +
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
