package com.springlearning.journalApp.service;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry entry) {
        journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public JournalEntry getById(ObjectId id) {
        return journalEntryRepo.findById(id).orElse(null);
    }

    public boolean deleteById(ObjectId id) {
        journalEntryRepo.deleteById(id);
        return true;
    }

    public JournalEntry update(ObjectId id, JournalEntry entry) {
        JournalEntry entry1 = journalEntryRepo.findById(id).get();
        entry1.setId(entry.getId());
        entry1.setTitle(entry.getTitle());
        entry1.setContent(entry.getContent());
        entry1.setDate(entry.getDate());
        return journalEntryRepo.save(entry1);

    }
}
