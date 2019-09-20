package com.trilogyed.trilogythesaurus.service;

import com.trilogyed.trilogythesaurus.model.Definition;
import com.trilogyed.trilogythesaurus.util.feign.ThesaurusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service Layer:
 * Purpose: Perform all necessary CRUD operations for definitions.
 * Explicit words are unacceptable, especially: darn, heck (however, heckler and checkmate are allowed, for example),
 * drat (however, dehydrated is allowed, for example), jerk, butt (however, buttress is allowed, for example)
 * Private methods: validateWord() - will check to ensure that word is family friendly, if not it will throw error
 * Public methods: getDefinitionsByTerm(String term), getDefinition(int id), saveDefinition(Definition definition),
 */
@Component
public class ServiceLayer {
    private ThesaurusClient thesaurusClient;

    @Autowired
    public ServiceLayer(ThesaurusClient thesaurusClient) {
        this.thesaurusClient = thesaurusClient;
    }

    public Definition saveDefinition(Definition definition) {
        validateWord(definition.getTerm());
        return thesaurusClient.createDefinition(definition);
    }

    public Definition getDefinition(int id) {
        return thesaurusClient.getDefinition(id);
    }

    public List<Definition> getDefinitionsByTerm(String term) {
        return thesaurusClient.getDefinitionsByTerm(term);
    }

    public void deleteDefinition(int id) {
        thesaurusClient.deleteDefinition(id);
    }

    private void validateWord(String term) {
        String fixedTerm = term.toLowerCase();
        Map<String,Integer> invalidWords = new HashMap<>();

        invalidWords.put("butt", 0);
        invalidWords.put("jerk", 1);
        invalidWords.put("drat", 2);
        invalidWords.put("darn", 3);
        invalidWords.put("heck", 4);

        if(invalidWords.containsKey(fixedTerm)) {
            throw new IllegalArgumentException("Sorry, this is a family friendly thesaurus. " +
                    "Feel Free to pre-order the adult version available next month.");
        }
    }
}
