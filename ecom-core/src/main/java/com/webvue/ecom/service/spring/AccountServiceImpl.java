package com.webvue.ecom.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webvue.ecom.domain.Account;
import com.webvue.ecom.exception.AuthenticaticationException;
import com.webvue.ecom.repository.AccountRepository;
import com.webvue.ecom.service.AccountService;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

   @Autowired
   private AccountRepository accountRepository;
   
   @Override
   @Transactional(readOnly = false)
   public Account save(Account account) {
      return accountRepository.save(account);
   }

   @Override
   public Account login(String username, String password) throws AuthenticaticationException {
      Account account = accountRepository.findByUsername(username);
      if(account == null) {
         throw new AuthenticaticationException(message, code);
      }
      return null;
   }

   @Override
   public Account getAccount(String username) {
      // TODO Auto-generated method stub
      return null;
   }

}
