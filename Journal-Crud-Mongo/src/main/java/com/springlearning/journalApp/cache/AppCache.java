package com.springlearning.journalApp.cache;

import com.springlearning.journalApp.entity.ConfigJournalAppEntity;
import com.springlearning.journalApp.repository.ConfigJournalAppRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    public Map<String, String> APP_CACHE = new HashMap<>();

    @PostConstruct
    public void init() {
        List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();
        all.stream().map(e -> APP_CACHE.put(e.getKey(), e.getValue())).toList();
    }
}
