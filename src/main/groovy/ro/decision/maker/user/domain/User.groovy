package ro.decision.maker.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User {

    @Id
    String id
    String firstName
    String lastName
    @Indexed(unique = true)
    String email
}
