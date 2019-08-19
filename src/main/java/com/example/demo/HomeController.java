package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    CardRepository cardRepository;

    Deck deckofcard = new Deck(4);


    public ArrayList<Card> convertToArray(Deck carddeck) {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < carddeck.getSz(); i++) {
            for (int j = 0; j < carddeck.getSz(); j++) {
                cards.add(carddeck.getCard(i, j));
            }
        }

        return cards;
    }

    @RequestMapping("/")
    public String homepage(Model model) {
        ArrayList<Card> cards;

        deckofcard.shuffleCards();
        cards = convertToArray(deckofcard);
        model.addAttribute("allcards", cards);

        return "showboard";
    }

    @RequestMapping ("/selectcard/{id}")
    public String selectCard (@PathVariable("id") String id, Model model) {
        Card curcard;


        return "showboard";
    }

}