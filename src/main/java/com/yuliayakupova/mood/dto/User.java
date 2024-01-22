package com.yuliayakupova.mood.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class User {
    @JsonIgnore
    private Long id;

    private String login;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String userEmail;

    private String userFirstName;

    private String userLastName;

    @JsonIgnore
    private String personalCode;

    @JsonIgnore
    private LocalDate dateOfBirth;

    @JsonIgnore
    private String contact;

    public User(String login, String password, String userEmail, String userFirstName, String userLastName, String personalCode, LocalDate dateOfBirth, String contact) {
            this.login = login;
            this.password = password;
            this.userEmail = userEmail;
            this.userFirstName = userFirstName;
            this.userLastName = userLastName;
            this.personalCode = personalCode;
            this.dateOfBirth = dateOfBirth;
            this.contact = contact;
        }
        public User() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserFirstName() {
            return userFirstName;
        }

        public void setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
        }

        public String getUserLastName() {
            return userLastName;
        }

        public void setUserLastName(String userLastName) {
            this.userLastName = userLastName;
        }

        public String getPersonalCode() {
            return personalCode;
        }

        public void setPersonalCode(String personalCode) {
            this.personalCode = personalCode;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

    }