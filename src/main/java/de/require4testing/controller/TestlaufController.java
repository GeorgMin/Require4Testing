package de.require4testing.controller;

import de.require4testing.model.Testlauf;
import de.require4testing.repository.TestlaufRepository;
import de.require4testing.repository.TesterRepository;
import de.require4testing.repository.TestfallRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestlaufController {

    private final TestlaufRepository testlaufRepository;
    private final TesterRepository testerRepository;
    private final TestfallRepository testfallRepository;

    public TestlaufController(TestlaufRepository testlaufRepository,
                              TesterRepository testerRepository,
                              TestfallRepository testfallRepository) {
        this.testlaufRepository = testlaufRepository;
        this.testerRepository = testerRepository;
        this.testfallRepository = testfallRepository;
    }

    @GetMapping("/testlaeufe")
    public String anzeigen(Model model) {
        model.addAttribute("testlaeufe", testlaufRepository.findAll());
        model.addAttribute("testlauf", new Testlauf());
        model.addAttribute("testerListe", testerRepository.findAll());
        model.addAttribute("testfaelle", testfallRepository.findAll());

        return "testlaeufe";
    }

    @PostMapping("/testlaeufe")
    public String speichern(Testlauf testlauf) {
        testlaufRepository.save(testlauf);

        return "redirect:/testlaeufe";
    }
}