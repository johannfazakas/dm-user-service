package ro.decision.maker.user.transfer

import groovy.transform.ToString
import ro.decision.maker.user.domain.User

@ToString(includeNames = true)
class UserOutput {

    String id;
    String firstName;
    String lastName;
    String email;

    UserOutput() {
    }

    UserOutput(User user) {
        this.id = user.id
        this.firstName = user.firstName
        this.lastName = user.lastName
        this.email = user.email
    }
}
