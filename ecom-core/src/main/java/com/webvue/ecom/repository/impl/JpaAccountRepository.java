package com.webvue.ecom.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.Account;
import com.webvue.ecom.repository.AccountRepository;

@Repository("accountRepository")
public class JpaAccountRepository implements AccountRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public Account findByUsername(String username) {
      String hql = "select a from Account where a.username = :username";
      TypedQuery<Account> query = entityManager.createQuery(hql, Account.class);
      List<Account> accounts = query.getResultList();
      return accounts.size() == 1 ? accounts.get(0) : null;
   }

   @Override
   public Account findById(Long id) {
      return entityManager.find(Account.class, id);
   }

   @Override
   public Account save(Account account) {
      if (account.getId() != null) {
         return entityManager.merge(account);
      }
      else {
         entityManager.persist(account);
         return account;
      }
   }
}
