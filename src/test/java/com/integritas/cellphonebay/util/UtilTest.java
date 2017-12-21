package com.integritas.cellphonebay.util;

import com.integritas.cellphonebay.exception.OrderServiceException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilTest.class);

    private static final String json = "{\"productId\":1,\"quantity\":11}";

    private MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        request = new MockHttpServletRequest();
        request.setContentType("application/json");
        request.setMethod("POST");
    }


    @Test
    public void jsonToMap() {
        LOGGER.debug("test");
        try {
            Map<String, String> map = Util.jsonToMap(json);
            map.forEach((k,v)->{
                LOGGER.debug("Key : {} Value :  {}",k , v);
                try{
                    Integer.parseInt(v);
                }catch(NumberFormatException exception){
                    assertFalse("Not a number",true);
                }
            });
        } catch (OrderServiceException e) {
            LOGGER.debug("There was an exception {}",e);
        }

    }

    @Test
    public void isJSONValid() {

        boolean isValid = Util.isJSONValid(json);
        assertTrue(isValid);
    }

    @Test
    public void readJsonFromRequest() {
    }

    @Test
    public void deserializeOrder() {
    }

    @Test
    public void deserializeProduct() {
    }




    private void SetupDetailsPersistRequest() throws Exception {
        request = new MockHttpServletRequest();
        request.setContentType("application/json");
        request.setMethod("POST");
        request.setRequestURI("/order/v1/save");
        try {
            request.setContent((json)
                    .getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}