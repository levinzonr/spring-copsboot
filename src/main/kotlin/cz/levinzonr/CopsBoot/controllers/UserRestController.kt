package cz.levinzonr.CopsBoot.controllers

import cz.levinzonr.CopsBoot.domain.models.CreateOfficeParameters
import cz.levinzonr.CopsBoot.domain.models.UserDto
import cz.levinzonr.CopsBoot.exceptions.ValueNotFoundException
import cz.levinzonr.CopsBoot.security.ApplicationUserDetails
import cz.levinzonr.CopsBoot.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UserRestController {

    @Autowired
    private lateinit var userService: UserService


    @GetMapping("/me")
    fun getCurrentUser(@AuthenticationPrincipal applicationUserDetails: ApplicationUserDetails) : UserDto {
        val user = userService.getUserById(applicationUserDetails.userId) ?: throw ValueNotFoundException("No user by id ${applicationUserDetails.userId}")
        return user.toDto()

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createOfficer(@Valid @RequestBody parameters: CreateOfficeParameters) : UserDto {
        val user = userService.createOfficer(parameters.email, parameters.password)
        return user.toDto()
    }

}