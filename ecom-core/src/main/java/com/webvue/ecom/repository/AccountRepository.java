package com.webvue.ecom.repository;

import com.webvue.ecom.domain.Account;

public interface AccountRepository {
   public Account findByUsername(String username);
   public Account findById(Long id);
   public Account save(Account account);
}
