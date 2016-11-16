package ru.servachek.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Time;

/**
 * Created by Ganzhenko on 11.11.2016.
 */
public class TimeStringSerializer extends JsonSerializer<Time> {
    @Override
    @SneakyThrows
    public void serialize(Time value, JsonGenerator gen, SerializerProvider serializers) {

    }
}
