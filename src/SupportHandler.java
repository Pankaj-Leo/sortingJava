// Abstract class for handling support requests
public class SupportHandler {
public static abstract class SupportHandler2 {
    private SupportHandler2 nextHandler;

    public void setNextHandler(SupportHandler2 nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String issue, int severity) {
        if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        }
    }
}


    // Level 1 Support Handler
    static class Level1Support extends SupportHandler2 {
        @Override
        public void handleRequest(String issue, int severity) {
            if (severity <= 1) {
                System.out.println("Level 1 Support: Handling issue - " + issue);
            } else {
                super.handleRequest(issue, severity);
            }
        }
    }

    // Level 2 Support Handler
    static class Level2Support extends SupportHandler2 {
        @Override
        public void handleRequest(String issue, int severity) {
            if (severity == 2) {
                System.out.println("Level 2 Support: Handling issue - " + issue);
            } else {
                super.handleRequest(issue, severity);
            }
        }
    }

    // Manager Handler
    static class Manager extends SupportHandler2 {
        @Override
        public void handleRequest(String issue, int severity) {
            if (severity >= 3) {
                System.out.println("Manager: Handling issue - " + issue);
            } else {
                super.handleRequest(issue, severity);
            }
        }
    }

    // Main class to test the Chain of Responsibility
    public static void main(String[] args) {
        // Create handlers
        SupportHandler2 level1 = new Level1Support();
        SupportHandler2 level2 = new Level2Support();
        SupportHandler2 manager = new Manager();

        // Build the chain
        level1.setNextHandler(level2);
        level2.setNextHandler(manager);

        // Send requests
        System.out.println("Request 1 (Severity 1):");
        level1.handleRequest("Forgotten password", 1);

        System.out.println("\nRequest 2 (Severity 2):");
        level1.handleRequest("Unable to connect to server", 2);

        System.out.println("\nRequest 3 (Severity 3):");
        level1.handleRequest("System crash", 3);
    }
}