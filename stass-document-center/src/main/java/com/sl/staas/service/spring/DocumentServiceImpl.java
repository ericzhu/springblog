package com.sl.staas.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sl.staas.domain.Document;
import com.sl.staas.repository.DocumentRepository;
import com.sl.staas.service.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

   @Autowired
   private DocumentRepository docmentRepository;
   
   @Override
   public Document save(Document document) {
      return docmentRepository.save(document);
   }

}
