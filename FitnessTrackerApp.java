import java.util.ArrayList;
import java.util.Scanner;

// Activity class to represent a fitness activity
class Activity {
    private String activityName;
    private int duration; // in minutes
    private int caloriesBurned;

    public Activity(String activityName, int duration, int caloriesBurned) {
        this.activityName = activityName;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public String toString() {
        return activityName + ": " + duration + " mins, " + caloriesBurned + " calories burned.";
    }
}

// Diet class to represent dietary intake
class Diet {
    private String foodItem;
    private int caloriesConsumed;

    public Diet(String foodItem, int caloriesConsumed) {
        this.foodItem = foodItem;
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    @Override
    public String toString() {
        return foodItem + ": " + caloriesConsumed + " calories.";
    }
}

// User class to manage activity and diet logs
class User {
    private String name;
    private ArrayList<Activity> activityLog;
    private ArrayList<Diet> dietLog;

    public User(String name) {
        this.name = name;
        this.activityLog = new ArrayList<>();
        this.dietLog = new ArrayList<>();
    }

    public void logActivity(Activity activity) {
        activityLog.add(activity);
    }

    public void logDiet(Diet diet) {
        dietLog.add(diet);
    }

    public void displayActivities() {
        if (activityLog.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            System.out.println("Activity Log:");
            for (Activity activity : activityLog) {
                System.out.println(activity);
            }
        }
    }

    public void displayDiet() {
        if (dietLog.isEmpty()) {
            System.out.println("No diet entries logged.");
        } else {
            System.out.println("Diet Log:");
            for (Diet diet : dietLog) {
                System.out.println(diet);
            }
        }
    }

    public void displaySummary() {
        int totalCaloriesBurned = 0;
        for (Activity activity : activityLog) {
            totalCaloriesBurned += activity.getCaloriesBurned();
        }

        int totalCaloriesConsumed = 0;
        for (Diet diet : dietLog) {
            totalCaloriesConsumed += diet.getCaloriesConsumed();
        }

        System.out.println("Summary:");
        System.out.println("Total Calories Burned: " + totalCaloriesBurned);
        System.out.println("Total Calories Consumed: " + totalCaloriesConsumed);
        System.out.println("Net Calories: " + (totalCaloriesConsumed - totalCaloriesBurned));
    }
}

// Main application class
public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Fitness Tracker App!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        User user = new User(name);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Log Activity");
            System.out.println("2. Log Diet");
            System.out.println("3. View Activity Log");
            System.out.println("4. View Diet Log");
            System.out.println("5. View Summary");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter activity name (e.g., Running): ");
                    String activityName = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter calories burned: ");
                    int caloriesBurned = scanner.nextInt();
                    user.logActivity(new Activity(activityName, duration, caloriesBurned));
                    System.out.println("Activity logged successfully!");
                    break;

                case 2:
                    System.out.print("Enter food item name: ");
                    String foodItem = scanner.nextLine();
                    System.out.print("Enter calories consumed: ");
                    int caloriesConsumed = scanner.nextInt();
                    user.logDiet(new Diet(foodItem, caloriesConsumed));
                    System.out.println("Diet entry logged successfully!");
                    break;

                case 3:
                    user.displayActivities();
                    break;

                case 4:
                    user.displayDiet();
                    break;

                case 5:
                    user.displaySummary();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting the Fitness Tracker. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
