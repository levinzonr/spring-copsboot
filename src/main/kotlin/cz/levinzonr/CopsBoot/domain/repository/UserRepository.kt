package cz.levinzonr.CopsBoot.domain.repository

import cz.levinzonr.CopsBoot.domain.models.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID> {

    fun findByEmailIgnoreCase(email: String) : User?
}