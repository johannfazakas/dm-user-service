package ro.decision.maker.user.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ro.decision.maker.user.domain.User
import ro.decision.maker.user.persistence.UserRepository
import ro.decision.maker.user.transfer.LoginInput
import ro.decision.maker.user.transfer.UserInput

@Service
class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class)

    private final UserRepository userRepo;

    @Autowired
    UserService(UserRepository userRepo) {
        this.userRepo = userRepo
    }

    User get(String userId) {
        log.info("get >> ${userId}")

        userRepo.findById(userId).get()
    }

    User login(LoginInput input) {
        log.info("login >> ${input}")

        userRepo.findOneByEmail(input.email).get()
    }

    User create(UserInput input) {
        log.info("create >> ${input}")

        userRepo.save(new User(
                firstName: input.getFirstName(),
                lastName: input.getLastName(),
                email: input.getEmail()
        ))
    }
}
