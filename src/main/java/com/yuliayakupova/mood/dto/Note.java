package com.yuliayakupova.mood.dto;

import java.util.Date;

public class Note {
    private int id;

    private String noteText;

    private Date noteTimestamp;

    public Note(int id, String noteText, Date noteTimestamp) {
            this.id = id;
            this.noteText = noteText;
            this.noteTimestamp = noteTimestamp;
    }

    public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getNoteText() {
            return noteText;
        }

        public void setNoteText(String noteText) {
            this.noteText = noteText;
        }

        public Date getNoteTimestamp() {
            return noteTimestamp;
        }

        public void setNoteTimestamp(Date noteTimestamp) {
            this.noteTimestamp = noteTimestamp;
        }
    }