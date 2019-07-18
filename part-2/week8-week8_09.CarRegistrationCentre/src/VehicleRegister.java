import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.containsKey(plate)) {
            if (owners.get(plate).isEmpty()) {
                owners.put(plate, owner);
                return true;
            } else {
                return false;
            }
        } else {
            owners.put(plate, owner);
            return true;
        }
    }
    
    public String get(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            return owners.get(plate);
        }
        return null;
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        }
        return false;
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownerList = new ArrayList<String>();
        for (String owner : owners.values()) {
            if (!ownerList.contains(owner)) {
                ownerList.add(owner);
            }
        }
        for (String uniqueOwner : ownerList) {
            System.out.println(uniqueOwner);
        }
    }
}
