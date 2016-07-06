package com.webvue.ecom.domain;

import java.util.Date;

import com.webvue.ecom.domain.support.BaseEntity;

public class Account extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   private String            firstName;
   private String            lastName;
   private Date              dateOfBirth;
   private Address           address          = new Address();
   private String            emailAddress;
   private String            username;
   private String            password;

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmailAddress() {
      return this.emailAddress;
   }

   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   public String getUsername() {
      return this.username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Address getAddress() {
      return this.address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Date getDateOfBirth() {
      return this.dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }
}
