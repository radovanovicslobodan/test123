package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    String name;
    String gender;
    String email;
    String status;
}