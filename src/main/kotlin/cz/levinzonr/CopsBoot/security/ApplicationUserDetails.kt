package cz.levinzonr.CopsBoot.security

import cz.levinzonr.CopsBoot.domain.models.UserRole
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.util.*

class ApplicationUserDetails(user: cz.levinzonr.CopsBoot.domain.models.User)
    : User(user.email, user.password, createAuthorities(user.role)) {

    val userId: UUID? = user.id

    companion object {
        private const val ROLE_PREFIX = "ROLE_"

        fun createAuthorities(roles: Set<UserRole>) : Collection<SimpleGrantedAuthority> {
            return roles.map { SimpleGrantedAuthority("$ROLE_PREFIX ${it.name}") }
        }

    }
}