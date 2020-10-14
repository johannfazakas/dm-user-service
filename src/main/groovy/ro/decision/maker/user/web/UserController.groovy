package ro.decision.maker.user.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import ro.decision.maker.user.transfer.LoginInput
import ro.decision.maker.user.transfer.UserInput
import ro.decision.maker.user.transfer.UserOutput

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

@RestController
@RequestMapping("/api/user/v1/users")
class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class)

    @GetMapping("/{userId}")
    @ResponseStatus(OK)
    UserOutput get(@PathVariable(name = "userId") String id) {
        log.info("get >> ${id}")

        return new UserOutput(
                id: id,
                firstName: "Johann",
                lastName: "Fazakas",
                email: "johannfazakas@gmail.com"
        )
    }

    @PostMapping("/login")
    @ResponseStatus(OK)
    UserOutput login(@RequestBody LoginInput input) {
        log.info("login >> ${input}")

        return new UserOutput(
                id: UUID.randomUUID(),
                firstName: "Johann",
                lastName: "Fazakas",
                email: input.getEmail()
        )
    }


    @PostMapping
    @ResponseStatus(CREATED)
    UserOutput create(@RequestBody UserInput input) {
        log.info("create >> ${input}")

        return new UserOutput(
                id: UUID.randomUUID(),
                firstName: input.firstName,
                lastName: input.lastName,
                email: input.email
        )
    }
}
