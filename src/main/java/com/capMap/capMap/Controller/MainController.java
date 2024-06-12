package com.capMap.capMap.Controller;

import com.capMap.capMap.Service.crossLocService;


import com.capMap.capMap.domain.cross;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    private final crossLocService crossLocService;

    public MainController(crossLocService crossLocService) {
        this.crossLocService = crossLocService;
    }
    private String result;

    @GetMapping("/sendlocationn") // 플러터에서 받을 정보
    public String getLocation(@RequestParam("x") String x, @RequestParam("y") String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        System.out.println(x+" , "+y);
        return "mapView";
    }

    @PostMapping("/getresult")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080") // CORS 허용
    public String getResult(@RequestBody String resultValue) {
        System.out.println("Received result: " + resultValue);
        result = resultValue;
        return result;
    }

    @GetMapping("/sendlocation")
    @ResponseBody
    public Integer getLocation(@RequestParam("x") double x, @RequestParam("y") double y) {
        double distance = 0.05;
        boolean isWithinDistance = crossLocService.isCoordinateWithinDistance(x, y, distance);
        System.out.println(isWithinDistance);
        return isWithinDistance ? 1 : 0;

    }


}







