import com.example.androidlabs.DB.models.User
import com.example.androidlabs.DB.repository.UserRepository
import com.example.androidlabs.api.BackendService
import com.example.androidlabs.api.model.UserRemoteSignIn
import com.example.androidlabs.api.model.toUser
import com.example.androidlabs.api.model.toUserRemote

class RestUserRepository(
    private var service: BackendService
): UserRepository {
    override suspend fun createUser(user: User) {
        service.SignUp(user.toUserRemote())
    }

    override suspend fun updateUser(user: User) {
        println()
    }

    override suspend fun deleteUser(user: User) {
        println()
    }
    override suspend fun authUser(user: UserRemoteSignIn): User {
        return service.SignIn(user).toUser()
    }
}