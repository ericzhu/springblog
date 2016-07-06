package com.sl.staas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "documents")
public class Document implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID")
   private Long              id;

   @Version
   @Column(name = "VERSION")
   private int               version;

   @Column(name = "CREATED_AT")
   @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
   @DateTimeFormat(iso = ISO.DATE)
   private DateTime          createdAt;

   @Column(name = "DOC_NAME")
   private String            docName;

   @Column(name = "DOC_DESC")
   private String            docDescription;

   @Column(name = "DOC_CONTENT")
   private byte[]            docContent;

   public Long getId() {
      return id;
   }

   public int getVersion() {
      return version;
   }

   public void setVersion(int version) {
      this.version = version;
   }

   public DateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(DateTime createdAt) {
      this.createdAt = createdAt;
   }

   public String getDocName() {
      return docName;
   }

   public void setDocName(String docName) {
      this.docName = docName;
   }

   public String getDocDescription() {
      return docDescription;
   }

   public void setDocDescription(String docDescription) {
      this.docDescription = docDescription;
   }

   public byte[] getDocContent() {
      return docContent;
   }

   public void setDocContent(byte[] docContent) {
      this.docContent = docContent;
   }

}
