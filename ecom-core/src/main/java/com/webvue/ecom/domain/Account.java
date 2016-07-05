package com.webvue.ecom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account extends BaseDomainObject<Long> {

   private static final long serialVersionUID = 1L;

   private Long              id;
   private String            firstName;
   private String            lastName;
   private Date              dateOfBirth;
   private Address           address          = new Address();
   private String            emailAddress;
   private String            username;
   private String            password;
   private List<Role>        roles            = new ArrayList<>();

   public Address getAddress() {
      return address;
   }
   
   public String getEmailAddress() {
      return emailAddress;
   }
}
