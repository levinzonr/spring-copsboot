package cz.levinzonr.CopsBoot

import cz.levinzonr.CopsBoot.controllers.UserRestController
import cz.levinzonr.CopsBoot.services.UserService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@WebMvcTest(UserRestController::class)
class UserRestControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var userService: UserService


}