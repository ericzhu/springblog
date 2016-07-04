package com.webvue.ecom.domain;

public class Permission extends BaseDomainObject<Long> {

   private static final long serialVersionUID = 1L;

   private String permission;

   Permission() {

   }

   public Permission(String permission) {
      this.permission = permission;
   }

   public String getPermission() {
      return permission;
   }

   public void setPermission(String permission) {
      this.permission = permission;
   }
}
