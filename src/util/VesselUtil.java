package util;

import java.util.ArrayList;
import java.util.List;
import model.Vessel;

public class VesselUtil {

    // List to store Vessel objects (UC2)
    private List<Vessel> vesselList = new ArrayList<>();

    // UC2: Add vessel performance details
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Getter for vessel list (used in later UCs)
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // UC3: Retrieve vessel by vesselId
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }

    // UC4: Identify high-performance vessels
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> highPerformanceVessels = new ArrayList<>();
        double maxSpeed = 0.0;

        // Step 1: Find maximum average speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Step 2: Collect all vessels with maximum speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                highPerformanceVessels.add(vessel);
            }
        }

        return highPerformanceVessels;
    }
}