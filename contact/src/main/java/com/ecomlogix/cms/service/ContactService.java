package com.ecomlogix.cms.service;

import java.util.List;

import com.ecomlogix.cms.domain.Contact;

public interface ContactService {
   List<Contact> findAll();

   Contact findById(Long id);

   void save(Contact contact);
}
