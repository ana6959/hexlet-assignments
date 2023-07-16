package exercise.dto;

import exercise.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Data
public class ArticleDto {
    private long id;
    private String name;
    private String body;
    private Category category;
}
// END
