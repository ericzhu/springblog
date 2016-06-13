package com.ecomlogix.cms.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomlogix.cms.domain.Contact;
import com.ecomlogix.cms.repository.ContactRepository;
import com.ecomlogix.cms.service.ContactService;
import com.google.common.collect.Lists;

@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {

   private ContactRepository contactRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Contact> findAll() {
      return Lists.newArrayList(contactRepository.findAll());
   }

   @Override
   @Transactional(readOnly = true)
   public Contact findById(Long id) {
      return contactRepository.findOne(id);
   }

   @Override
   public void save(Contact contact) {
      contactRepository.save(contact);
   }

   @Autowired
   public void setContactRepository(ContactRepository contactRepository) {
      this.contactRepository = contactRepository;
   }

}
