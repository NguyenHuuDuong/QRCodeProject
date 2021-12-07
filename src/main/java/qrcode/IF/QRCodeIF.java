/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.IF;

import java.io.File;
import java.util.ArrayList;

/**
 * @author huuduong
 */
public interface QRCodeIF {
    public void writeQRImage(String text, int width, int height, String filePath);

    public String readQRCode(File qrCodeFile);

    public String loadParamsDefault_CreateQR();

    public String loadParamsDefault_Checktrans();

    public String loadParamsDefault_RefundQR();

    public String loadParamsDefault_CheckRefundQR();

    public String loadParamsOfficial_CreateQR(String checksum);

    public String loadParamsOfficial_Checktrans(String checksum);

    public String loadParamsOfficial_RefundQR(String checksum);

    public String loadParamsOfficial_CheckRefundQR(String checksum);

    public String convertJsontoString_CreateQR(String jsonString, String secretKey);

    public String convertJsontoString_Checktrans(String jsonString, String secretKey);

    public String convertJsontoString_RefundQR(String jsonString, String secretKey);

    public String convertJsontoString_CheckRefundQR(String jsonString, String secretKey);

    public String encodeMD5(String encodeString);

    public ArrayList addRowTable(String qrString);

    public String loadParamsDefault_IPNQRCode();

    public String convertJsontoString_IPNQRCode(String jsonString, String secretKey);

    public String loadParamsOfficial_IPNQRCode(String checksum);

}
