// Regular user of the fitness app
class RegularUser extends User {
    public RegularUser(String name) {
        super(name);
    }

    // Regular users receive updates
    @Override
    public void update(String message) {
        System.out.println(getName() + " (Regular User) got this update: " + message);
    }
}
