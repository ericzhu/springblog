package com.sl.staas.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sl.staas.domain.Contact;
import com.sl.staas.repository.ContactRepository;
import com.sl.staas.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

   @Autowired
   private ContactRepository contactRepository;

   @Override
   public List<Contact> findAll() {
      return contactRepository.findAll();
   }

   @Override
   public Contact findById(Long id) {
      return contactRepository.findById(id);
   }

   @Override
   public void save(Contact contact) {
      contactRepository.save(contact);
   }

}
