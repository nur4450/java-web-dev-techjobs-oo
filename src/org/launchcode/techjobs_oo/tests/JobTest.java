package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job;
    Job anotherJob;
    Job newJob;
    @Before
    public void createJobObjects(){
        job = new Job();
        anotherJob = new Job();
        newJob = new Job("Product tester",new Employer("ACME"),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));

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
}
