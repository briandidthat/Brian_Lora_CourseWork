package com.company.BrianLoraU1M5Summative.dao;

import com.company.BrianLoraU1M5Summative.model.Publisher;

import java.util.List;


public interface PublisherDao {
    List<Publisher> getAllPublishers();

    Publisher getPublisher(int id);
    Publisher addPublisher(Publisher publisher);

    void updatePublisher(Publisher publisher);
    void deletePublisher(int id);
}
