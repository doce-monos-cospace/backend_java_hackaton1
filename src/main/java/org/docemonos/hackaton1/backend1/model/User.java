package org.docemonos.hackaton1.backend1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    @Length(min = 6)
    private String name;
    private String password;
    private String role;

    public User(@Length(min = 6) String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
