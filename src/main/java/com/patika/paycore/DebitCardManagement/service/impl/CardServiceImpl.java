package com.patika.paycore.DebitCardManagement.service.impl;

import com.patika.paycore.DebitCardManagement.exception.NotFoundException;
import com.patika.paycore.DebitCardManagement.model.Card;
import com.patika.paycore.DebitCardManagement.model.Company;
import com.patika.paycore.DebitCardManagement.repository.CardRepository;
import com.patika.paycore.DebitCardManagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Integer id) {
        Optional<Card> byId = cardRepository.findById(id);

        return byId.orElseThrow(()-> new NotFoundException("card"));
    }

    @Override
    public void addCard(Card card) {
        cardRepository.save(card);

    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public boolean deleteCard(Integer id) {
        cardRepository.delete(getCard(id));
        return true;
    }
}
