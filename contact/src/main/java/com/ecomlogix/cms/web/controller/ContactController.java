package com.ecomlogix.cms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomlogix.cms.service.ContactService;

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

	private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		uiModel.addAttribute("contacts", contactService.findAll());
		return "contacts/list";
	}

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
