package ru.servachek.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Ganzhenko on 10.11.2016.
 */
public class StringArrayToDate extends JsonDeserializer<Date[]> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");

    @Override
    @SneakyThrows
    public Date[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (p.getValueAsString().equals("")) {
            return null;
        }
        String[] arrString = p.getValueAsString().split(" - ");
        Date[] arrInt = new Date[arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            arrInt[i] = simpleDateFormat.parse(arrString[i]);
        }
        return arrInt;
    }
}

