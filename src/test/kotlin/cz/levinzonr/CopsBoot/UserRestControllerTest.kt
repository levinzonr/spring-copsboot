package cz.levinzonr.CopsBoot

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import cz.levinzonr.CopsBoot.controllers.UserRestController
import cz.levinzonr.CopsBoot.domain.models.CreateOfficeParameters
import cz.levinzonr.CopsBoot.services.UserService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity.status
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@RunWith(SpringRunner::class)
@WebMvcTest(UserRestController::class)
class UserRestControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var userService: UserService

    @Test
    fun testCreate() {
        val params = CreateOfficeParameters("a", "a")
        val res = mvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jacksonObjectMapper().writeValueAsString(params)))
                .andReturn()

        assert(res.response.status == 400)
        verify(userService, never()).createOfficer("a", "a")

    }

}