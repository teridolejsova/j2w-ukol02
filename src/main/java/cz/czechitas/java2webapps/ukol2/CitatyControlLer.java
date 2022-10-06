package cz.czechitas.java2webapps.ukol2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class CitatyControlLer {
    public final Random random = new Random();
    List<String> obrazky =List.of("https://source.unsplash.com/j9Kp9Tq-BmE",
            "https://source.unsplash.com/2PODhmrvLik",
            "https://source.unsplash.com/QFc2kxpXVYQ",
            "https://source.unsplash.com/uq2E2V4LhCY",
            "https://source.unsplash.com/r38u2Uq1AXk",
            "https://source.unsplash.com/4rDCa5hBlCs",
            "https://source.unsplash.com/7K24SkQUbSw",
            "https://source.unsplash.com/EAay7Aj4jbc",
            "https://source.unsplash.com/KMn4VEeEPR8",
            "https://source.unsplash.com/4qgJ2E28Uvw");


    @GetMapping("/")
    public ModelAndView nahodneCitaty() throws IOException {

        List<String> randomCitaty = FilesReader.readAllLines("citaty.txt");
        int pocetCitatu = randomCitaty.size();
        int nahodneCislo = random.nextInt(pocetCitatu);
        String nahodnyCitat = randomCitaty.get(nahodneCislo);

        String nahodnyObrazek = obrazky.get(random.nextInt(obrazky.size()));
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("nahodnyCitat", nahodnyCitat);
        modelAndView.addObject("nahodnyObrazek",nahodnyObrazek);
        return modelAndView;
    }


}
