package com.webvue.ecom.domain;

import java.io.Serializable;

public class BookSearchCriteria implements Serializable {

   private static final long serialVersionUID = 1L;

   private String            title;
   private String            category;

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }
}
