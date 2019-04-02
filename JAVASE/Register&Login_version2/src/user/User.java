package user;

public class User implements Comparable<User>{

    public User() {

    }

    String username;
    String password;
    String name;
    String email;
    int id;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(User o) {
        if (o == null){
            return 1;
        }
        return this.id-o.getId();
    }

    @Override
    public String toString() {
        return username+"的"+"id:"+id;
    }
}
