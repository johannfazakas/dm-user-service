package ro.decision.maker.user.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ro.decision.maker.user.transfer.UserOutput

import static org.springframework.http.HttpStatus.OK

@RestController
@RequestMapping("/api/user/v1/users")
class UserController {

    @GetMapping
    @ResponseStatus(OK)
    List<UserOutput> list() {
        return List.of(
                new UserOutput("firstName1", "lastName1", "1@email.com"),
                new UserOutput("firstName2", "lastName2", "2@gmail.com"))
    }
}
