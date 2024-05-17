package org.launchcode.techjobs.oo;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {

        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        // new job object
         Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        // test field values
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

        // test field types
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {

        // create two new job objects with identical values (minus id)
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // test that equals returns false
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        // create job object
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("The string should start with a new line character", System.lineSeparator(), String.valueOf(job.toString().charAt(0)));
        assertEquals("The string should end with a new line character", System.lineSeparator(), String.valueOf(job.toString().charAt(job.toString().length()-1)));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        // create job object
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // define expected string with correct formatting
        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();

        // test toString method returns expected string
        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String emptyJobValues = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: " + job.getEmployer() + System.lineSeparator() +
                "Location: " + job.getLocation() + System.lineSeparator() +
                "Position Type: " + job.getPositionType() + System.lineSeparator() +
                "Core Competency: " + job.getCoreCompetency() + System.lineSeparator();
        assertEquals(emptyJobValues, job.toString());
    }

}
