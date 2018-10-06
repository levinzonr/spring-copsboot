package cz.levinzonr.CopsBoot.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties(prefix = "copsboot-security")
class SecurityConfiguration{
    var clientId: String = ""
    var clientSecret: String = ""

}