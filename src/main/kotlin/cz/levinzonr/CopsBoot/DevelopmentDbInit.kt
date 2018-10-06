package cz.levinzonr.CopsBoot

import cz.levinzonr.CopsBoot.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class DevelopmentDbInit : ApplicationRunner {

    @Autowired
    lateinit var userService: UserService

    override fun run(args: ApplicationArguments?) {

    }

}