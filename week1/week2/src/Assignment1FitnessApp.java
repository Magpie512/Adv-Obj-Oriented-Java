/*You are building a Fitness Tracker that tracks different workout types:
Running
Cycling
Swimming

Each workout:
must be validated
can calculate calories burned
shares some common behavior
 */
interface Workout {

    void performWorkout();

    String getWorkoutType();
}

// ===== ABSTRACT CLASS =====
abstract class AbstractWorkout implements Workout {

    protected String userName;
    protected int duration; // in minutes

    public AbstractWorkout(String userName, int duration) {
        this.userName = userName;
        this.duration = duration;
    }

    // TODO 1:
    // Create a concrete method logWorkout()
    void logWorkout() {
        System.out.println(userName + " completed a workout of " + duration + " minutes");
    }
    // Print: "<userName> completed a workout of <duration> minutes"
    // TODO 2:
    // Create an abstract method calculateCalories() that returns a double
    abstract double calculateCalories();
}

// ===== CONCRETE CLASS 1 =====
class RunningWorkout extends AbstractWorkout {

    private double distance; // in km

    public RunningWorkout(String userName, int duration, double distance) {
        super(userName, duration);
        this.distance = distance;
    }

    // TODO 3:
    // Implement calculateCalories()
    // Hint: calories = distance * 60
    @Override
    double calculateCalories() {
        return distance * 60;
    }

    // TODO 4:
    // Implement performWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Running session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
        System.out.println("-".repeat(20)); //simpler eay to repeat woudld be 
        System.out.println();
    }

    // TODO 5:
    // Implement getWorkoutType() → return "Running"
    @Override
    public String getWorkoutType() {
        return "Running";
    }
}

// ===== CONCRETE CLASS 2 =====
class CyclingWorkout extends AbstractWorkout {

    final private double speed; // km/h

    public CyclingWorkout(String userName, int duration, double speed) {
        super(userName, duration);
        this.speed = speed;
    }

    // TODO 6:
    // Implement calculateCalories()
    // Hint: calories = speed * duration * 2
    @Override
    double calculateCalories() {
        return speed * duration * 2;
    }

    // TODO 7:
    // Implement performWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Cycling session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
        System.out.println("-".repeat(20));
        System.out.println();
    }

    // TODO 8:
    // Implement getWorkoutType() → return "Cycling"
    @Override
    public String getWorkoutType() {
        return "Cycling";
    }
}

// ===== CONCRETE CLASS 3 =====
class SwimmingWorkout extends AbstractWorkout {

    private int laps;

    public SwimmingWorkout(String userName, int duration, int laps) {
        super(userName, duration);
        this.laps = laps;
    }

    // TODO 9:
    // Implement calculateCalories()
    // Hint: calories = laps * 10
    @Override
    double calculateCalories() {
        return laps * 10;
    }

    // TODO 10:
    // Implement performWorkout()
    @Override
    public void performWorkout() {
        System.out.println("Swimming session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
        System.out.println("-".repeat(20));
        System.out.println();
    }

    // TODO 11:
    // Implement getWorkoutType() → return "Swimming"
    @Override
    public String getWorkoutType() {
        return "Swimming";
    }
}

// ===== UTILITY CLASS (OVERLOADING) =====
class FitnessUtils {

    // TODO 12:
    // Method logSummary(int totalMinutes)
    // Print: "Total workout time: X minutes"
    void logSummary(int totalMinutes) {
        System.out.println("Total workout time: " + totalMinutes + " minutes");
    }

    // TODO 13:
    // Overloaded method logSummary(int totalMinutes, String level)
    // Print: "Total workout time: X minutes - Level: <level>"
    void logSummary(int totalMinutes, String level) {
        System.out.println("Total workout time: " + totalMinutes + " minutes - Level: " + level);
    }
}

// ===== MAIN DRIVER =====
public class Assignment1FitnessApp {

    public static void main(String[] args) {

        // TODO 14:
        // Create objects for Running, Cycling, Swimming
        Workout w1 = new RunningWorkout("Alice", 30, 5);
        Workout w2 = new CyclingWorkout("Bob", 45, 20);
        Workout w3 = new SwimmingWorkout("Charlie", 25, 30);

        // TODO 15:
        // Store them in a Workout array
        Workout[] workouts = { w1, w2, w3 };

        // TODO 16:
        // Loop through workouts:
        // 1. Print workout type
        // 2. Call performWorkout()
        for (Workout w : workouts) {
            System.out.println("Workout Type: " + w.getWorkoutType());
            w.performWorkout();
        }

        // TODO 17:
        // Create FitnessUtils object
        // Call both versions of logSummary()
        FitnessUtils utils = new FitnessUtils();
        utils.logSummary(100);
        utils.logSummary(100, "Intermediate");
    }
}