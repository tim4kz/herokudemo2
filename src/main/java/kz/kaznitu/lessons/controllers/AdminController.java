package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Admin;
import kz.kaznitu.lessons.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String adminList(Model model) {
        model.addAttribute("admins", adminRepository.findAll());
        model.addAttribute("admin", new Admin());
        return "admins";
    }

    @RequestMapping(value = "/saveadmin", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute Admin admin) {
        adminRepository.save(admin);
        return "redirect:/admins";
    }

    @RequestMapping(value = "/remove1", method = RequestMethod.GET)
    public String remove1(@RequestParam("id") Long id){
        adminRepository.deleteById(id);
        return "redirect:/admins";
    }
}
