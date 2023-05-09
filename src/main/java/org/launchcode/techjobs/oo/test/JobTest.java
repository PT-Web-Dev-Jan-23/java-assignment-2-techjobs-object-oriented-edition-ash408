package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job1 = new Job(name, employer, location, positionType, coreCompetency);

        assertTrue(job1.getName() instanceof String);
        assertEquals(job1.getName(), name);

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getEmployer().getValue(), employer.getValue());

        assertTrue(job1.getLocation() instanceof Location);
        assertEquals(job1.getLocation().getValue(), location.getValue());

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals(job1.getPositionType().getValue(), positionType.getValue());

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getCoreCompetency().getValue(), coreCompetency.getValue());
    }

    @Test
    public void testJobsForEquality () {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1 == job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = job1.toString();

        assertEquals('\n', testString.charAt(0));
        assertEquals('\n', testString.charAt(testString.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job1 = new Job(name, employer, location, positionType, coreCompetency);

        String outputLines =
                "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer.toString() + "\n" +
                "Location: " + location.toString() + "\n" +
                "Position Type: " + positionType.toString() + "\n" +
                "Core Competency: " + coreCompetency.toString() + "\n" +
                "\n";

        String jobString = job1.toString();
        assertEquals(outputLines, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField () {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job1 = new Job(name, employer, location, positionType, coreCompetency);

        String outputLines =
                "\n" +
                        "ID: " + job1.getId() + "\n" +
                        "Name: " + name + "\n" +
                        "Employer: " + employer.toString() + "\n" +
                        "Location: " + location.toString() + "\n" +
                        "Position Type: " + "Data not available\n" +
                        "Core Competency: " + coreCompetency.toString() + "\n" +
                        "\n";

        String jobString = job1.toString();
        assertEquals(outputLines, jobString);
    }
}