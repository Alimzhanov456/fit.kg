package kg.field_rent_application.controllers;

import kg.field_rent_application.models.entities.Field;
import kg.field_rent_application.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor

@Controller
public class FieldController {
    private final FieldService fieldService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", fieldService.getAllFields());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewField(Model model) {
        Field field = new Field();
        model.addAttribute("field", field);
        return "newfield";
    }

    @PostMapping("/save")
    public String saveField(@ModelAttribute("field") Field field) {
        fieldService.save(field);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        Field field = fieldService.getById(id);
        model.addAttribute("field", field);
        return "update";
    }

    @GetMapping("/deleteField/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        fieldService.deleteViaId(id);
        return "redirect:/";
    }
}
