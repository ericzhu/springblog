package com.sl.staas.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sl.staas.repository.DocumentRepository;

public class JpaDocumentRepository implements DocumentRepository {

   @PersistenceContext
   private EntityManager entityManager;
}
