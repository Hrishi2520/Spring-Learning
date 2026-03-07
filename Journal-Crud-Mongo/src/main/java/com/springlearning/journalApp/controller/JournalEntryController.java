package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.service.JournalEntryService;
import com.springlearning.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService service;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<List<JournalEntry>> getAll(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<?> createJournal(@RequestBody JournalEntry entry, @PathVariable String userName) {
        try {
            service.saveEntry(entry, userName);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId id) {
        Optional<JournalEntry> entry = service.getById(id);
        return entry.map(journalEntry -> new ResponseEntity<>(journalEntry, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/id/{userName}/{id}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId id, @PathVariable String userName) {
        service.deleteById(id, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry entry) {
        JournalEntry update = service.update(id, entry);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
