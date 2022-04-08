package com.earlyobject.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class HomeDto {
//    @RequestParam(required = false) String marsApiRoverData,
//    @RequestParam(required = false) Integer marsSol

    private String marsApiRoverData;
    private Integer marsSol;
    private Boolean defaultCheck1;

    public String getMarsApiRoverData() {
        return marsApiRoverData;
    }

    public void setMarsApiRoverData(String marsApiRoverData) {
        this.marsApiRoverData = marsApiRoverData;
    }

    public Integer getMarsSol() {
        return marsSol;
    }

    public void setMarsSol(Integer marsSol) {
        this.marsSol = marsSol;
    }

    public Boolean getDefaultCheck1() {
        return defaultCheck1;
    }

    public void setDefaultCheck1(Boolean defaultCheck1) {
        this.defaultCheck1 = defaultCheck1;
    }
}
