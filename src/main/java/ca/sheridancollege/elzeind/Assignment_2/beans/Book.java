package ca.sheridancollege.elzeind.Assignment_2.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Data

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String price;
    private String description;


}
