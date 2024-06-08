package com.capMap.capMap.Controller;
// CsvController.java

// CsvController.java

import com.capMap.capMap.domain.Marker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CsvController {

    @GetMapping("/map")
    public String showMap() {
        return "index";
    }
    @GetMapping("/markers")
    public List<Marker> getMarkers() {
        List<Marker> markers = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/crosswalk_coordinates.csv"))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                try {
                    double x = Double.parseDouble(line[0]);
                    double y = Double.parseDouble(line[1]);
                    markers.add(new Marker(x, y));
                } catch (NumberFormatException e) {
                    // Handle exception caused by invalid number format
                    e.printStackTrace();
                }
            }
        } catch (IOException | CsvValidationException e) {
            // Handle IOException and CsvValidationException
            e.printStackTrace();
        }

        return markers;
    }

}
