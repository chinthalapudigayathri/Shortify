package com.gayathri.projects.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gayathri.projects.model.URLShortner;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class URLShortnerTest {

    @Test
    public void testURLMapping() throws JsonProcessingException {
        /* ObjectMapper is a java jackson class
         *which can serialise - convert java object to json string and
         * deserialise - convert json string to java object
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        URLShortner urlShortner = new URLShortner();
        urlShortner.setId(1l);
        urlShortner.setLongurl("https://mail.colruyt.int");
        urlShortner.setShorturl("mail");
        urlShortner.setCreatedAt(OffsetDateTime.now());
        urlShortner.setUpdatedAt(OffsetDateTime.now());

        String json = mapper.writeValueAsString(urlShortner);
        System.out.println(json);

        URLShortner deserialised = mapper.readValue(json,URLShortner.class);
        assertEquals(urlShortner.getShorturl(), deserialised.getShorturl());

    }
}