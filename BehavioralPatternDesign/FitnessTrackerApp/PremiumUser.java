// Premium user of the fitness app with extra benefits
class PremiumUser extends User {
    public PremiumUser(String name) {
        super(name);
    }

    // Premium users receive updates with a special tag
    @Override
    public void update(String message) {
        System.out.println(getName() + " (Premium User) got this update: " + message + " [Extra perks for you!]");
    }
}
