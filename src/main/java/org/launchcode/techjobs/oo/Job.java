package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the other five fields. The second constructor should also call the first in order to initialize the 'id' field.

    // constructor to initialize unique ID
    public Job() {
        id = nextId;
        nextId++;
    }

    // second constructor
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this ();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextId and id.


    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    // TODO: code toString method
    @Override
    public String toString() {
        String dataError = "Data not available";
        if(name == null || name == "") {
            name = dataError;
        }
        if(employer == null || employer.getValue() == "") {
            employer.setValue(dataError);
        }
        if(location == null || location.getValue() == "") {
            location.setValue(dataError);
        }
        if(positionType == null || positionType.getValue() == "") {
            positionType.setValue(dataError);
        }
        if(coreCompetency == null || coreCompetency.getValue() == "") {
            coreCompetency.setValue(dataError);
        }
        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + name + System.lineSeparator() +
                "Employer: " + employer + System.lineSeparator() +
                "Location: " + location + System.lineSeparator() +
                "Position Type: " + positionType + System.lineSeparator() +
                "Core Competency: " + coreCompetency + System.lineSeparator();
        }
}
