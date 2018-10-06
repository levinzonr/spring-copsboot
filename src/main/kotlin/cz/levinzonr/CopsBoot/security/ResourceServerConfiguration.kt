package cz.levinzonr.CopsBoot.security

import cz.levinzonr.CopsBoot.security.Constants.RESOURCE_ID
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.BeanIds



@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    override fun configure(resources: ResourceServerSecurityConfigurer?) {
        super.configure(resources)
        resources?.resourceId(RESOURCE_ID)
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        http?.let {
            http.authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() .and()
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                    .anyRequest()?.authenticated()
        }

    }



}