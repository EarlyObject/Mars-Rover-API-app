package com.earlyobject.service;

import com.earlyobject.dto.HomeDto;
import com.earlyobject.repository.PreferencesRepository;
import com.earlyobject.response.MarsPhoto;
import com.earlyobject.response.MarsRoverApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MarsRoverApiService {

    @Autowired
    private PreferencesRepository preferencesRepo;

    private static final String API_KEY = "DEMO_KEY";

    private Map<String, List<String>> validCameras = new HashMap<>();

    public MarsRoverApiService() {
        validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
        validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
    }

    public MarsRoverApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {

        RestTemplate rt = new RestTemplate();
        List<String> apiUrlEndpoints = getApiUrlEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiUrlEndpoints
                .forEach(url -> {
                    MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
                    assert apiResponse != null;
                    photos.addAll(apiResponse.getPhotos());
                });
        response.setPhotos(photos);
        return response;
    }

    private List<String> getApiUrlEndpoints(HomeDto homeDto) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        List<String> urls = new ArrayList<>();

        Method[] methods = homeDto.getClass().getMethods();

        //This code will grab all getCamera* methods and (if value returns true) then we will build
        // an API URL to call in order to fetch pictures for a given rover / camera / sol.

        for (Method method : methods)
            if (method.getName().contains("getCamera") && Boolean.TRUE.equals(method.invoke(homeDto))) {
                String cameraName = method.getName().split("getCamera")[1].toUpperCase();
                if (validCameras.get(homeDto.getMarsApiRoverData()).contains(cameraName)) {
                    urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+
                            "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=" + cameraName);
                }
       }
        return urls;
    }

    public Map<String, List<String>> getValidCameras() {
        return validCameras;
    }

    public HomeDto save(HomeDto homeDto) {
        preferencesRepo.save(homeDto);
        return homeDto;
    }

    public HomeDto findByUserId(Long userId) {
        return (preferencesRepo.findByUserId(userId));
    }
}
