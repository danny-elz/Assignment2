package ca.sheridancollege.elzeind.Assignment_2.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class User {
    private String username;
    private String password;
    private String email;
}
