package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteControllerTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteController noteController;

    private Note sampleNote;

    @BeforeEach
    void setUp() {
        sampleNote = new Note();
        sampleNote.setId(1L);
        sampleNote.setTitle("Test Note");
        sampleNote.setContent("Test Content");
        sampleNote.setCreatedAt(new Date());
        sampleNote.setUpdatedAt(new Date());
    }

    @Test
    void getAllNotes() {

        when(noteRepository.findAll()).thenReturn(Arrays.asList(sampleNote));

        List<Note> result = noteController.getAllNotes();

        assertEquals(1, result.size());
        assertEquals(sampleNote, result.get(0));
    }

    @Test
    void getNoteById() {
        when(noteRepository.findById(1L)).thenReturn(Optional.of(sampleNote));

        Note result = noteController.getNoteById(1L);

        assertEquals(sampleNote, result);
    }

    @Test
    void getNoteById_NotFound() {
        when(noteRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> noteController.getNoteById(2L));
    }

    @Test
    void createNote() {
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(sampleNote);

        Note result = noteController.createNote(sampleNote);

        assertEquals(sampleNote, result);
    }

}

