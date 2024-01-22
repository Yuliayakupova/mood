package com.yuliayakupova.mood.dto;

public class MoodType {
    private int id;
    private String moodName;

    public MoodType() {
    }
    public MoodType(int id, String moodName) {
            this.id = id;
            this.moodName = moodName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMoodName() {
            return moodName;
        }

        public void setMoodName(String moodName) {
            this.moodName = moodName;
        }
    }
