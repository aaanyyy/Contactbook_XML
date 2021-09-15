package Models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "Contact")

public class Contact implements Serializable {

    private Integer id;
    private String name;
    private String phone;


}
