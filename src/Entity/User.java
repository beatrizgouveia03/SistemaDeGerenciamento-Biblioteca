package Entity;

public class User extends Entity {
    /* Attributes */
    private String name;
    private String login;
    private String password;
    
    /* Constructor */
    public User(String name, String login, String password){
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
    public String toString() {
        String str = this.getId() + " - Name: " + this.name;
        str += "\nUsername: " + this.login;

        return str;
    }
}
