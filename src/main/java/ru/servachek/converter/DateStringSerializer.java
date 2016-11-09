package ru.servachek.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ganzhenko on 08.11.2016.
 */
public class DateStringSerializer extends JsonSerializer<Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    @SneakyThrows
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) {
        String format = simpleDateFormat.format(value);
        gen.writeString(format);
    }
}
