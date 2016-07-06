package com.sl.staas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sl.staas.config.RootContextConfiguration;
import com.sl.staas.domain.Document;
import com.sl.staas.service.DocumentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootContextConfiguration.class })
@Commit
public class IntegrationTest {

   @Autowired
   DocumentService documentService;

   @Test
   public void test() {
      Document doc = new Document();
      doc.setDocName("Test Doc");
      documentService.save(doc);
   }

}
