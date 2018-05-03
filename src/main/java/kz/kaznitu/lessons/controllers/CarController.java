package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Admin;
import kz.kaznitu.lessons.models.Car;
import kz.kaznitu.lessons.repositories.AdminRepository;
import kz.kaznitu.lessons.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String carsList(Model model){
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "cars";
    }

    @RequestMapping(value = "/cars",method = RequestMethod.POST)
    public String addCar(@RequestParam Long adminIId,
                            Model model) {
        Admin admin = adminRepository.findById(adminIId).get();
        Car newCar = new Car();
        newCar.setAdmin(admin);
        carRepository.save(newCar);

        return "redirect:/cars";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id){
        carRepository.deleteById(id);
        return "redirect:/cars";
    }

}
