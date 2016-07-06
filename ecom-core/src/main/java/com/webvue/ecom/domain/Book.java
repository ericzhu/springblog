package com.webvue.ecom.domain;

import java.math.BigDecimal;

import com.webvue.ecom.domain.support.BaseEntity;

public class Book extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   private String            title;
   private String            description;
   private BigDecimal        price;
   private Integer           year;
   private String            author;
   private String            isbn;

   private Category          category;
   
   public BigDecimal getPrice() {
      return this.price;
   }
}
