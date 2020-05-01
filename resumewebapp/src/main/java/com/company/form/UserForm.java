package com.company.form;

import javax.validation.constraints.*;

public class UserForm {

    @NotBlank
    @Size(min = 3,message = "salam")
    private String name;

    private String surname;

   // @Pattern(regexp = "[0-9]+",message = "olmazzzz") just number
    private Integer nationalityId;

    public UserForm() {
    }

    public UserForm(String name, String surname, Integer nationalityId) {
        this.name = name;
        this.surname = surname;
        this.nationalityId = nationalityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
}
