package ticketsystem.cput.ac.za.ticketsystem.model;

/**
 * Created by student on 2015/08/05.
 */

public class FullName
{
    private String firstname;
    private String lastname;

    public FullName(String firstname, String lastname)
  {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
