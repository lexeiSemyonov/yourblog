package ru.itpark.youblog.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.youblog.domain.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class NotesRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NotesRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Note> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name, content FROM notes",
                (rs, i) -> new Note(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content")
                )
        );
    }

    public Note findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, content FROM notes WHERE id = :id",
                Map.of("id", id),
                (rs, i) -> new Note(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content")
                )
        );
    }

    public void removeById(int id) {
        jdbcTemplate.update(
                "DELETE FROM notes WHERE id = :id",
                Map.of("id", id)
                );
    }

    public void add(Note note) {
        jdbcTemplate.update(
                "INSERT INTO notes(name, content) VALUES(:name, :content)",
                    Map.of("name", note.getName(), "content",  note.getContent())
                );
    }
}
