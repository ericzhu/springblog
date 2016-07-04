package com.webvue.ecom.domain;

import java.io.Serializable;

public abstract class BaseDomainObject<ID_T> implements Serializable {
   
   private static final long serialVersionUID = 1L;
   
   private ID_T id;

   public ID_T getId() {
      return this.id;
   }
}
