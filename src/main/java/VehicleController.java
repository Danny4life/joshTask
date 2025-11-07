import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class VehicleController {

    private static final Set<Integer> ALLOWED_TANK_COUNTS = new HashSet<>();

    static {
        ALLOWED_TANK_COUNTS.add(2);
        ALLOWED_TANK_COUNTS.add(4);
        ALLOWED_TANK_COUNTS.add(8);
        ALLOWED_TANK_COUNTS.add(10);
        ALLOWED_TANK_COUNTS.add(15);

    }

    public static void main(String[] args) {

       
        String firstName = promptForFirstName();
        String lastName = promptForLastName();
        String phone = promptForPhone();
        int numberOfVehicles = promptForNumberOfVehicles();
        int numberOfTanks = promptForNumberOfTanks();


        VehicleOrder order = new VehicleOrder(firstName, lastName, phone, numberOfVehicles, numberOfTanks);

        JOptionPane.showMessageDialog(null, order.getOrderSummary(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    private static String promptForFirstName() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Enter Customer First Name:", "First Name", JOptionPane.QUESTION_MESSAGE);

            if(input == null) exitCancelled();
            input = input.trim();

            if(!input.isEmpty()) return input;

            JOptionPane.showMessageDialog(null, "First name cannot be blank... Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }



    private static String promptForLastName() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Enter Customer Last Name:", "Last Name", JOptionPane.QUESTION_MESSAGE);

            if(input == null) exitCancelled();
            input = input.trim();

            if(!input.isEmpty()) return input;

            JOptionPane.showMessageDialog(null, "Last name cannot be blank... Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String promptForPhone() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Enter Customer Phone Number (10 digits, e.g 9091290121):", "Phone", JOptionPane.QUESTION_MESSAGE);

            if(input == null) exitCancelled();
            input = input.trim();

            if(input.length() == 10 && input.matches("\\d{10}")){
                return input;
            }

            JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits... Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static int promptForNumberOfVehicles() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Enter number of vehicles to be manufactured (1 - 10):", "Number of Vehicles", JOptionPane.QUESTION_MESSAGE);

            if(input == null) exitCancelled();
            input = input.trim();

            try{
                int n = Integer.parseInt(input);
                if(n >= 1 && n <= 10) return  n;
                JOptionPane.showMessageDialog(null, "Number of Vehicles must be between 1 and 10... Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "... Please enter a valid integer for number of vehicles.", "Invalid Input", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    private static int promptForNumberOfTanks() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Enter number of fuel tanks per vehicle (allowed: 2,4,8,10,15):", "Number of Tanks", JOptionPane.QUESTION_MESSAGE);

            if(input == null) exitCancelled();
            input = input.trim();

            try{
                int t = Integer.parseInt(input);
                if(ALLOWED_TANK_COUNTS.contains(t)) return  t;
                JOptionPane.showMessageDialog(null, "Number of tanks must be one of 2,4,8,10,15... Please re-enter.", "Invalid Input", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "... Please enter a valid integer for number of tanks.", "Invalid Input", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    private static void exitCancelled() {
        JOptionPane.showMessageDialog(null, "Input cancelled. Program exit.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }


}
