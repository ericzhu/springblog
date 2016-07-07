package com.sl.staas.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sl.staas.domain.Contact;
import com.sl.staas.service.ContactService;

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

   protected Logger       logger = LoggerFactory.getLogger(ContactController.class);

   @Autowired
   private ContactService contactService;

   @Autowired
   private MessageSource  messageSource;

   @RequestMapping(method = RequestMethod.GET)
   public String list(Model uiModel) {
      logger.info("Listing contacts");
      List<Contact> contacts = contactService.findAll();
      uiModel.addAttribute("contacts", contacts);
      logger.info("No. of contacts: " + contacts.size());
      return "contacts/list";
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public String show(@PathVariable("id") Long id, Model uiModel) {

      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);

      return "contacts/show";
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET, params = "form")
   public String updateForm(@PathVariable("id") Long id, Model uiModel) {
      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);
      return "contacts/update";
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "form")
   public String update(Contact contact,
      BindingResult bindingResult,
      Model uiModel,
      HttpServletRequest httpServletRequest,
      RedirectAttributes redirectAttributes,
      Locale locale) {
      
      logger.info("Updating contact");
      
      if(bindingResult.hasErrors()) {
         
      }
      
      
      return "";
   }

   @RequestMapping(method = RequestMethod.GET, params = "form")
   public String createForm(Model uiModel) {
      uiModel.addAttribute("contact", new Contact());
      return "contacts/create";
   }

   @RequestMapping(method = RequestMethod.POST, params = "form")
   public String create(Contact contact,
      BindingResult bindingResult,
      Model uiModel,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      RedirectAttributes redirectAttributes) {
      contactService.save(contact);
      return "redirect:/contacts/";
   }

   @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
   public String downloadPhoto() {
      return "";
   }
}
