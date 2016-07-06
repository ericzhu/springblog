package com.webvue.ecom.domain;

import java.math.BigDecimal;

import com.webvue.ecom.domain.support.BaseEntity;

public class OrderDetail extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   private Book              book;
   private Integer           quantity         = Integer.valueOf(1);

   public OrderDetail() {
      super();
   }

   public OrderDetail(Book book, int quantity) {
      super();
      this.book = book;
      this.quantity = quantity;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public Book getBook() {
      return this.book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public BigDecimal getPrice() {
      if (this.book != null) {
         return this.book.getPrice().multiply(BigDecimal.valueOf(this.quantity));
      }
      return BigDecimal.ZERO;
   }

}
