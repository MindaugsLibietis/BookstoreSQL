package com.rcs;

import java.sql.Date;

public class Author {
    private int id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Gender gender;
    private String country;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(String name, String surname, Gender gender, String country) {
        this(name, surname);
        this.gender = gender;
        this.country = country;
    }

    public Author(int id, String name, String surname, Gender gender, String country, Date dateOfBirth) {
        this(name, surname, gender, country);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s (%s)", this.name, this.surname, this.country,
                dateOfBirth != null ? this.dateOfBirth.toString() : "Nezināms");
    }
}
