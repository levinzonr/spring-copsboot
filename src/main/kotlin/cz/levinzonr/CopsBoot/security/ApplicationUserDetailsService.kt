package cz.levinzonr.CopsBoot.security

import cz.levinzonr.CopsBoot.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class ApplicationUserDetailsService : UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository


    override fun loadUserByUsername(username: String?): UserDetails {
        username?.let {
            val user = userRepository.findByEmailIgnoreCase(it) ?: throw UsernameNotFoundException("No user by name $it")
            return ApplicationUserDetails(user)
        }
        throw NullPointerException("Email cant ve null")
    }
}