package com.integritas.cellphonebay;

import com.integritas.cellphonebay.model.Order;
import com.integritas.cellphonebay.service.ItemService;
import com.integritas.cellphonebay.service.OrderService;
import com.integritas.cellphonebay.util.Util;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceControllerTest {

    private static final String productJsnon = "{\"productId\":1,\"quantity\":11}";

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceControllerTest.class);

    private MockHttpServletRequest request;

    @Autowired
    private OrderService orderService ;

    @Autowired
    private ItemService itemService;


    @Before
    public void Setup() throws Exception {

        request = new MockHttpServletRequest();
        request.setContentType("application/json");
        request.setMethod("POST");
        MockitoAnnotations.initMocks(orderService);
        MockitoAnnotations.initMocks(itemService);
    }


    public void shouldGetOrder(Long OrderId) throws Exception {

        Order order = orderService.findById(OrderId);
        LOGGER.debug(order.toString());
        assertThat(order.getStatusId(), is(0));

    }

    @Test
    public void shouldPersistMovieDetails() throws Exception {

        SetupOrdeSaveRequest();
        String json = buildStringThatRepresentJsonFromPOSTPayload();
        LOGGER.debug("Json is {}",json);
        LOGGER.debug("orderService is {}",orderService);
        LOGGER.debug("orderItemService is {}",itemService);
        HashMap<String, String> map =  Util.jsonToMap(json);
        Order order= orderService.buildOrder(itemService.buildItems(map));
        orderService.saveOrder(order);


    }



    public void SetupOrdeSaveRequest() throws Exception {

        request = new MockHttpServletRequest();
        request.setContentType("application/json");
        request.setMethod("POST");
        request.setRequestURI("/order/v1/save");
        try {
            request.setContent((productJsnon)
                    .getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String buildStringThatRepresentJsonFromPOSTPayload() {

        String jsonString = "";
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            jsonString = sb.toString();
        } catch (IOException ignored) {
        } finally {
            IOUtils.closeQuietly(reader);
        }
        return jsonString;
    }

}