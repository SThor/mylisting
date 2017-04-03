package mylisting.service;

import mylisting.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialisationService {

    private Ecole ecoleRangueil, ecoleBalma;
    private Classe cp1R, cp2R, ce1R, cm1R, cpB, ce1B;
    private Eleve e1, e2, e3, e4, e5, e6, e7, e8, e9,
            e10, e11, e12, e13, e14, e15;

    @Autowired
    private EcoleService ecoleService;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private EleveService eleveService;

    public void initDonnees() {
        initEcoles();
        initClasses();
        initEleves();
    }

    private void initEcoles() {
        initEcoleRangueil();
        initEcoleBalma();
    }

    private void initEcoleRangueil() {
        ecoleRangueil = new Ecole("Toulouse", "Ecole de Rangueil", 120);
        ecoleService.saveEcole(ecoleRangueil);
    }

    private void initEcoleBalma() {
        ecoleBalma = new Ecole("Balma", "Ecole Saint Exupery", 100);
        ecoleService.saveEcole(ecoleBalma);
    }

    private void initClasses() {
        cp1R = new Classe(ecoleRangueil, Niveau.CP, "Mme Dupont");
        classeService.saveClasse(cp1R);
        cp2R = new Classe(ecoleRangueil, Niveau.CP, "Mme Durand");
        classeService.saveClasse(cp2R);
        ce1R = new Classe(ecoleRangueil, Niveau.CE1, "M Girault");
        classeService.saveClasse(ce1R);
        cm1R = new Classe(ecoleRangueil, Niveau.CM1, "M Dilbert");
        classeService.saveClasse(cm1R);
        cpB = new Classe(ecoleBalma, Niveau.CP, "Mme Lafitte");
        classeService.saveClasse(cpB);
        ce1B = new Classe(ecoleBalma, Niveau.CE1, "M Maurice");
        classeService.saveClasse(ce1B);
    }

    private void initEleves() {
        initEleveCp1R();
        initEleveCp2R();
        initEleveCe1R();
        initEleveCm1R();
        initEleveCpB();
        initEleveCe1B();
    }

    private void initEleveCp1R() {
        e1 = new Eleve("Dubois", "Enzo", 6, cp1R);
        eleveService.saveEleve(e1);
        e2 = new Eleve("Juno", "Brian", 6, cp1R);
        eleveService.saveEleve(e2);
        e3 = new Eleve("Lambert", "Nina", 5, cp1R);
        eleveService.saveEleve(e3);
    }

    private void initEleveCp2R() {
        e4 = new Eleve("Esprit", "Sol", 6, cp2R);
        eleveService.saveEleve(e4);
        e5 = new Eleve("Froid", "Sophie", 6, cp2R);
        eleveService.saveEleve(e5);
        e6 = new Eleve("Gauche", "Gabin", 5, cp2R);
        eleveService.saveEleve(e6);
        e7 = new Eleve("Risque", "Théo", 6, cp2R);
        eleveService.saveEleve(e7);
        e8 = new Eleve("Thermidor", "Martin", 6, cp2R);
        eleveService.saveEleve(e8);
        e9 = new Eleve("Yoyo", "Simon", 5, cp2R);
        eleveService.saveEleve(e9);
    }

    private void initEleveCe1R() {
        e10 = new Eleve("Zo", "Enzo", 7, ce1R);
        eleveService.saveEleve(e10);
    }

    private void initEleveCm1R() {
        e11 = new Eleve("Regis", "Louise", 7, cm1R);
        eleveService.saveEleve(e11);
        e12 = new Eleve("Tel", "Marie", 8, cm1R);
        eleveService.saveEleve(e12);
        e13 = new Eleve("Lacoste", "Anna", 7, cm1R);
        eleveService.saveEleve(e13);
    }

    private void initEleveCpB() {
        e14 = new Eleve("Dubois", "Enzo", 6, cpB);
        eleveService.saveEleve(e14);
        e15 = new Eleve("Mister", "Brian", 6, cpB);
        eleveService.saveEleve(e15);
    }

    private void initEleveCe1B() {

    }

    public Ecole getEcoleRangueil() {
        return ecoleRangueil;
    }

    public Ecole getEcoleBalma() {
        return ecoleBalma;
    }

    public Classe getCp1R() {
        return cp1R;
    }

    public Classe getCp2R() {
        return cp2R;
    }

    public Classe getCe1R() {
        return ce1R;
    }

    public Classe getCm1R() {
        return cm1R;
    }

    public Classe getCpB() {
        return cpB;
    }

    public Classe getCe1B() {
        return ce1B;
    }
}