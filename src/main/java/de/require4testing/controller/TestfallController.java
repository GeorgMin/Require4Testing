package de.require4testing.controller;

import de.require4testing.model.Testfall;
import de.require4testing.repository.TestfallRepository;
import de.require4testing.repository.AnforderungRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestfallController {

    private final TestfallRepository testfallRepository;
    private final AnforderungRepository anforderungRepository;

    public TestfallController(TestfallRepository testfallRepository,
                              AnforderungRepository anforderungRepository) {
        this.testfallRepository = testfallRepository;
        this.anforderungRepository = anforderungRepository;
    }

    @GetMapping("/testfaelle")
    public String anzeigen(Model model) {
        model.addAttribute("testfaelle", testfallRepository.findAll());
        model.addAttribute("testfall", new Testfall());
        model.addAttribute("anforderungen", anforderungRepository.findAll());

        return "testfaelle";
    }

    @PostMapping("/testfaelle")
    public String speichern(Testfall testfall) {
        testfallRepository.save(testfall);

        return "redirect:/testfaelle";
    }

    @PostMapping("/testfaelle/ergebnis")
    public String ergebnisSpeichern(@RequestParam Long id,
                                    @RequestParam String ergebnis) {

        Testfall testfall = testfallRepository.findById(id)
                .orElseThrow();

        testfall.setErgebnis(ergebnis);
        testfallRepository.save(testfall);

        return "redirect:/testfaelle";
    }
}