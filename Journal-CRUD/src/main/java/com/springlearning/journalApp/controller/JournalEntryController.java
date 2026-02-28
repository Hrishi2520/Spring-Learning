package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public void createJournal(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        System.out.println("Entry added..");
    }

    @GetMapping("/id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable long id) {
        return journalEntries.getOrDefault(id, null);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable long id) {
        journalEntries.remove(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id, @RequestBody JournalEntry entry) {
        return journalEntries.put(id, entry);
    }
}
