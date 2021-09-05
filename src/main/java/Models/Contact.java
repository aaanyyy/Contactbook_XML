package Models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Contact {

    private Integer id;
    private String name;
    private String phone;

}
