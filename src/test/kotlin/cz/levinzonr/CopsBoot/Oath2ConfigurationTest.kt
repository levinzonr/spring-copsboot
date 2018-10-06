package cz.levinzonr.CopsBoot

import cz.levinzonr.CopsBoot.security.SecurityConfiguration
import cz.levinzonr.CopsBoot.services.UserService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap



@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class Oath2ConfigurationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var securityConfiguration: SecurityConfiguration

    @Test
    fun getTokenTest() {

        userService.createOfficer("roma@mail.rua", "199616")

        val clientId = securityConfiguration.clientId
        val clientSecret = securityConfiguration.clientSecret
        val params = LinkedMultiValueMap<String, String>()
        params.add("grant_type", "password")
        params.add("client_id", clientId)
        params.add("client_secret", clientSecret)
        params.add("username", "roma@mail.rua")
        params.add("password", "199616")

        mockMvc.perform(post("/oauth/token").params(params)
                .with(httpBasic(clientId, clientSecret))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("access_token").isString()).andExpect(jsonPath("token_type")
                        .value("bearer")).andExpect(jsonPath("refresh_token").isString())
                .andExpect(jsonPath("expires_in").isNumber()).andExpect(jsonPath("scope")
                        .value("mobile_app"))
    }
}