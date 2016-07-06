package com.sl.staas.repository;

import java.util.List;

import com.sl.staas.domain.Contact;

public interface ContactRepository {
   
   public List<Contact> findAll();
   
   public Contact findById(Long id);
   
   public Contact save(Contact contact);
}
