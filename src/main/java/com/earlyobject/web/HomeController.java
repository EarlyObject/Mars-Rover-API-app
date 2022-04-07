package com.earlyobject.web;

import com.earlyobject.response.MarsRoverApiResponse;
import com.earlyobject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView (ModelMap model, @RequestParam(required = false) String marsApiRoverData) {
        if (StringUtils.isEmpty(marsApiRoverData)) {
            marsApiRoverData = "curiosity";
        }
        MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);
        model.put("roverData", roverData);

        return "index";
    }

}