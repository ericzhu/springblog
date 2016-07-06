package com.sl.staas.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sl.staas.domain.Document;
import com.sl.staas.repository.DocumentRepository;

@Repository
public class JpaDocumentRepository implements DocumentRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public Document save(Document document) {
      entityManager.persist(document);
      return document;
   }
}
