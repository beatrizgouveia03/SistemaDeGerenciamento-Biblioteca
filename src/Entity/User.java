package Entity;

public class User extends Entity {
    /* Atributes */
    private String name;
    private String login;
    private String password;
    
    /* Constructor */
    User(Integer id, String name, String login, String password){
        super(id);
        this.name = name;
        this.login = login;
        this.password = password;
    }

    /* Methods */
    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Integer getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }
}
