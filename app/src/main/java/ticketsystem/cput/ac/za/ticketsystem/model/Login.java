package ticketsystem.cput.ac.za.ticketsystem.model;


/**
 * Created by student on 2015/08/05.
 */

public class Login
{

    private String loginEmail;
    private String password;

   public Login(String loginEmail, String password)
   {
        this.loginEmail = loginEmail;
        this.password = password;
    }

    //Get Methods
    public String getLoginEmail()
    {
        return loginEmail;
    }

    public String getPassword()
    {
        return password;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginEmail='" + loginEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
