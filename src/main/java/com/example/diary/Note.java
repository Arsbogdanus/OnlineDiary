package com.example.diary;

import java.util.List;
import java.util.ArrayList;

public class Note {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Геттеры и сеттеры для заголовка и контента

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class NoteService {
    private List<Note> notes;

    public NoteService() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNoteByTitle(String title) {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                return note;
            }
        }
        return null; // Вернуть ноль, если заметка не найдена
    }

    public void updateNote(String title, String newTitle, String newContent) {
        Note existingNote = getNoteByTitle(title);
        if (existingNote != null) {
            existingNote.setTitle(newTitle);
            existingNote.setContent(newContent);
        }
    }
}