package com.webvue.ecom.domain.support;

import java.io.Serializable;

public abstract class BaseEntity<ID_T> implements Serializable {
   
   private static final long serialVersionUID = 1L;
   
   private ID_T id;

   public ID_T getId() {
      return this.id;
   }
}
