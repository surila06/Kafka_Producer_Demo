package com.kafka.cab_book_driver.service;

import com.kafka.cab_book_driver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    //send loaction to Kafka topic using KafkaTemplate
    //If topic not available Kafka will create the topic and configure it
    public boolean updateLocation(String location)
    {

       kafkaTemplate.send(AppConstant.CAB_LOCATION,location);
        return true;
    }
}
