package com.yuliayakupova.mood.controller;

import com.yuliayakupova.mood.dto.Mood;
import com.yuliayakupova.mood.dto.MoodType;
import com.yuliayakupova.mood.dto.User;
import com.yuliayakupova.mood.repo.MoodRepository;
import com.yuliayakupova.mood.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
;
import java.util.List;

public class MoodController {
    private final MoodRepository moodRepository;

    private final UserRepository userRepository;

    @Autowired
    public MoodController(MoodRepository moodRepository, UserRepository userRepository) {
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/mood")
    public ResponseEntity<Void> createNewMood(@RequestBody Mood mood, @RequestParam Long userId, @RequestParam String moodName) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MoodType moodType = moodRepository.findMoodTypeByMoodName(moodName);
        if (moodType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        moodRepository.saveMoodData(mood, user, moodType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/moods")
    public List<Mood> getAllMood() {
        return moodRepository.getAllMood();
    }
}
