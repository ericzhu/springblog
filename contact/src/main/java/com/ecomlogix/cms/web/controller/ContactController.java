package com.ecomlogix.cms.web.controller;

import com.ecomlogix.cms.domain.Contact;
import com.ecomlogix.cms.service.ContactService;
import com.ecomlogix.cms.util.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

    private final Logger logger = LoggerFactory.getLogger(ContactController.class);

	private ContactService contactService;

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
        uiModel.addAttribute("contact",contact);
        return "contacts/show";
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable(value = "id") Long id, Model uiModel) {
        Contact contact = contactService.findById(id);
        uiModel.addAttribute("contact", contact);
        return "contacts/updateForm";
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(Contact contact, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes, Locale locale) {
    	logger.info("Updating Contact");
        if(bindingResult.hasErrors()) {

        }
        return "redirect:/contacts/" + UrlUtil.encodeUrlPath(contact.getId().toString(), httpServletRequest);
    }

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
