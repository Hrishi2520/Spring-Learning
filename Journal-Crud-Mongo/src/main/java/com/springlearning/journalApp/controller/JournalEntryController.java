package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService service;

    @GetMapping
    public List<JournalEntry> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void createJournal(@RequestBody JournalEntry entry) {
        service.saveEntry(entry);
    }

    @GetMapping("/id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable String id, @RequestBody JournalEntry entry) {
        return service.update(id, entry);
    }
}
