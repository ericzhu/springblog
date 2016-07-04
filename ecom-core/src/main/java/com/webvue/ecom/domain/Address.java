package com.webvue.ecom.domain;

import java.io.Serializable;

public class Address implements Serializable {

   private static final long serialVersionUID = 1L;

   private String            street;
   private String            houseNumber;
   private String            boxNumber;
   private String            city;
   private String            postalCode;
   private String            country;

   public Address() {

   }

   public Address(Address source) {
      super();
      this.street = source.street;
      this.houseNumber = source.houseNumber;
      this.boxNumber = source.boxNumber;
      this.city = source.city;
      this.postalCode = source.postalCode;
      this.country = source.country;
   }
}
