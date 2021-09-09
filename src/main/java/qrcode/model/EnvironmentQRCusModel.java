/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class EnvironmentQRCusModel {
    private String environment;
    private String secretKey;

    public EnvironmentQRCusModel(String environment, String secretKey) {
        this.environment = environment;
        this.secretKey = secretKey;
    }

    public EnvironmentQRCusModel() {
    }

    public String getEnvironment() {
        return environment;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return environment;
    }


}
