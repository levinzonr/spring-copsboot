package cz.levinzonr.CopsBoot.security

import cz.levinzonr.CopsBoot.security.Constants.RESOURCE_ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration : AuthorizationServerConfigurerAdapter()  {

   @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var userDetailsService: ApplicationUserDetailsService

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var tokenStore: TokenStore


    override fun configure(security: AuthorizationServerSecurityConfigurer?) {
        super.configure(security)
        security?.passwordEncoder(passwordEncoder)
    }



    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        super.configure(clients)
        clients?.inMemory()
                ?.withClient("copsboot-mobile-client")
                ?.authorizedGrantTypes("password", "refresh_token")
                ?.scopes("mobile_app")
                ?.resourceIds(RESOURCE_ID)
                ?.secret(passwordEncoder.encode("ccUyb6vS4S8nxfbKPCrN"))
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        super.configure(endpoints)
        endpoints
                ?.tokenStore(tokenStore)
                ?.authenticationManager(authenticationManager)
                ?.userDetailsService(userDetailsService)
    }

}