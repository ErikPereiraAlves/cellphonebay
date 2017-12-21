package com.integritas.cellphonebay.controller;


import com.integritas.cellphonebay.exception.OrderServiceException;
import com.integritas.cellphonebay.model.Order;
import com.integritas.cellphonebay.service.ItemService;
import com.integritas.cellphonebay.service.OrderService;
import com.integritas.cellphonebay.service.ProductService;
import com.integritas.cellphonebay.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static com.integritas.cellphonebay.util.PathUtil.*;

@RestController
@RequestMapping(value = BASE_URI + ORDER)
class OrderController {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = SAVE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> saveOrder(final HttpServletRequest request) {

        LOGGER.debug("!!!!!!!!!!!!!!!!! saving order !!!!!!!!!!!!!!!");
        HttpStatus status = HttpStatus.OK;
        //String json = request.getParameter("order");

        try {
            String json = Util.readJsonFromRequest(request);
            LOGGER.debug("JSON {}", json);
            HashMap<String, String> map = Util.jsonToMap(json);//product and quantity
            Order order = orderService.buildOrder(itemService.buildItems(map));
            orderService.saveOrder(order);
            LOGGER.debug("NEW ORDER CREATED  {}", order.getOrderId());
        } catch (OrderServiceException e) {
            LOGGER.debug("save order exception {}", e);
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(status).body("Order saved");

    }

}