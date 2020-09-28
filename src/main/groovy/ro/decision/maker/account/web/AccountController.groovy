package ro.decision.maker.account.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ro.decision.maker.account.transfer.AccountOutput

import static org.springframework.http.HttpStatus.OK

@RestController
@RequestMapping("/api/account/v1/accounts")
class AccountController {

    @GetMapping
    @ResponseStatus(OK)
    List<AccountOutput> list() {
        return List.of(
                new AccountOutput("firstName1", "lastName1", "1@email.com"),
                new AccountOutput("firstName2", "lastName2", "2@gmail.com"))
    }
}
