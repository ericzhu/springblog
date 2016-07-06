package com.sl.staas.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

   @Autowired
   private ContactService contactService;

   @RequestMapping(method = RequestMethod.GET)
   public String list(Model uiModel) {
      uiModel.addAttribute("contacts", contactService.findAll());
      return "contacts/list";
   }
   
   @RequestMapping(value = "/{id}")
   public String updateForm(@PathVariable("id") Long id, Model uiModel) {
      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);
      return "contacts/update";
      
   }

   @RequestMapping(params = "form", method = RequestMethod.GET)
   public String createForm(Model uiModel) {
      uiModel.addAttribute("contact", new Contact());
      return "contacts/create";
   }

   @RequestMapping(method = RequestMethod.POST)
   public String create(Contact contact,
      BindingResult bindingResult,
      Model uiModel,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      RedirectAttributes redirectAttributes) {
      contactService.save(contact);
      return "redirect:/contacts/";
   }
}
