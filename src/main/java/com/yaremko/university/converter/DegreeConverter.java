package com.yaremko.university.converter;

import com.yaremko.university.model.Degree;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class DegreeConverter implements AttributeConverter<Degree, String> {

    @Override
    public String convertToDatabaseColumn(Degree degree) {
        if (degree == null) {
            return null;
        }
        return degree.getDegree();
    }

    @Override
    public Degree convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Degree.values())
                .filter(degree -> degree.getDegree().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
