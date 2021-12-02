import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserController
{
    public UserContext userContext;

    public UserController()
    {
        userContext = new UserContext();
    }

    public boolean add(User user)
    {
        boolean result = false;
        if(checkPassword(user) && checkLogin(user))
        {
            userContext.Users.add(user);
            result = true;
        }

        return result;
    }

    public boolean checkPassword(User user)
    {
        boolean checked = false;
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$";

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(user.Password);

        if(matcher.matches())
        {
            checked = true;
        }

        return checked;
    }

    public boolean checkLogin(User user)
    {
        ArrayList<String> logins = new ArrayList<>();
        for(int i = 0; i < userContext.Users.size(); i++)
        {
            User u = userContext.Users.get(i);
            logins.add(u.Login);
        }
        boolean checked = false;

        if(!user.Login.equals(user.Password) && !logins.contains(user.Login))
        {
            checked = true;
        }

        return checked;
    }
}
