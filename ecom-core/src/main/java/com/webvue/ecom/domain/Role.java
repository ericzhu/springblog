package com.webvue.ecom.domain;

import java.util.ArrayList;
import java.util.List;

public class Role extends BaseDomainObject<Long> {

   private String           role;
   private List<Permission> permissions = new ArrayList<>();

   Role() {

   }

   public Role(String role) {
      this.role = role;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public List<Permission> getPermissions() {
      return permissions;
   }

   public void setPermissions(List<Permission> permissions) {
      this.permissions = permissions;
   }
}
