package com.trilogyed.trilogythesaurus.controller;

import com.trilogyed.trilogythesaurus.model.Definition;
import com.trilogyed.trilogythesaurus.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  THESAURUS CONTROLLER
 *  Will serve as the traffic cop and send the information to the appropriate methods
 */
@RestController
@RefreshScope
public class ThesaurusServiceController {
    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value = "/glossary", method = RequestMethod.POST)
    public Definition createDefinition(@RequestBody Definition definition) {
        return serviceLayer.saveDefinition(definition);
    }

    @RequestMapping(value = "/glossary/term/{term}", method = RequestMethod.GET)
    public List<Definition> getDefinitionsByTerm(@PathVariable String term) {
        return serviceLayer.getDefinitionsByTerm(term);
    }

}
