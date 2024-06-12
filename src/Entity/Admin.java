package Entity;

public class Admin extends User {
    /* Constructor */
    Admin(Integer id, String name, String email, String password){
        super(id, name, email, password);
    }

    /* Methods */
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }
}
