package com.telemedicine.patient.customserde;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telemedicine.patient.dto.AuthRequestDto;
import com.telemedicine.patient.exceptions.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomSerializer implements Serializer<AuthRequestDto> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, AuthRequestDto data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new SerializationException("cannot serialize data");
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, AuthRequestDto data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new SerializationException("cannot serialize data");
        }
    }
    @Override
    public void close() {
        Serializer.super.close();
    }
}