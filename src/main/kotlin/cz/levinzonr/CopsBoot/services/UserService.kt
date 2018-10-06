package cz.levinzonr.CopsBoot.services

import cz.levinzonr.CopsBoot.domain.models.User
import org.springframework.stereotype.Service

@Service
interface UserService {

    fun createOfficer(email: String, password: String) : User
}