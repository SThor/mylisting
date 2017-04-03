package mylisting.controller;

import mylisting.domain.Classe;
import mylisting.domain.Eleve;
import mylisting.service.ClasseService;
import mylisting.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

/**
 * Created by 21301646 on 03/04/2017.
 */
@Controller
public class EleveController {
    @Autowired
    private EleveService eleveService;
    @Autowired
    private ClasseService classeService;

    @GetMapping("eleve/create")
    public String createEleve(@RequestParam(value="nom", required = true)String nom,
                              @RequestParam(value="prenom", required = true)String prenom,
                              @RequestParam(value="age", required = true)String age,
                              @RequestParam(value="classe_id", required = true)String classe_id,
                              Model model){
        Eleve eleve;
        try{
            Classe classe = classeService.findOneClasse(Long.valueOf(classe_id));
            eleve = new Eleve(nom, prenom, Integer.valueOf(age), classe);
            eleveService.saveEleve(eleve);
            //model.addAttribute(eleve);
        }catch(ConstraintViolationException e){
            model.addAttribute("customMessage",e.getMessage());
            return "error";
        }
        //return "eleveShow"
        return "redirect:/eleveShow/" + eleve.getId();
    }

    @GetMapping("eleveShow/{id}")
    public String showEleve(@PathVariable Long id, Model model) {
        Eleve eleve = eleveService.findOneEleve(id);
        if (eleve == null) {
            model.addAttribute("customMessage", "Élève non trouvée");
            return "error";
        }
        model.addAttribute(eleve);
        return "eleveShow";
    }

    @GetMapping("eleves/{classe_id}")
    public String elevesForClasse(@PathVariable Long classe_id, Model model){
        Classe classe = classeService.findOneClasse(classe_id);
        if(classe == null){
            model.addAttribute("customMessage","Classe non trouvée");
            return "error";
        }
        ArrayList<Eleve> eleves = eleveService.findAllEleveForClasse(classe);
        model.addAttribute("classe", classe);
        model.addAttribute("eleves", eleves);
        return("eleves");
    }
}
