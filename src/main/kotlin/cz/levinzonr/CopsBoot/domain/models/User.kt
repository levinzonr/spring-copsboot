package cz.levinzonr.CopsBoot.domain.models

import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id
        val id: UUID? = null,
        val name: String? = null,
        val email: String? = null,
        val password: String? = null,

        @ElementCollection(fetch = FetchType.EAGER)
        @Enumerated(EnumType.STRING)
        val role: Set<UserRole>
)