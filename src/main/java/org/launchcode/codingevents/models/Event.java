package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    @NotNull
    private String location;

    @AssertTrue
    private boolean registration;

    @Positive(message = "Number of attendees must be one or more.")
    private int attendees;

    @Future(message = "Date must be a future date.")
    private LocalDate date;

    public Event(String name, String description, String contactEmail, String location, boolean registration, int attendees, LocalDate date) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registration = registration;
        this.attendees = attendees;
        this.date = date;
        this.id = nextId;
        nextId++;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @Email String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@Email String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public @NotBlank @NotNull String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank @NotNull String location) {
        this.location = location;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    @Positive
    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(@Positive int attendees) {
        this.attendees = attendees;
    }

    public @Future LocalDate getDate() {
        return date;
    }

    public void setDate(@Future LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
