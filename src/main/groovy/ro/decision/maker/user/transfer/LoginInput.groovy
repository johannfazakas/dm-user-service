package ro.decision.maker.user.transfer

import groovy.transform.ToString

import javax.validation.constraints.Email

@ToString(includeNames = true)
class LoginInput {

    @Email
    String email
}
