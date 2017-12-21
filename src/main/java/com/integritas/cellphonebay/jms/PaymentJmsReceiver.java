package com.integritas.cellphonebay.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.util.concurrent.CountDownLatch;

public class PaymentJmsReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentJmsReceiver.class);



    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "${order.q}")
    public void receive(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }

/*
    @JmsListener(destination = "${order.q}")
    public void receive2(@Payload Order order,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        LOGGER.info("received <" + order + ">");

        LOGGER.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        LOGGER.info("######          Message Details           #####");
        LOGGER.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        LOGGER.info("headers: " + headers);
        LOGGER.info("message: " + message);
        LOGGER.info("session: " + session);
        LOGGER.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
*/
}
