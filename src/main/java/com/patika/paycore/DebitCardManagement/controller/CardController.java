package com.patika.paycore.DebitCardManagement.controller;

import com.patika.paycore.DebitCardManagement.model.Card;
import com.patika.paycore.DebitCardManagement.model.Company;
import com.patika.paycore.DebitCardManagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/card")
@Validated
public class CardController {

    private final CardService cardService;

    @GetMapping(value = "/all")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping(value = "/{id}")
    public Card getCard(@PathVariable Integer id){
        return cardService.getCard(id);
    }

    @PostMapping(value = "/create")
    public void saveCard(@Valid @RequestBody Card card){
        cardService.addCard(card);
    }

    @PutMapping(value = "/update")
    public Card updateCard(@Valid @RequestBody Card card){
        return cardService.updateCard(card);
    }

}
