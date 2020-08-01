package Model;

public class User {
    private int id ;
    private  String url;
    private String name;
    private String password;
    private String Description;

    public User(int id, String url, String name, String password, String description) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.password = password;
        Description = description;
    }

    public User(int id, String name, String password, String description) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.password = password;
        Description = description;
    }

    public User(String userName, String password, int id) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
