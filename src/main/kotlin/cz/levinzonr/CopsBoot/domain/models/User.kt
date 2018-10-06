package cz.levinzonr.CopsBoot.domain.models

import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue
        val id: UUID? = null,
        val name: String = "",
        val email: String = "",
        val password: String = "",

        @ElementCollection(fetch = FetchType.EAGER)
        @Enumerated(EnumType.STRING)
        val role: Set<UserRole>
) {
        fun toDto() : UserDto {
                return UserDto(
                        userId = id,
                        email = email,
                        roles = role
                )
        }
}