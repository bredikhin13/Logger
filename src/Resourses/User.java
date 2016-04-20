package Resourses;

public class User {
    private String mail;
    private String password;
    private String role;
    public User (String mail, String pass, String role){
        this.mail = mail;
        this.password = pass;
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
