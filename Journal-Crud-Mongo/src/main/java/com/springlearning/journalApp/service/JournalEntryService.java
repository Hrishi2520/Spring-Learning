package com.springlearning.journalApp.service;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.repository.JournalEntryRepo;
import com.springlearning.journalApp.repository.UserRepo;
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

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(JournalEntry entry, String userName) {
        User user = userRepo.findByUserName(userName);
        System.out.println(user);
        entry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepo.save(entry);
        user.getEntries().add(saved);
        userRepo.save(user);
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
            entry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : entry.getTitle());
            entry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : entry.getContent());
            entry.setDate(LocalDateTime.now());
            journalEntryRepo.save(entry);
        }
        return entry;
    }
}
