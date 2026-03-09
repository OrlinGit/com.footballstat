package com.footballstat.Players.Stat.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateDeserializer extends JsonDeserializer<LocalDate> {

    private static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("yy-M-d"),
            DateTimeFormatter.ofPattern("yy-MM-d"),
            DateTimeFormatter.ofPattern("yy-MM-dd"),
            DateTimeFormatter.ofPattern("yy-M-dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/d"),
            DateTimeFormatter.ofPattern("yyyy/M/d"),
            DateTimeFormatter.ofPattern("yy/M/d"),
            DateTimeFormatter.ofPattern("yy/MM/d"),
            DateTimeFormatter.ofPattern("yy/MM/dd"),
            DateTimeFormatter.ofPattern("yy/M/dd"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("d-MM-yyyy"),
            DateTimeFormatter.ofPattern("d-M-yyyy"),
            DateTimeFormatter.ofPattern("dd-M-yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yy"),
            DateTimeFormatter.ofPattern("d-MM-yy"),
            DateTimeFormatter.ofPattern("d-M-yy"),
            DateTimeFormatter.ofPattern("dd-M-yy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("d/MM/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("dd/M/yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yy"),
            DateTimeFormatter.ofPattern("d/MM/yy"),
            DateTimeFormatter.ofPattern("d/M/yy"),
            DateTimeFormatter.ofPattern("dd/M/yy")
    );

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {

        String date = parser.getText();

        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {

            }
        }
        throw new RuntimeException("Date format not valid!");
    }
}
