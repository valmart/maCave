package forms;

import play.data.validation.Constraints;

/**
 * Created by val on 02/10/15.
 */
public class LoginForm {
    public LoginForm() { }

    public LoginForm(final String email) {
        this.email = email;
    }

    @Constraints.Required
    @Constraints.MinLength(6)
    public String password;

    @Constraints.Required
    @Constraints.Email
    public String email;
}
