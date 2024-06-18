package ee.tlu.Kodutoo05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
