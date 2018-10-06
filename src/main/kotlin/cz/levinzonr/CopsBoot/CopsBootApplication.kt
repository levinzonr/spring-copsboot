package cz.levinzonr.CopsBoot

import cz.levinzonr.CopsBoot.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication


@SpringBootApplication
class CopsBootApplication {

    @Autowired
    private lateinit var userService: UserService

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun tokenStore() : TokenStore {
        return InMemoryTokenStore()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CopsBootApplication::class.java, *args)
        }
    }

    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner {
            userService.createOfficer("roma@mail.ru", "199616")
        }
    }
}