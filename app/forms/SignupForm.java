package forms;

import play.data.validation.Constraints;

/**
 * Created by val on 02/10/15.
 */
public class SignupForm {
    public SignupForm() {
    }

    public SignupForm(final String email) {
        this.email = email;
    }

    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.Required
    @Constraints.MinLength(5)
    public String password;

    @Constraints.Required
    @Constraints.MinLength(5)
    public String cave_name;
}