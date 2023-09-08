package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    int id;
    String name;
    String gender;
    String email;
    String status;
}