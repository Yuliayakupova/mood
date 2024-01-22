package com.yuliayakupova.mood.dto;

import java.time.LocalDateTime;

public class Mood {
        private User user;
        private MoodType moodType;
        private String moodValue;
        private LocalDateTime moodTimestamp;

        public Mood() {
        }
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public MoodType getMoodType() {
            return moodType;
        }

        public void setMoodType(MoodType moodType) {
            this.moodType = moodType;
        }

        public String getMoodValue() {
            return moodValue;
        }

        public void setMoodValue(String moodValue) {
            this.moodValue = moodValue;
        }

        public LocalDateTime getMoodTimestamp() {
            return moodTimestamp;
        }

        public void setMoodTimestamp(LocalDateTime moodTimestamp) {
            this.moodTimestamp = moodTimestamp;
        }
    }

}