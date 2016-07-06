package com.webvue.ecom.domain.support;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.support.TransactionTemplate;

import com.webvue.ecom.domain.Account;

public class InitialDataSetup {
   
   private TransactionTemplate transactionTemplate;

   @PersistenceContext
   private EntityManager entityManager;
   
   private Account johnDoe;
}
