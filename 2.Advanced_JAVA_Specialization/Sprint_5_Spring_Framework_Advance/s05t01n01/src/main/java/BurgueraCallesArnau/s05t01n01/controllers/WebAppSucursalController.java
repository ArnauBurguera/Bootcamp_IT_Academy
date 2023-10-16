package BurgueraCallesArnau.s05t01n01.controllers;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sucursal")
public class WebAppSucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/add")
    public String showAddSucursalForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "sucursal-form";
    }

    @PostMapping("/add")
    public String createSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
        return "redirect:/sucursal/success";
    }
}
