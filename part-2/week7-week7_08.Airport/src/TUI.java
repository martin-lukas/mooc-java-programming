import java.util.ArrayList;
import java.util.Scanner;

public class TUI {
    private ArrayList<Airplane> airplanes;
    private ArrayList<Flight> flights;
    private Scanner scan;
    
    public TUI(Scanner scan) {
        this.scan = scan;
        airplanes = new ArrayList<Airplane>();
        flights = new ArrayList<Flight>();
    }
    
    public void start() {
        startAirportPanelInterface();
        startFlightServiceInterface();
    }
    
    private void startAirportPanelInterface() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
    
        while (true) {
            System.out.println("Choose operation:");
            printAirportOperations();
            System.out.print("> ");
            String operation = scan.nextLine();
            if (operation.equals("x")) {
                break;
            } else if (operation.equals("1")) {
                addAirplane();
            } else if (operation.equals("2")) {
                addFlight();
            } else {
                System.out.println("Please try again.");
            }
            System.out.println();
        }
    }
    
    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String id = scan.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(scan.nextLine());
        if (!containsAirplane(id)) {
            airplanes.add(new Airplane(id, capacity));
        } else {
            System.out.println("Airplane with this ID already exists.");
        }
    }
    
    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = scan.nextLine();
        System.out.print("Give departure airport code: ");
        String departure = scan.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = scan.nextLine();
        if (containsAirplane(id)) {
            Flight flight = new Flight(getAirplaneByID(id), departure, destination);
            flights.add(flight);
        } else {
            System.out.println("Airplane with this ID doesn't exist.");
        }
        
    }
    
    private void startFlightServiceInterface() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println();
    
        while (true) {
            System.out.println("Choose operation:");
            printFlightOperations();
            System.out.print("> ");
            String operation = scan.nextLine();
            if (operation.equals("x")) {
                break;
            } else if (operation.equals("1")) {
                printAirplanes();
            } else if (operation.equals("2")) {
                printFlights();
            } else if (operation.equals("3")) {
                printAirplane();
            } else {
                System.out.println("Please try again.");
            }
            System.out.println();
        }
    }
    
    private void printAirplanes() {
        for (Airplane a : airplanes) {
            System.out.println(a);
        }
    }
    
    private void printFlights() {
        for (Flight f : flights) {
            System.out.println(f);
        }
    }
    
    private void printAirplane() {
        System.out.print("Give plane ID: ");
        String id = scan.nextLine();
        if (containsAirplane(id)) {
            System.out.println(getAirplaneByID(id));
        } else {
            System.out.println("Airplane with this ID doesn't exist.");
        }
    }
    
    private void printAirportOperations() {
        System.out.println("[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit");
    }
    
    private void printFlightOperations() {
        System.out.println("[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit");
    }
    
    private Airplane getAirplaneByID(String id) {
        for (Airplane a : airplanes) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    
    private boolean containsAirplane(String id) {
        for (Airplane airplane : airplanes) {
            if (airplane.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean containsFlight(Flight flight) {
        for (Flight f : flights) {
            if (f.equals(flight)) {
                return true;
            }
        }
        return false;
    }
}
