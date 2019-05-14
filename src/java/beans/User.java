package beans;

/**
 *
 * @author Herbert Caffarel <herbert.caffarel@cicef.pro>
 */
public class User {
    private int id_User;
    private String email;
    private String password;
    private String name;
    private int etat;
    private int admin;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public User() {
    }
    
    public User(int id_User, String email, String password, String name, int admin, int etat) {
        this.id_User = id_User;
        this.email = email;
        this.password = password;
        this.name = name;
        
        this.etat = etat;
        this.admin = admin;
    }

    public int isAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
    
    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id_User=" + id_User + ", email=" + email + ", password=" + password + ", name=" + name + ", admin=" + admin + ", etat=" + etat + '}';
    }

    
    

}
