package ro.decision.maker.user.persistence

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ro.decision.maker.user.domain.User

@Repository
interface UserRepository extends PagingAndSortingRepository<User, String> {

    Optional<User> findOneByEmail(String email)
}