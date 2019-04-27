package com.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author xiepengfei 2019/1/31
 */
public class JacksonMapper {
    public static void main(String[] args) {

        Test test = new Test("xxx", 3, new Long[]{3L,5L});
        test(test);
    }

    private static void test(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
