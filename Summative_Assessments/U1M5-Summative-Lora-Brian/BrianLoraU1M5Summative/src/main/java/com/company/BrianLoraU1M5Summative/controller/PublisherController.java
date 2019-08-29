package com.company.BrianLoraU1M5Summative.controller;

import com.company.BrianLoraU1M5Summative.dao.PublisherDao;
import com.company.BrianLoraU1M5Summative.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;


    @PostMapping(value = "/publisher")
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherDao.addPublisher(publisher);
    }

    @PutMapping(value = "/publisher")
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePublisher(@RequestBody Publisher publisher) {
        publisherDao.updatePublisher(publisher);
    }

    @GetMapping(value = "/publisher")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return publisherDao.getAllPublishers();
    }

    @GetMapping(value = "/publisher/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int id) {
        return publisherDao.getPublisher(id);
    }

    @DeleteMapping(value = "/publisher/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public void deletePublisher(@PathVariable int id) {
        publisherDao.deletePublisher(id);
    }

}
