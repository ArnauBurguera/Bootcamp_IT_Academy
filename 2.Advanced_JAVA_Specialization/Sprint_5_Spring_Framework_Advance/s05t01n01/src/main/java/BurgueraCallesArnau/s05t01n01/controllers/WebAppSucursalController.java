package BurgueraCallesArnau.s05t01n01.controllers;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sucursal")
public class WebAppSucursalController {

    @Autowired
    private SucursalService sucursalService;

    //ADD
    @GetMapping("/add")
    public String showAddSucursalForm(Model model) {
        model.addAttribute("title", "Create New Sucursal");
        model.addAttribute("button", "Create");
        model.addAttribute("sucursal", new Sucursal());
        model.addAttribute("action", "add");
        return "sucursal-form";
    }

    @PostMapping("/add")
    public String createSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
        return "redirect:/sucursal/creation-success";
    }

    @GetMapping("/creation-success")
    public String succesPage(Model model) {
        model.addAttribute("title", "Sucursal created successfully!");
        return "success";
    }

    //UPDATE
    @GetMapping("/update/{id}")
    public String showUpdateSucursalForm(@PathVariable("id") Integer id, Model model) {
        Sucursal existingSucursal = sucursalService.getSucursalById(id);
        model.addAttribute("title", "Update");
        model.addAttribute("button", "Update");
        model.addAttribute("sucursal", existingSucursal);
        model.addAttribute("action", "update");
        return "sucursal-form";
    }

    @PostMapping("/update")
    public String updateSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalService.updateSucursal(sucursal);
        return "redirect:/sucursal/update-success";
    }

    @GetMapping("/update-success")
    public String successfulUpdatePage(Model model) {
        model.addAttribute("title", "Sucursal updated successfully!");
        return "success";
    }

    //DELETE
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Integer id, Model model) {
        Sucursal sucursalToDelete = sucursalService.getSucursalById(id);
        model.addAttribute("sucursal", sucursalToDelete);
        return "delete-confirmation";
    }

    @PostMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Integer id) {
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursal/deletion-success";
    }
    @GetMapping("/deletion-success")
    public String successfulDeletionPage(Model model) {
        model.addAttribute("title", "Sucursal deleted successfully!");
        return "success";
    }

    //SHOW ALL
    @GetMapping("/home")
    public String listSucursalDTOs(Model model) {
        List<SucursalDTO> sucursalDTOs = sucursalService.getAllSucursals();
        model.addAttribute("sucursals", sucursalDTOs);
        return "sucursal-list";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }
    @GetMapping("/team")
    public String showTeam() {
        return "team";
    }
    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }
}
