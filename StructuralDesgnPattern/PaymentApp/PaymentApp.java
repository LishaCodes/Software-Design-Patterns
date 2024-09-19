// Payment system interface with a method to process payments
interface PaymentSystem {
    void makePayment(double amount) throws Exception;
}

class SimplePayment implements PaymentSystem {
    @Override
    public void makePayment(double amount) throws Exception {
        // Check if the amount is valid
        if (amount <= 0) {
            throw new Exception("Invalid amount. It must be more than zero.");
        }
        System.out.println("Processing payment of $" + amount);

        // Simulate a random failure
        if (Math.random() < 0.2) {
            throw new Exception("Payment error. Please try again.");
        }
        System.out.println("Payment of $" + amount + " was successful.");
    }
}

// Trying to add limits and try the logic
class PaymentProxy implements PaymentSystem {
    private PaymentSystem realPayment = new SimplePayment();
    private static final double MAX_LIMIT = 5000;

    @Override
    public void makePayment(double amount) {
        try {
            // Checking if the payment exceeds the max limit
            if (amount > MAX_LIMIT) {
                System.out.println("Payment failed: Amount is above the limit of $" + MAX_LIMIT);
                return;
            }

            System.out.println("Proxy: Authorizing payment of $" + amount);

            // Retry logic in case of failure 
            int attempts = 3;
            boolean success = false;
            while (attempts > 0 && !success) {
                try {
                    realPayment.makePayment(amount); 
                    success = true; 
                } catch (Exception e) {
                    attempts--;
                    System.out.println("Error: " + e.getMessage());

                    if (attempts > 0) {
                        System.out.println("Retrying... (" + attempts + " tries left)");
                    } else {
                        System.out.println("Payment failed after several tries.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Proxy error: " + e.getMessage());
        }
    }
}

public class PaymentApp {
    public static void main(String[] args) {
        PaymentSystem proxy = new PaymentProxy();

        try {
            // Test cases
            proxy.makePayment(100);  
            proxy.makePayment(6000);  
            proxy.makePayment(-50);  
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
