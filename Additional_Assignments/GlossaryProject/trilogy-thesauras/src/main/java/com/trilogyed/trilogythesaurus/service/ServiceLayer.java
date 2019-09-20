package com.trilogyed.trilogythesaurus.service;

import com.trilogyed.trilogythesaurus.model.Definition;
import com.trilogyed.trilogythesaurus.util.feign.TheasurusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private TheasurusClient theasurusClient;

    @Autowired
    public ServiceLayer(TheasurusClient theasurusClient) {
        this.theasurusClient = theasurusClient;
    }

    public Definition saveDefinition(Definition definition) {
        return theasurusClient.createDefinition(definition);
    }

    public Definition getDefinition(int id) {
        return theasurusClient.getDefinition(id);
    }

    public List<Definition> getDefinitionsByTerm(String term) {
        return theasurusClient.getDefinitionsByTerm(term);
    }

    private boolean validateWord(String term) {
        boolean isValid = false;

        return isValid;
    }
}
