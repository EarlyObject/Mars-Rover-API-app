package com.earlyobject.service;

import com.earlyobject.dto.HomeDto;
import com.earlyobject.response.MarsPhoto;
import com.earlyobject.response.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarsRoverApiService {

    private static final String API_KEY = "DEMO_KEY";

    public MarsRoverApiResponse getRoverData(HomeDto homeDto) {

        RestTemplate rt = new RestTemplate();
        List<String> apiUrlEndpoints = getApiUrlEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiUrlEndpoints.stream()
                .forEach(url -> {
                    MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
                    photos.addAll(apiResponse.getPhotos());
                });
        response.setPhotos(photos);
        return response;
    }

    private List<String> getApiUrlEndpoints(HomeDto homeDto) {
        List<String> urls = new ArrayList<>();
        if (Boolean.TRUE.equals(homeDto.getCameraFHAZ())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=FHAZ");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraRHAZ())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=RHAZ");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMAST()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MAST");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraCHEMCAM()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=CHEMCAM");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMAHLI()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MAHLI");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMARDI()) && "curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MARDI");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraNAVCAM())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=NAVCAM");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraPANCAM()) && !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=PANCAM");
        }
        if (Boolean.TRUE.equals(homeDto.getCameraMINITES()) && !"curiosity".equalsIgnoreCase(homeDto.getMarsApiRoverData())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/"+homeDto.getMarsApiRoverData()+ "/photos?sol="+ homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=MINITES");
        }
        return urls;
    }
}
