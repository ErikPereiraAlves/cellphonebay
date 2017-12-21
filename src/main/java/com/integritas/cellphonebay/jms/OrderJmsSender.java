package com.integritas.cellphonebay.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class OrderJmsSender {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderJmsSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, String message) {

        LOGGER.info("sending message='{}' to destination='{}'", message, destination);
        jmsTemplate.convertAndSend(destination, message);
    }
}
