package com.example.diary;

public class EditNote {
    private NoteService noteService;

    public EditNote(NoteService noteService) {
        this.noteService = noteService;
    }

    public void editNote(String title, String newTitle, String newContent) {
        Note existingNote = noteService.getNoteByTitle(title);
        if (existingNote != null) {
            existingNote.setTitle(newTitle);
            existingNote.setContent(newContent);
        }
    }

    public static void main(String[] args) {
        NoteService noteService = new NoteService();

        // Добавляем заметку
        noteService.addNote(new Note("Note 1", "Content of Note 1"));

        EditNote editNote = new EditNote(noteService);
        // Редактируем заметку
        editNote.editNote("Note 1", "Updated Note 1", "Updated content for Note 1");

        // Выводим обновленную заметку
        Note updatedNote = noteService.getNoteByTitle("Updated Note 1");
        if (updatedNote != null) {
            System.out.println("Title: " + updatedNote.getTitle());
            System.out.println("Content: " + updatedNote.getContent());
        } else {
            System.out.println("Заметка не найдена.");
        }
    }

}
