package ru.servachek.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ganzhenko on 08.11.2016.
 */
public class StringDateDeserializer extends JsonDeserializer<Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    @SneakyThrows
    public Date deserialize(JsonParser p, DeserializationContext ctxt){
        String valueAsString = p.getValueAsString();
        return simpleDateFormat.parse(valueAsString);
    }
}
