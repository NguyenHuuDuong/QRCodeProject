/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class DataCusStringModel {

    private String level1;
    private String level2;
    private String level3;
    private String length;
    private String value;

    public DataCusStringModel() {
    }

    public DataCusStringModel(String level1, String level2, String level3, String length, String value) {
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.length = length;
        this.value = value;
    }

    public String getLevel1() {
        return level1;
    }

    public String getLevel2() {
        return level2;
    }

    public String getLevel3() {
        return level3;
    }

    public String getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
