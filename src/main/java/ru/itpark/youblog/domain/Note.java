package ru.itpark.youblog.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private int id;
    private String name;
    private String content;

}
