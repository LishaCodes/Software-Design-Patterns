import java.util.ArrayList;
import java.util.List;

// Main app to track goals and notify users
class FitnessApp {
    private List<Observer> users = new ArrayList<>(); 
    private String currentGoal; // The goal to be achieved

    // Add a new user to get updates
    public void addNewUser(Observer observer) {
        users.add(observer);
    }

    // Remove a user from updates
    public void removeUser(Observer observer) {
        users.remove(observer);
    }

    // Notify all users when something new happens
    public void notifyUsers(String message) {
        for (Observer user : users) {
            user.update(message);
        }
    }

    // Set and announce a new milestone
    public void setMilestone(String milestone) {
        this.currentGoal = milestone;
        notifyUsers("Great job! Milestone achieved: " + milestone);
    }

    // Set and announce a new fitness goal
    public void setFitnessGoal(String goal) {
        this.currentGoal = goal;
        notifyUsers("New challenge ahead: " + goal);
    }

    // Get the current fitness goal
    public String getCurrentGoal() {
        return currentGoal;
    }
}
