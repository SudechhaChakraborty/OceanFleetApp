package util;

import java.util.ArrayList;
import java.util.List;
import model.Vessel;

public class VesselUtil {

    // List to store Vessel objects
    private List<Vessel> vesselList = new ArrayList<>();

    // UC2 requirement: add vessel to list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Getter (useful for later UCs)
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // UC3 requirement: retrieve vessel by ID
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }
}