package com.webvue.ecom.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Cart {
   private Map<Book, Integer> books = new HashMap<>();

   public Map<Book, Integer> getBooks() {
      return Collections.unmodifiableMap(this.books);
   }

   public void addBook(Book book) {
      Validate.notNull(book, "The book to be added to cart shall not be null");

      Integer quantity = Integer.valueOf(1);
      if (this.books.containsKey(book)) {
         quantity++;
      }
      this.books.put(book, quantity);
   }

   public void removeBook(Book book) {
      this.books.remove(book);
   }

   public void clear() {
      this.books.clear();
   }

   @Override
   public String toString() {
      ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
      builder.append("books", this.books.keySet());
      return builder.build();
   }
}
