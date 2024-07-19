import java.util.HashMap;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = "";
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void updateProfile(String newProfile) {
        this.profile = newProfile;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getProfile() {
        return profile;
    }
}

public class OnlineExaminationSystem {
    private static HashMap<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating a default user for demonstration
        users.put("user", new User("user", "password"));

        while (true) {
            System.out.println("\nWelcome to Online Examination System!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Thank you for using Online Examination System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            userMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void userMenu(User user) {
        while (true) {
            System.out.println("\nWelcome, " + user.getUsername() + "!");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Take Examination");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    updateProfile(user);
                    break;
                case 2:
                    updatePassword(user);
                    break;
                case 3:
                    takeExamination();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void updateProfile(User user) {
        System.out.print("Enter new profile information: ");
        String newProfile = scanner.nextLine();
        user.updateProfile(newProfile);
        System.out.println("Profile updated successfully.");
    }

    private static void updatePassword(User user) {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        user.updatePassword(newPassword);
        System.out.println("Password updated successfully.");
    }

    private static void takeExamination() {
        String[] questions = {  //questions can set according to need and subject at hand
            "Question 1: What is 2 + 2?",
            "Question 2: What is the capital of France?",
            "Question 3: Who wrote 'To Kill a Mockingbird'?"
        };
        String[][] options = {
            {"1) 3", "2) 4", "3) 5"},
            {"1) Berlin", "2) Madrid", "3) Paris"},
            {"1) Harper Lee", "2) J.K. Rowling", "3) Mark Twain"}
        };
        int[] answers = {2, 3, 1};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == answers[i]) {
                score++;
            }
        }

        System.out.println("You scored " + score + " out of " + questions.length);
    }
}
