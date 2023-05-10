package com.yaremko.university.service.impl;

import com.yaremko.university.model.Lector;
import com.yaremko.university.repository.LectorRepository;
import com.yaremko.university.service.LectorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String searchByTemplate(String template) {
        StringBuilder answer = new StringBuilder("Answer: ");
        List<String> lectorNames = lectorRepository.findAll()
                .stream()
                .map(Lector::getName)
                .toList();
        for (String name : lectorNames) {
            if (name.contains(template)) {
                answer.append(name).append(", ");
            }
        }
        return answer.delete(answer.length() - 2, answer.length()).toString();
    }
}
