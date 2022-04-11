package com.earlyobject.web;

import com.earlyobject.dto.HomeDto;
import com.earlyobject.response.MarsRoverApiResponse;
import com.earlyobject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView (ModelMap model, Long userId, Boolean createUser) throws InvocationTargetException,
            IllegalAccessException {

        HomeDto homeDto = getDefaultHomeDto(userId);
        if (Boolean.TRUE.equals(createUser) && userId == null) {
            homeDto = roverService.save(homeDto);
        } else {
            homeDto = roverService.findByUserId(userId);
            if (homeDto == null) {
                homeDto = getDefaultHomeDto(userId);
            }
        }

       /* if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("Curiosity");
        }
        if (homeDto.getMarsSol() == null)
            homeDto.setMarsSol(2);
        if (homeDto.getCameraFHAZ() == null
            && homeDto.getCameraRHAZ() == null
            && homeDto.getCameraRHAZ() == null
            && homeDto.getCameraMAST() == null
            && homeDto.getCameraCHEMCAM() == null
            && homeDto.getCameraMAHLI() == null
            && homeDto.getCameraMARDI() == null
            && homeDto.getCameraNAVCAM() == null)
                homeDto.setCameraNAVCAM(true);*/
        MarsRoverApiResponse roverData = roverService.getRoverData(homeDto);
        model.put("roverData", roverData);
        model.put("homeDto", homeDto);
        model.put("validCameras", roverService.getValidCameras().get(homeDto.getMarsApiRoverData()));
        if (!Boolean.TRUE.equals(homeDto.getRememberPreferences()) && userId != null) {
            HomeDto defaultHomeDto = getDefaultHomeDto(userId);
            roverService.save(defaultHomeDto);
        }
        return "index";
    }

    private HomeDto getDefaultHomeDto(Long userId) {
        HomeDto homeDto = new HomeDto();
        homeDto.setUserId(userId);
        homeDto.setMarsApiRoverData("Curiosity");
        homeDto.setMarsSol(2);
        homeDto.setCameraNAVCAM(true);
        return homeDto;
    }

    @PostMapping("/")
    public String postHomeView(HomeDto homeDto) {
        homeDto = roverService.save(homeDto);
        return "redirect:/?userId=" + homeDto.getUserId();
    }

}