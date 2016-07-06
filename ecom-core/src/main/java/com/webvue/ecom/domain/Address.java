package com.webvue.ecom.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
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

   public String getStreet() {
      return this.street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getHouseNumber() {
      return this.houseNumber;
   }

   public void setHouseNumber(String houseNumber) {
      this.houseNumber = houseNumber;
   }

   public String getBoxNumber() {
      return this.boxNumber;

   }

   public void setBoxNumber(String boxNumber) {
      this.boxNumber = boxNumber;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getPostalCode() {
      return this.postalCode;
   }

   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   public String getCountry() {
      return this.country;
   }

   public void setCountry(String country) {
      this.country = country;
   }
}
