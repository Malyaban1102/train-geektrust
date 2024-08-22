package com.geektrust.backend.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.model.Bogie;
import com.geektrust.backend.model.Train;

public class FileUtil {
    public static List<Train> readTrainsFromFile(String filePath) {
        List<Train> trains = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            trains.add(parseTrain(lines.get(0)));
            trains.add(parseTrain(lines.get(1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }

    private static Train parseTrain(String line) {
        String[] parts = line.split(" ");
        String name = parts[0];
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
            String destination = parts[i];
            int distance = getDistance(destination);
            bogies.add(new Bogie(destination, distance));
        }
        return new Train(name, bogies);
    }

    private static int getDistance(String destination) {
        switch (destination) {
            case "CHN": return 0;
            case "SLM": return 350;
            case "BLR": return 550;
            case "KRN": return 900;
            case "HYB": return 1200;
            case "NGP": return 1600;
            case "ITJ": return 1900;
            case "BPL": return 2000;
            case "AGA": return 2500;
            case "NDL": return 2700;
            case "TVC": return 0;
            case "SRR": return 300;
            case "MAQ": return 600;
            case "MAO": return 1000;
            case "PNE": return 1400;
            case "NJP": return 4200;
            case "GHY": return 4700;
            case "PTA": return 3800; 
            default: return 0;
        }
    }
}
