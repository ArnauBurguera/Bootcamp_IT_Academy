package BurgueraCallesArnau.s05t01n01.controllers;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sucursal")
public class WebAppSucursalController {

    @Autowired
    private SucursalService sucursalService;

    //HOME
    @GetMapping("/home")
    public String showHome(Model model){
        return "home";
    }

    //ADD
    @GetMapping("/add")
    public String showAddSucursalForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "sucursal-form";
    }

    @PostMapping("/add")
    public String createSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
        return "redirect:/sucursal/creation-success";
    }

    @GetMapping("/creation-success")
    public String succesPage(Model model) {
        return "sucursal-success";
    }

    //UPDATE
    @GetMapping("/update/{id}")
    public String showUpdateSucursalForm(@PathVariable Integer id, Model model) {
        model.addAttribute("sucursalId", id);
        return "update-form";
    }

    @PostMapping("/update")
    public String updateSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO);
        return "redirect:/sucursal/success";
    }

    @GetMapping("/update-success")
    public String successfulUpdatePage(Model model) {
        return "update-success";
    }
}
