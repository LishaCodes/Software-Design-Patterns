// Main class to run the fitness tracker app
public class FitnessTrackerApp {
    public static void main(String[] args) {
        FitnessApp app = new FitnessApp(); // Create app instance

        // Create users
        User lisha = new RegularUser("Lisha");
        User adarsh = new PremiumUser("Adarsh");

        // Add users to the app
        app.addNewUser(lisha);
        app.addNewUser(adarsh);

        // Set goals and milestones, and notify users
        app.setFitnessGoal("Run 10 km every week");
        app.setMilestone("Hit the gym every day");

        app.setFitnessGoal("Run 15 km by the end of next month");
    }
}
