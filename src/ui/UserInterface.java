package ui;

import java.util.List;
import java.util.Scanner;

import model.Vessel;
import util.VesselUtil;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        // Step 1: Read number of vessels
        System.out.println("Enter the number of vessels to be added");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Step 2: Read vessel details
        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(":");

            Vessel vessel = new Vessel(
                    data[0],                       // vesselId
                    data[1],                       // vesselName
                    Double.parseDouble(data[2]),   // averageSpeed
                    data[3]                        // vesselType
            );

            vesselUtil.addVesselPerformance(vessel);
        }

        // Step 3: Search vessel by ID
        System.out.println("Enter the Vessel Id to check speed");
        String searchId = scanner.nextLine();

        Vessel foundVessel = vesselUtil.getVesselById(searchId);

        if (foundVessel != null) {
            System.out.println(
                    foundVessel.getVesselId() + " | " +
                            foundVessel.getVesselName() + " | " +
                            foundVessel.getVesselType() + " | " +
                            foundVessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        // Step 4: Display high-performance vessels
        System.out.println("High performance vessels are");
        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();

        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                            vessel.getVesselName() + " | " +
                            vessel.getVesselType() + " | " +
                            vessel.getAverageSpeed() + " knots"
            );
        }

        scanner.close();
    }
}