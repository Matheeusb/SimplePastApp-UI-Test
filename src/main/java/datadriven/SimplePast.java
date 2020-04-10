package datadriven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimplePast {

    private int id;
    private String baseForm;
    private String pastTenseForm;
    private String pastParticipleForm;

}
