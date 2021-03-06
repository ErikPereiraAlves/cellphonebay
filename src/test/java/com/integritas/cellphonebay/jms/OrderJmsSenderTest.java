package com.integritas.cellphonebay.jms;


import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.AfterClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderJmsSenderTest {

    private static ApplicationContext applicationContext;

    @Autowired
    void setContext(ApplicationContext applicationContext) {
        OrderJmsSenderTest.applicationContext = applicationContext;
    }

    @AfterClass
    public static void afterClass() {
        ((ConfigurableApplicationContext) applicationContext).close();
    }

    @ClassRule
    public static EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

    @Autowired
    private OrderJmsSender sender;

    @Autowired
    private PaymentJmsReceiver receiver;

    @Test
    public void testReceive() throws Exception {

        sender.send("order.q", "Test order queue");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);

    }
}