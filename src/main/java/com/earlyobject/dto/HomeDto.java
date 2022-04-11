package com.earlyobject.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class HomeDto {

    private String marsApiRoverData;
    private Integer marsSol;
    private Boolean cameraFHAZ;
    private Boolean cameraRHAZ;
    private Boolean cameraMAST;
    private Boolean cameraCHEMCAM;
    private Boolean cameraMAHLI;
    private Boolean cameraMARDI;
    private Boolean cameraNAVCAM;
    private Boolean cameraPANCAM;
    private Boolean cameraMINITES;
    private Boolean rememberPreferences;

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

    public Boolean getCameraFHAZ() {
        return cameraFHAZ;
    }

    public void setCameraFHAZ(Boolean cameraFHAZ) {
        this.cameraFHAZ = cameraFHAZ;
    }

    public Boolean getCameraRHAZ() {
        return cameraRHAZ;
    }

    public void setCameraRHAZ(Boolean cameraRHAZ) {
        this.cameraRHAZ = cameraRHAZ;
    }

    public Boolean getCameraMAST() {
        return cameraMAST;
    }

    public void setCameraMAST(Boolean cameraMAST) {
        this.cameraMAST = cameraMAST;
    }

    public Boolean getCameraCHEMCAM() {
        return cameraCHEMCAM;
    }

    public void setCameraCHEMCAM(Boolean cameraCHEMCAM) {
        this.cameraCHEMCAM = cameraCHEMCAM;
    }

    public Boolean getCameraMAHLI() {
        return cameraMAHLI;
    }

    public void setCameraMAHLI(Boolean cameraMAHLI) {
        this.cameraMAHLI = cameraMAHLI;
    }

    public Boolean getCameraMARDI() {
        return cameraMARDI;
    }

    public void setCameraMARDI(Boolean cameraMARDI) {
        this.cameraMARDI = cameraMARDI;
    }

    public Boolean getCameraNAVCAM() {
        return cameraNAVCAM;
    }

    public void setCameraNAVCAM(Boolean cameraNAVCAM) {
        this.cameraNAVCAM = cameraNAVCAM;
    }

    public Boolean getCameraPANCAM() {
        return cameraPANCAM;
    }

    public void setCameraPANCAM(Boolean cameraPANCAM) {
        this.cameraPANCAM = cameraPANCAM;
    }

    public Boolean getCameraMINITES() {
        return cameraMINITES;
    }

    public void setCameraMINITES(Boolean cameraMINITES) {
        this.cameraMINITES = cameraMINITES;
    }

    public Boolean getRememberPreferences() {
        return rememberPreferences;
    }

    public void setRememberPreferences(Boolean rememberPreferences) {
        this.rememberPreferences = rememberPreferences;
    }
}
