package com.webvue.ecom.domain;

import java.util.ArrayList;
import java.util.List;

import com.webvue.ecom.domain.support.BaseEntity;

public class Role extends BaseEntity<Long> {

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
