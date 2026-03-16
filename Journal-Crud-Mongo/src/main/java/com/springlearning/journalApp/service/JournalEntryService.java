package com.springlearning.journalApp.service;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.repository.JournalEntryRepo;
import com.springlearning.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry entry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            entry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepo.save(entry);
            user.getEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error Occurred");
        }
    }

    public void saveEntry(JournalEntry entry) {
        journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveEntry(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An Error Occurred while removing the entry..");
        }
        return removed;
    }

    public JournalEntry update(ObjectId id, JournalEntry newEntry, String userName) {
        User user = userService.findByUserName(userName);
        JournalEntry entry = journalEntryRepo.findById(id).orElse(null);
        if (entry != null) {
            entry.setTitle(!newEntry.getTitle().isEmpty() ? newEntry.getTitle() : entry.getTitle());
            entry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : entry.getContent());
            entry.setDate(LocalDateTime.now());
            journalEntryRepo.save(entry);
        }
        return entry;
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }
}
