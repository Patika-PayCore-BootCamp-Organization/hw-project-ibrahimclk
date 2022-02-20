package com.patika.paycore.DebitCardManagement.controller;

import com.patika.paycore.DebitCardManagement.model.Card;
import com.patika.paycore.DebitCardManagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    @GetMapping(value = "/all")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }
}
