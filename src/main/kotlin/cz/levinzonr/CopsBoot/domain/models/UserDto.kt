package cz.levinzonr.CopsBoot.domain.models

import java.util.*

class UserDto(
        val userId: UUID?,
        val email: String?,
        val roles: Set<UserRole>?
)