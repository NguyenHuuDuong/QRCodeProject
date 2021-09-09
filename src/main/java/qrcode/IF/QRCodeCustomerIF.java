/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.IF;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author huuduong
 */
public interface QRCodeCustomerIF {
    public void writeQRImage(String text, int width, int height, String filePath);

    public String encodeString(String decodeString);

    public String convertStringToHex(String encodeString);

    public String readQRCodeToString(String path, String charset, Map hashMap);

    public String readQRCode(File qrCodeFile);

    public String loadParamsDefault_CreateQRCus();

    public String convertJsontoString_CreateQRCus(String jsonString);

    public String encodeStringToHMACSHA256(String encodeString, String secretKey);

    public String loadParamsOfficial_CreateQRCus(String checksum);

    public String convertHexToChar(String hexString);

    public int convertHexToDecimal(String hexString);

    public ArrayList loadDataTable(String qrCusString);
}
