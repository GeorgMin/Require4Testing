package de.require4testing.controller;

import de.require4testing.model.Anforderung;
import de.require4testing.repository.AnforderungRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnforderungController {

    private final AnforderungRepository anforderungRepository;

    public AnforderungController(AnforderungRepository anforderungRepository) {
        this.anforderungRepository = anforderungRepository;
    }

    @GetMapping("/anforderungen")
    public String anzeigen(Model model) {
        model.addAttribute("anforderungen", anforderungRepository.findAll());
        model.addAttribute("anforderung", new Anforderung());
        return "anforderungen";
    }

    @PostMapping("/anforderungen")
    public String speichern(Anforderung anforderung) {
        anforderungRepository.save(anforderung);
        return "redirect:/anforderungen";
    }
}