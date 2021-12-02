import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Stream;


public class UserControllerTest
{
    static  UserController userController;
    @BeforeAll
    public static void Instantiate()
    {
        userController = new UserController();
    }

    @ParameterizedTest
    @MethodSource ("loginPassword")
    public void CheckPassword_True(String login, String password)
    {
        User user = new User(login, password);

        boolean result = userController.checkPassword(user);

        Assert.assertEquals(true, result);
    }

    @ParameterizedTest
    @MethodSource("loginPassword")
    public void CheckLogin_True(String login, String password)
    {
        User user = new User(login, password);

        boolean result = userController.checkLogin(user);

        Assert.assertEquals(true, result);
    }


    @ParameterizedTest
    @MethodSource("loginPassword")
    public void AddUserTest_True(String login, String password)
    {
        User user = new User(login, password);

        boolean result = userController.add(user);

        Assert.assertEquals(true, result);
    }

    static Stream<Arguments> loginPassword()
    {
        return Stream.of(

                Arguments.arguments("LoGiN2", "U*@Hjsakjd*@*#ab132"),
                Arguments.arguments("LoGiN1", "U*@HJD9293SDJHJnsdnn"),
                Arguments.arguments("LoGiN2", "U*@Hjsakjd*@*#ab132")

        );
    }

    /*public ArrayList<String> logins = new ArrayList<>();

    @ParameterizedTest
    @ValueSource(strings = {"8213nsda21@#JASD", "8adh1237&**HJH"})
    public void CheckPassword_True(String password)
    {
        User user = new User();

        boolean result = user.checkPassword(password);

        Assert.assertEquals(true, result);
    }

    @ParameterizedTest
    @MethodSource("loginPassword")
    public void CheckLogin_True(String login, String password)
    {
        User user = new User();

        boolean result = user.checkLogin(login, password);

        Assert.assertEquals(true, result);
    }


    @ParameterizedTest
    @MethodSource("loginPassword")
    public void AddUserTest_True(String login, String password)
    {
        User user = new User();
        boolean result;
        if(!logins.contains(login))
        {
            result = user.add(login, password);
            logins.add(login);
        }
        else
            result = false;

        Assert.assertEquals(true, result);
    }

    static Stream<Arguments> loginPassword()
    {
        return Stream.of(
                Arguments.arguments("login1", "121jsadASJDH#%"),
                Arguments.arguments("LoGiN2", "U*@HJD9293SDJHJnsdnn"),
                Arguments.arguments("LoGiN2", "U*@HJD9293SDJHJnsdnn")
        );
    }
*/
}
