package ro.decision.maker.user.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ro.decision.maker.user.service.UserService
import ro.decision.maker.user.transfer.LoginInput
import ro.decision.maker.user.transfer.UserInput
import ro.decision.maker.user.transfer.UserOutput

import javax.validation.Valid

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

@RestController
@RequestMapping("/api/user/v1/users")
class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class)

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService
    }

    @GetMapping("/{userId}")
    @ResponseStatus(OK)
    UserOutput get(@PathVariable(name = "userId") String id) {
        log.info("get >> ${id}")

        new UserOutput(userService.get(id))
    }

    @PostMapping("/login")
    @ResponseStatus(OK)
    UserOutput login(@Valid @RequestBody LoginInput input) {
        log.info("login >> ${input}")

        new UserOutput(userService.login(input))
    }

    @PostMapping
    @ResponseStatus(CREATED)
    UserOutput create(@Valid @RequestBody UserInput input) {
        log.info("create >> ${input}")

        new UserOutput(userService.create(input))
    }
}
