package cz.levinzonr.CopsBoot.services

import cz.levinzonr.CopsBoot.domain.models.User
import org.springframework.stereotype.Service
import java.util.*

@Service
interface UserService {

    fun createOfficer(email: String, password: String) : User

    fun getUserById(uuid: UUID) : User?
}