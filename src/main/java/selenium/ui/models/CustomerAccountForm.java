package selenium.ui.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerAccountForm {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String confirmPassword;

}
