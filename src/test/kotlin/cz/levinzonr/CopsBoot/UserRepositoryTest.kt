package cz.levinzonr.CopsBoot

import cz.levinzonr.CopsBoot.domain.models.User
import cz.levinzonr.CopsBoot.domain.models.UserRole
import cz.levinzonr.CopsBoot.domain.repository.UserRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private lateinit var userRepository: UserRepository


    @Test
    fun testStoreUser() {
        val roles = setOf(UserRole.OFFICER)
        val user = userRepository.save(User(
                email = "roma@mail.ru",
                password = "199616",
                role = roles
        ))

        assert(user != null)
        assert(user.id != null)
        assert(userRepository.count() == 1L)

    }

    @Test
    fun testFindByEmail() {
        val rolse = setOf(UserRole.OFFICER)
        val user = userRepository.save(User(
                email = "roma@mail.ru",
                password = "199616",
                role = rolse

        ))

       var found = userRepository.findByEmailIgnoreCase("email")
        assert(found == null)
        found = userRepository.findByEmailIgnoreCase("roma@mail.ru")
        assert(found != null)

    }

}