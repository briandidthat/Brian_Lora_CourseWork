package com.trilogyed.trilogythesaurus.util.feign;

import com.trilogyed.trilogythesaurus.model.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*Task:
 *
 */
@FeignClient(name="definition-service")
public interface ThesaurusClient {
    @RequestMapping(value="/definition", method= RequestMethod.POST)
    public Definition createDefinition(Definition definition);

    @RequestMapping(value = "/definition/{id}", method = RequestMethod.GET)
    public Definition getDefinition(@PathVariable int id);

    @RequestMapping(value = "/definition/term/{term}", method = RequestMethod.GET)
    public List<Definition> getDefinitionsByTerm(@PathVariable String term);

    @RequestMapping(value = "/definition/{id}", method = RequestMethod.DELETE)
    public void deleteDefinition(@PathVariable int id);

}
