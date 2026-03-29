package com.springlearning.journalApp.scheduler;

import com.springlearning.journalApp.cache.AppCache;
import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.repository.UserRepositoryImpl;
import com.springlearning.journalApp.service.EmailService;
import com.springlearning.journalApp.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 9 * * SUN")
//    @Scheduled(cron = "0 * * ? * *")
    public void fetchUsersAndSendSAMail() {
        List<User> users = userRepository.getUsersForSA();
        for(User user : users) {
            List<JournalEntry> journalEntries = user.getEntries();
            List<String> contentList = journalEntries.stream().filter(x -> x.getDate()
                            .isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .map(x -> x.getContent()).collect(Collectors.toList());
            String s = String.join(" ", contentList);
            String sentiment = sentimentAnalysisService.getSentiment(s);

            emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days", sentiment);

        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache() {
        appCache.init();
    }
}
