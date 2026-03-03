package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public JournalEntry createJournal(@RequestBody JournalEntry entry) {
        return service.saveEntry(entry);
    }

    @GetMapping("/id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId id) {
        return service.getById(id).orElse(null);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId id) {
        return service.deleteById(id);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry entry) {
        return service.update(id, entry);
    }
}
