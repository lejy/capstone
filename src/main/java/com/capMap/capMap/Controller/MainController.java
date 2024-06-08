package com.capMap.capMap.Controller;

import com.capMap.capMap.domain.Location;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class MainController {

    private Location loc;
    private String result;

    @GetMapping("/sendlocation") // 플러터에서 받을 정보
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






}
