package ro.decision.maker.user.transfer

import groovy.transform.ToString

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@ToString(includeNames = true)
class UserInput {

    @NotEmpty
    String firstName;
    @NotEmpty
    String lastName;
    @Email
    String email;
}
