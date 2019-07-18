public class Flight {
    private Airplane airplane;
    private String departure;
    private String destination;
    
    public Flight(Airplane airplane, String departure, String destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }
    
    public Airplane getAirplane() {
        return airplane;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String toString() {
        return airplane.getId() + " (" + airplane.getCapacity() + " ppl) (" +
                departure + "-" + destination + ")";
    }
    
    public boolean equals(Flight flight) {
        if (this.airplane.getId().equals(flight.airplane.getId()) &&
                this.departure.equals(flight.departure) &&
                this.destination.equals(flight.destination)) {
            return true;
        }
        return false;
    }
}
