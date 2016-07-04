package com.webvue.ecom.exception;

public class AuthenticaticationException extends Exception {

   private static final long serialVersionUID = 1L;

   private String            code;

   public AuthenticaticationException(String message, String code) {
      super(message);
      this.code = code;
   }

   public String getCode() {
      return this.code;
   }

}
