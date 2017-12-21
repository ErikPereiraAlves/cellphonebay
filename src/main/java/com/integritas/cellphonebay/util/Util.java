package com.integritas.cellphonebay.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.integritas.cellphonebay.exception.OrderServiceException;
import com.integritas.cellphonebay.model.Order;
import com.integritas.cellphonebay.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Util {

    private static final Type ORDER_COLLECTION_TYPE_TOKEN = new TypeToken<Collection<Order>>() {
    }.getType();

    private static final Type PRODUCT_COLLECTION_TYPE_TOKEN = new TypeToken<Collection<Product>>() {
    }.getType();

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    private static final Gson GSON = new Gson();


    public static boolean isJSONValid(String jsonInString) {

        try {
            GSON.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static String readJsonFromRequest(HttpServletRequest request) throws OrderServiceException {

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            LOGGER.error("Unable to read Json from Request!", e);
            throw new OrderServiceException("Error while parsing json from request, please check format. Error Message:" + e.getMessage());

        }
    }

    public static Collection<Order> deserializeOrder( String jsonAsString) throws OrderServiceException {

        return deserializeOrder(ORDER_COLLECTION_TYPE_TOKEN, jsonAsString);
    }

    public static Collection<Order> deserializeProduct(String jsonAsString) throws OrderServiceException {

        return deserializeOrder(PRODUCT_COLLECTION_TYPE_TOKEN, jsonAsString);
    }


    public static Collection<Order> deserializeOrder(Type type, String jsonAsString) throws OrderServiceException {

        if (StringUtils.isNotBlank(jsonAsString)) {
            String trimmedJsonLogs = jsonAsString.trim();
            try {
                return GSON.fromJson(trimmedJsonLogs, ORDER_COLLECTION_TYPE_TOKEN);
            } catch (Exception e) {
                LOGGER.error("Error while parsing order [{}]", trimmedJsonLogs, e);
                throw new OrderServiceException("Error while parsing json: " + trimmedJsonLogs + " Error Message:" + e.getMessage());
            }
        }
        return Collections.emptyList();
    }

    public static HashMap<String, String> jsonToMap(String s) throws OrderServiceException {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(s);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key);
            LOGGER.debug("key : {} value {}",key,value);
            map.put(key, value);
        }

        LOGGER.debug("json : {}",jObject);
        LOGGER.debug("map {}: ",map);

        if(0 == map.size()){
            throw new OrderServiceException("Unable to retrieve json from request");
        }

        return map;
    }

    public static java.sql.Date getCurrentTS(){

        return new java.sql.Date(System.currentTimeMillis());
    }
}
