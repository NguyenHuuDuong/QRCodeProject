/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class EnvironmentQRCodeModel {
    private String environment;
    private String secretKey;

    public EnvironmentQRCodeModel(String environment, String secretKey) {
        this.environment = environment;
        this.secretKey = secretKey;
    }

    public EnvironmentQRCodeModel() {
    }

    @Override
    public String toString() {
        return environment;
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


}
