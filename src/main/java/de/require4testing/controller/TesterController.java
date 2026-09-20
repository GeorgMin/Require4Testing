package de.require4testing.controller;

import de.require4testing.model.Tester;
import de.require4testing.repository.TesterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TesterController {

    private final TesterRepository testerRepository;

    public TesterController(TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    @GetMapping("/tester")
    public String anzeigen(Model model) {
        model.addAttribute("testerListe", testerRepository.findAll());
        model.addAttribute("tester", new Tester());

        return "tester";
    }

    @PostMapping("/tester")
    public String speichern(Tester tester) {
        testerRepository.save(tester);

        return "redirect:/tester";
    }
}