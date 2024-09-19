// Base class for users in the app
abstract class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
