package com.springlearning.journalApp.service;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public JournalEntry saveEntry(JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        return journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public boolean deleteById(ObjectId id) {
        journalEntryRepo.deleteById(id);
        return true;
    }

    public JournalEntry update(ObjectId id, JournalEntry newEntry) {
        JournalEntry entry = journalEntryRepo.findById(id).orElse(null);
        if (entry != null) {
            entry.setTitle(newEntry.getTitle() != null && newEntry.getTitle().isEmpty() ? newEntry.getTitle() : entry.getTitle());
            entry.setContent(newEntry.getContent() != null && newEntry.getContent().isEmpty() ? newEntry.getContent() : entry.getContent());
            entry.setDate(LocalDateTime.now());
        }
        return journalEntryRepo.save(entry);
    }
}
