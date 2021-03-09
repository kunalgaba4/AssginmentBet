package com.example.assginmentbet

import com.example.assginmentbet.modal.User
import com.example.assginmentbet.network.ApiServiceClient
import com.example.assginmentbet.utils.UserInfo
import com.example.assginmentbet.viewmodel.LoginViewModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class LoginViewModelTest {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var mockBaseServiceImp: MockBaseServiceImp

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        mockBaseServiceImp = MockBaseServiceImp()
        loginViewModel = LoginViewModel(mockBaseServiceImp)
    }


    @Test
    fun loginSuccess(){
        val mockUser = User("Example",true)
        mockBaseServiceImp.user = mockUser
        val testObserver: TestObserver<User> = TestObserver()
        loginViewModel.loginUser("Example","Weloome@12")?.subscribe(testObserver)
        //no rx errors happened
        testObserver.assertNoErrors()
        val successApiResult = testObserver.values()[0]
        assert(successApiResult.username == mockUser.username)
    }

    @Test
    fun loginFail(){
        val mockUser = User("Error",false)
        mockBaseServiceImp.user = mockUser
        val testObserver: TestObserver<User> = TestObserver()
        loginViewModel.loginUser("Error","Weloome@12")?.subscribe(testObserver)
        //no rx errors happened
        testObserver.assertNoErrors()
        val successApiResult = testObserver.values()[0]
        assert(successApiResult.isSuccessful == mockUser.isSuccessful)
    }
}