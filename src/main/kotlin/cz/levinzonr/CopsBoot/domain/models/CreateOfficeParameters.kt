package cz.levinzonr.CopsBoot.domain.models

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class CreateOfficeParameters(
        @Email
        val email: String,

        @Size(min = 6, max = 100)
        val password: String
)