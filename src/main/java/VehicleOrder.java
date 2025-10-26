import java.text.NumberFormat;
import java.util.Locale;

public class VehicleOrder {

    private String firstName;

    private String lastName;

    private String phone;

    private int numberOfVehicles;

    private int numberOfTanksPerVehicle;

    // Constant values for vehicle calculation
    public static final double MANUFACTURING_PRICE_PER_VEHICLE = 500.19;
    public static final double PRICE_PER_FUEL_CELL = 2.15;

    //Snake casing, camel casing
    public static final double FUEL_CELLS_PER_TANK = 12;

    public VehicleOrder(String firstName, String lastName, String phone,
                        int numberOfVehicles, int numberOfTanksPerVehicle){

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfTanksPerVehicle = numberOfTanksPerVehicle;

    }

    public double computeManufacturingCost(){
        return numberOfVehicles * MANUFACTURING_PRICE_PER_VEHICLE;
    }

    public double computeFuelTankCost(){
        return numberOfVehicles * numberOfTanksPerVehicle * FUEL_CELLS_PER_TANK * PRICE_PER_FUEL_CELL;
    }

    public double computeTotalCost(){
        return computeManufacturingCost() + computeFuelTankCost();
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhone(){
        return phone;
    }

    public int getNumberOfVehicles(){
        return numberOfVehicles;
    }

    public int getNumberOfTanksPerVehicle(){
        return numberOfTanksPerVehicle;
    }

    public String getOrderSummary(){
        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);

        StringBuilder sb = new StringBuilder();

        sb.append("Customer: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("Phone: ").append(phone).append("\n\n");
        sb.append("Number of vehicles: ").append(numberOfVehicles).append("\n");
        sb.append("Tanks per vehicle: ").append(numberOfTanksPerVehicle).append("\n");
        sb.append("Fuel cell per tank: ").append(FUEL_CELLS_PER_TANK).append("\n\n");
        sb.append("Manufacturing cost: ").append(cf.format(computeManufacturingCost())).append("\n");
        sb.append("Fuel tank cost: ").append(cf.format(computeFuelTankCost())).append("\n");
        sb.append("Total cost: ").append(cf.format(computeTotalCost())).append("\n");

        return sb.toString();
    }


}
