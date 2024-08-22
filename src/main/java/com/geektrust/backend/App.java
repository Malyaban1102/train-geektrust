package com.geektrust.backend;

import java.util.List;
import com.geektrust.backend.model.Train;
import com.geektrust.backend.service.TrainService;
import com.geektrust.backend.util.FileUtil;


public class App {

	public static void main(String[] args) {
		//System.out.println("Welcome to Geektrust Backend Challenge!");
		if (args.length < 1) {
            System.out.println("Please provide the input file path as an argument.");
            return;
        }
        String filePath = args[0];
        List<Train> trains = FileUtil.readTrainsFromFile(filePath);

        if (trains.size() < 2) {
            System.out.println("Invalid input. Please ensure the input file contains data for both Train A and Train B.");
            return;
        }

        Train trainA = trains.get(0);
        Train trainB = trains.get(1);

        TrainService service = new TrainService();
        service.processArrivalAndDeparture(trainA, trainB);
	}

}
