package mylisting.controller;

import mylisting.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping(value = "/classes")
    public String list(Model model) {
        model.addAttribute("classes", classeService.findAllClasses());
        return "classes";
    }

}