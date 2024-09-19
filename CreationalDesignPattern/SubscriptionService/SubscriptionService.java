import java.util.HashMap;
import java.util.Map;

public class SubscriptionService {
    // Static instance for Singleton pattern
    private static SubscriptionService instance;

    // Available subscription plans
    private String[] plans = {"Basic", "Premium", "VIP"};

    // Map to store user subscriptions
    private Map<String, String> userSubscriptions = new HashMap<>();

    // Creating a Private constructor to prevent multiple instances
    private SubscriptionService() {
    }

    public static synchronized SubscriptionService getInstance() {
        if (instance == null) {
            instance = new SubscriptionService();
        }
        return instance;
    }

    // Get the list of available plans
    public String[] getPlans() {
        return plans;
    }

    // Subscribe a user to a chosen plan
    public void subscribeUser(String userName, String plan) {
        if (isValidPlan(plan)) {
            userSubscriptions.put(userName, plan);
            System.out.println(userName + " has successfully subscribed to the " + plan + " plan.");
        } else {
            System.out.println("Oops! That's an invalid plan. Please choose from our available plans.");
        }
    }

    // Change a user's current plan to a new plan
    public void changePlan(String userName, String newPlan) {
        if (userSubscriptions.containsKey(userName)) {
            if (isValidPlan(newPlan)) {
                userSubscriptions.put(userName, newPlan);
                System.out.println(userName + " has switched to the " + newPlan + " plan.");
            } else {
                System.out.println("Invalid plan. Please choose a valid subscription plan.");
            }
        } else {
            System.out.println("It seems like " + userName + " isn't subscribed yet. Please subscribe first.");
        }
    }

    // Check if a plan is valid
    private boolean isValidPlan(String plan) {
        for (String availablePlan : plans) {
            if (availablePlan.equalsIgnoreCase(plan)) {
                return true;
            }
        }
        return false;
    }

    // View the current plan of a user
    public void viewSubscription(String userName) {
        if (userSubscriptions.containsKey(userName)) {
            System.out.println(userName + " is currently on the " + userSubscriptions.get(userName) + " plan.");
        } else {
            System.out.println(userName + " is not subscribed to any plan.");
        }
    }

    public static void main(String[] args) {

        SubscriptionService service = SubscriptionService.getInstance();
        // Display available plans
        System.out.println("Here are the available subscription plans:");
        for (String plan : service.getPlans()) {
            System.out.println(plan);
        }

        // Subscribe users to different plans
        service.subscribeUser("Lisha", "Premium");
        service.subscribeUser("Pluto", "VIP");

        // View current subscriptions
        service.viewSubscription("Lisha");
        service.viewSubscription("Pluto");

        service.subscribeUser("Ady", "Gold"); // Invalid plan

        // Change an existing user's plan
        service.changePlan("Pluto", "Basic");
        service.viewSubscription("Pluto");

        // changing plan for non-subscribed user
        service.changePlan("Riya", "Basic");
    }
}
