package cz.levinzonr.CopsBoot.services

import cz.levinzonr.CopsBoot.domain.models.User
import cz.levinzonr.CopsBoot.domain.models.UserRole
import cz.levinzonr.CopsBoot.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder


    override fun createOfficer(email: String, password: String) : User {
        val user = userRepository.save(User(
                email = email,
                password = passwordEncoder.encode(password),
                role = setOf(UserRole.OFFICER)

        ))
        return user
    }
}