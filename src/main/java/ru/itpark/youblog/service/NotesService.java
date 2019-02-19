package ru.itpark.youblog.service;

import org.springframework.stereotype.Service;

import ru.itpark.youblog.domain.Note;
import ru.itpark.youblog.repository.NotesRepository;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Note> findAll() {
        return notesRepository.findAll();
    }

    public Note findById(int id) {
        return notesRepository.findById(id);
    }

    public void removeById(int id) {
        notesRepository.removeById(id);
    }

    public void add(Note note) {
        notesRepository.add(note);
    }
}

