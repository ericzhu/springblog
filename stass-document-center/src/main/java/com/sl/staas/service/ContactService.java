package com.sl.staas.service;

import java.util.List;

import com.sl.staas.domain.Contact;

public interface ContactService {
   
   List<Contact> findAll();

   Contact findById(Long id);

   void save(Contact contact);
}
