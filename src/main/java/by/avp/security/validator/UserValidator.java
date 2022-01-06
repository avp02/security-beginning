package by.avp.security.validator;

import by.avp.security.model.User;
import by.avp.security.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");

        if (user.getUserName().length() < 8 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }

        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "Dublicate.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "Required");
        if (user.getUserPassword().length() < 8) {
            errors.rejectValue("userPassword", "Size.userForm.userPassword");
        }

        if (!user.getConfirmPassword().equals(user.getUserPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
