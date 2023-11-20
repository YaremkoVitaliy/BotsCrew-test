package com.yaremko.university.service.impl;

import com.yaremko.university.repository.LectorRepository;
import com.yaremko.university.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String searchByTemplate(String template) {
        return "Answer: " +
                String.join(", ", lectorRepository.findAllByNameLike(template));
    }
}
