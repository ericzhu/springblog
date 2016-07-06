package com.sl.staas.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sl.staas.domain.Contact;
import com.sl.staas.repository.ContactRepository;

@Repository
public class JpaContactRepository implements ContactRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<Contact> findAll() {
      CriteriaBuilder cb = entityManager.getCriteriaBuilder();

      CriteriaQuery<Contact> criteria = cb.createQuery(Contact.class);
      Root<Contact> root = criteria.from(Contact.class);
      criteria.select(root);

      return entityManager.createQuery(criteria).getResultList();
   }

   @Override
   public Contact findById(Long id) {
      return entityManager.find(Contact.class, id);
   }

   @Override
   public Contact save(Contact contact) {
      
      if (contact.getId() == null) {
         entityManager.persist(contact);
         return contact;
      }
      return entityManager.merge(contact);
   }
}
