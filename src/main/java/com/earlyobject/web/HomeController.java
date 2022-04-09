package com.earlyobject.web;

import com.earlyobject.dto.HomeDto;
import com.earlyobject.response.MarsRoverApiResponse;
import com.earlyobject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView (ModelMap model, HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("Curiosity");
        }
        if (homeDto.getMarsSol() == null)
            homeDto.setMarsSol(1);
        MarsRoverApiResponse roverData = roverService.getRoverData(homeDto);
        model.put("roverData", roverData);
        model.put("homeDto", homeDto);

        return "index";
    }

}