package com.patika.paycore.DebitCardManagement.service;

import com.patika.paycore.DebitCardManagement.model.Card;

import java.util.List;

public interface CardService {

    List<Card> getAllCards();

    Card getCard(Integer id);

    void addCard(Card card);

    Card updateCard(Card card);

    boolean deleteCard(Integer id);

}
