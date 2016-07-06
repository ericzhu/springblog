package com.webvue.ecom.domain.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

public abstract class EntityBuilder<T extends BaseEntity<? extends Serializable>> {
   
   protected T product;
   
   {
      initProduct();
   }
   
   abstract void initProduct();
   
   abstract T assembleProduct();
   
   public static class EntityBuilderManager {
      
      private static ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<EntityManager>();

      public static void setEntityManager(EntityManager entityManager) {
         entityManagerHolder.set(entityManager);
      }

      public static void clearEntityManager() {
         entityManagerHolder.remove();
      }

      public static EntityManager getEntityManager() {
         return entityManagerHolder.get();
      }
   }
   
}
