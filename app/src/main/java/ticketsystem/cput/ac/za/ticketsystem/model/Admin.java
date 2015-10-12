package ticketsystem.cput.ac.za.ticketsystem.model;

/**
 * Created by student on 2015/08/07.
 */

public class Admin {

    private Long id;
    private Login LoginDeats;
    private FullName FullNameDeats;

    //Get Methods


    public Admin(Login LoginDeats, FullName FullNameDeats) {
        this.LoginDeats = LoginDeats;
        this.FullNameDeats = FullNameDeats;
    }

    public Long getID() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Login getLoginDeats() {
        return LoginDeats;
    }

    public void setLoginDeats(Login loginDeats) {
        LoginDeats = loginDeats;
    }

    public FullName getFullNameDeats() {
        return FullNameDeats;
    }

    public void setFullNameDeats(FullName fullNameDeats) {
        FullNameDeats = fullNameDeats;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", LoginDeats=" + LoginDeats +
                ", FullNameDeats=" + FullNameDeats +
                '}';
    }
}
