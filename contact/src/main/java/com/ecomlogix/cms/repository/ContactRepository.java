package com.ecomlogix.cms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomlogix.cms.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
