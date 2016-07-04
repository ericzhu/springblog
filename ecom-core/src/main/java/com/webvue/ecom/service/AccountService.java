package com.webvue.ecom.service;

import com.webvue.ecom.domain.Account;
import com.webvue.ecom.exception.AuthenticaticationException;

public interface AccountService {

   public Account save(Account account);

   public Account login(String username, String password) throws AuthenticaticationException;
   
   public Account getAccount(String username);
}
