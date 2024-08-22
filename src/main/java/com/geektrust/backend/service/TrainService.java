package com.geektrust.backend.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import com.geektrust.backend.model.Bogie;
import com.geektrust.backend.model.Train;

public class TrainService {
    
    public List<Bogie> mergeAndSortTrains(List<Bogie> trainA, List<Bogie> trainB) {
        List<Bogie> mergedList = new ArrayList<>(trainA);
        mergedList.addAll(trainB);
    
        // Remove duplicates while maintaining the order of the first occurrence
        mergedList = new ArrayList<>(new LinkedHashSet<>(mergedList));

        mergedList.sort(Comparator
            .comparingInt(Bogie::getDistance).reversed()
            .thenComparing(Comparator.comparing(Bogie::getDestination)));
        return mergedList;
    }

    public void processArrivalAndDeparture(Train trainA, Train trainB) {
        List<Bogie> arrivingBogiesA = filterBogiesToHyderabad(trainA);
        List<Bogie> arrivingBogiesB = filterBogiesToHyderabad(trainB);

        List<Bogie> mergedBogies = mergeAndSortTrains(arrivingBogiesA, arrivingBogiesB);

        printArrivalAndDeparture(trainA, arrivingBogiesA, trainB, arrivingBogiesB, mergedBogies);
    }

    private List<Bogie> filterBogiesToHyderabad(Train train) {
        List<Bogie> bogies = new ArrayList<>();
        for (Bogie bogie : train.getBogies()) {
            if (bogie.getDistance() > 1200&& !bogie.getDestination().equals("PNE")) { // Hyderabad distance from starting point
                bogies.add(bogie);
            }
        }
        return bogies;
    }

    private void printArrivalAndDeparture(Train trainA, List<Bogie> arrivingBogiesA, Train trainB, List<Bogie> arrivingBogiesB, List<Bogie> mergedBogies) {
        System.out.println("ARRIVAL TRAIN_A ENGINE " + formatBogies(arrivingBogiesA));
        System.out.println("ARRIVAL TRAIN_B ENGINE " + formatBogies(arrivingBogiesB));
        System.out.println("DEPARTURE TRAIN_AB ENGINE ENGINE " + formatBogies(mergedBogies));
    }

    private String formatBogies(List<Bogie> bogies) {
        StringBuilder sb = new StringBuilder();
        for (Bogie bogie : bogies) {
            sb.append(bogie.getDestination()).append(" ");
        }
        return sb.toString().trim();
    }
}
