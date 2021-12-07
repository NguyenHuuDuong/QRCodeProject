/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.contoller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
//import com.vnpay.qr.tlv.HexUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.imageio.ImageIO;

import com.vnpay.qr.tlv.HexUtil;
import org.json.JSONException;
import org.json.JSONObject;
import qrcode.IF.QRCodeCustomerIF;
import qrcode.model.QRCodeCustomerModel;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import qrcode.model.DataCusStringModel;

/**
 * @author huuduong
 */
public class QRCodeCustomerController implements QRCodeCustomerIF {
    private static final String APPTOKEN_TEST = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWtvIiwiaWF0IjoxNjA3NDgyNzEzLCJleHAiOjE2NzA1OTY1NjR9.Pi9FZHHOD-a78ksABgjH_wDs8-ZYYGSgFBA6v3pPSfEyhiW8RmGZLJP1PHxvFa4B0iac3ETonHQNKS1WOOS74w";
    QRCodeCustomerModel qrCusModel = new QRCodeCustomerModel();

    @Override
    public void writeQRImage(String text, int width, int height, String filePath) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);  // write image into path.
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    @Override
    public String encodeString(String decodeString) {
        //String encodeString = Base64.getEncoder().encodeToString(decodeString.getBytes());
        return Base64.getEncoder().encodeToString(decodeString.getBytes());
    }

    @Override
    public String readQRCodeToString(String path, String charset, Map hashMap) {

        return "";
    }

    @Override
    public String readQRCode(File qrCodeFile) {

        try {

            BufferedImage bufferedImage = ImageIO.read(qrCodeFile);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                Result result = new MultiFormatReader().decode(bitmap);
                return result.getText();
            } catch (NotFoundException e) {
                //System.out.println("There is no QR code in the image");
                return null;
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
        return null;
    }

    @Override
    public String convertStringToHex(String encodeString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodeString);
        String decodedString = new String(decodedBytes);
        String origHex = HexUtil.toHexString(decodedBytes);
        return HexUtil.toHexString(decodedBytes);

    }

    @Override
    public String loadParamsDefault_CreateQRCus() {
        String jsonString = "{"
                + "\n" + " \"token\": \"a4cd987b-4dab-461e-af9f-85fabea0efbf\","
                + "\n" + " \"masterMC\": \"A000000775\","
                + "\n" + " \"merchantCode\": \"112345432\","
                + "\n" + " \"terminalId\": \"0001\","
                + "\n" + " \"mobile\": \"0826624960\","
                + "\n" + " \"payDate\": \"20210616192546\","
                + "\n" + " \"debitAmount\": \"10000\","
                + "\n" + " \"traceTransfer\": \"QUSNUYYUCYCD\","
                + "\n" + " \"qrInfo\": \"85054350563031614C4F0639373034313950084167726962616E6B63385716304431363036443132334431363233383437313439469F241D303832363632343936303030303030303030303030303030303030303062345F200D5452414E20544849204D494E485F2D0276699F080231305F501074656C3A2B38343832363632343936309F250430303030\","
                + "\n" + " \"userName\": \"DGL\","
                + "\n" + " \"messageType\": \"VERIFICATION\","
                + "\n" + " \"invoiceNo\": \"QUSNUYYUCYCD\","
                + "\n" + " \"voucherCode\": \"\","
                + "\n" + " \"mobileId\": \"\","
                + "\n" + " \"clientId\": \"\","
                + "\n" + " \"device\": \"\","
                + "\n" + " \"location\": \"\","
                + "\n" + " \"imei\": \"\""
                //+ " \"note\": \"Thanh toan DH order-abc-123\""
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String loadParamsOfficial_CreateQRCus(String checksum) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        /*String jsonString = "{"
                + "\n" +" \"checkSum\":\"" + checksum + "\""
                + "\n" +"}";
        return jsonString; */

        String jsonString = "{"
                + "\n" + " \"header\": { "
                + "\n" + "\"checksum\": \"" + checksum + "\","
                + "\n" + " \"appToken\": \"" + APPTOKEN_TEST + "\"},"
                + "\n" + " \"body\": { "
                + "\n" + "\"token\": \"" + qrCusModel.getToken() + "\","
                + "\n" + " \"masterMC\": \"" + qrCusModel.getMasterMC() + "\","
                + "\n" + " \"merchantCode\": \"" + qrCusModel.getMerchantCode() + "\","
                + "\n" + " \"terminalId\": \"" + qrCusModel.getTerminalId() + "\","
                + "\n" + " \"mobile\": \"" + qrCusModel.getMobile() + "\","
                + "\n" + " \"payDate\": \"" + qrCusModel.getPayDate() + "\","
                + "\n" + " \"debitAmount\": \"" + qrCusModel.getDebitAmount() + "\","
                + "\n" + " \"traceTransfer\": \"" + qrCusModel.getTraceTransfer() + "\","
                + "\n" + " \"qrInfo\": \"" + qrCusModel.getQrInfo() + "\","
                + "\n" + " \"userName\": \"" + qrCusModel.getUserName() + "\","
                + "\n" + " \"messageType\": \"" + qrCusModel.getMessageType() + "\","
                + "\n" + " \"invoiceNo\": \"" + qrCusModel.getInvoiceNo() + "\","
                + "\n" + " \"voucherCode\": \"" + qrCusModel.getVoucherCode() + "\","
                + "\n" + " \"mobileId\": \"" + qrCusModel.getMobileId() + "\","
                + "\n" + " \"clientId\": \"" + qrCusModel.getClientId() + "\","
                + "\n" + " \"device\": \"" + qrCusModel.getDevice() + "\","
                + "\n" + " \"location\": \"" + qrCusModel.getLocation() + "\","
                + "\n" + " \"imei\": \"" + qrCusModel.getImei() + "\","
                + "\n" + " \"note\": \"Thanh toan DH order-abc-123\"}"
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String convertJsontoString_CreateQRCus(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            qrCusModel.setToken(jsonObject.getString("token"));
            qrCusModel.setMasterMC(jsonObject.getString("masterMC"));
            qrCusModel.setMerchantCode(jsonObject.getString("merchantCode"));
            qrCusModel.setTerminalId(jsonObject.getString("terminalId"));
            qrCusModel.setMobile(jsonObject.getString("mobile"));
            qrCusModel.setPayDate(jsonObject.getString("payDate"));
            qrCusModel.setDebitAmount(jsonObject.getString("debitAmount"));
            qrCusModel.setTraceTransfer(jsonObject.getString("traceTransfer"));
            qrCusModel.setQrInfo(jsonObject.getString("qrInfo"));
            qrCusModel.setUserName(jsonObject.getString("userName"));
            qrCusModel.setMessageType(jsonObject.getString("messageType"));
            qrCusModel.setInvoiceNo(jsonObject.getString("invoiceNo"));
            qrCusModel.setVoucherCode(jsonObject.getString("voucherCode"));
            qrCusModel.setMobileId(jsonObject.getString("mobileId"));
            qrCusModel.setClientId(jsonObject.getString("clientId"));
            qrCusModel.setDevice(jsonObject.getString("device"));
            qrCusModel.setLocation(jsonObject.getString("location"));
            qrCusModel.setImei(jsonObject.getString("imei"));
            //qrCusModel.setNote(jsonObject.getString("note"));

            String encodeString = qrCusModel.getToken() + "|"
                    + qrCusModel.getMasterMC() + "|"
                    + qrCusModel.getMerchantCode() + "|"
                    + qrCusModel.getTerminalId() + "|"
                    + qrCusModel.getMobile() + "|"
                    + qrCusModel.getPayDate() + "|"
                    + qrCusModel.getDebitAmount() + "|"
                    + qrCusModel.getTraceTransfer() + "|"
                    + qrCusModel.getQrInfo() + "|"
                    + qrCusModel.getUserName() + "|"
                    + qrCusModel.getMessageType() + "|"
                    + qrCusModel.getVoucherCode() + "|"
                    + qrCusModel.getMobileId() + "|"
                    + qrCusModel.getClientId() + "|"
                    + qrCusModel.getDevice() + "|"
                    + qrCusModel.getLocation() + "|"
                    + qrCusModel.getImei() + "|"
                    + qrCusModel.getInvoiceNo();
            return encodeString;

        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

        return "";
    }

    @Override
    public String encodeStringToHMACSHA256(String encodeString, String secretKey) {
        Mac sha256_HMAC;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            Base64.Encoder encoder = Base64.getEncoder();
            String hash = encoder.encodeToString(sha256_HMAC.doFinal(encodeString.getBytes()));
            return hash;
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

        return "";
    }

    @Override
    public String convertHexToChar(String hexString) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < hexString.length(); i += 2) {
            String str = hexString.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    @Override
    public int convertHexToDecimal(String hexString) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        return Integer.parseInt(hexString, 16);
    }

    @Override
    public ArrayList loadDataTable(String qrCusString) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<DataCusStringModel> arrayList = new ArrayList<DataCusStringModel>();
        int length, length_i, length_ii, i, check;
        String lv_string1, lv_string2;
        i = 0;
        length = qrCusString.length();
        do {
            DataCusStringModel tag1 = new DataCusStringModel();
            tag1.setLevel1(qrCusString.substring(0, 2));
            tag1.setLength(qrCusString.substring(2, 4));
            int check1;
            check1 = convertHexToDecimal(tag1.getLength());
            tag1.setLength(String.valueOf(check1));
            tag1.setValue(qrCusString.substring(4, check1 * 2 + 4));
            lv_string1 = tag1.getValue();
            tag1.setValue(convertHexToChar(tag1.getValue()));
            arrayList.add(tag1);
            length = length - ((check1 * 2) + 4);
            switch (tag1.getLevel1()) {
                case "61":
                    length_i = Integer.parseInt(tag1.getLength());

                    do {
                        i++;
                        DataCusStringModel tag2 = new DataCusStringModel();
                        tag2.setLevel1(tag1.getLevel1());
                        tag2.setLevel2(lv_string1.substring(0, 2));
                        tag2.setLength(lv_string1.substring(2, 4));
                        int check2;
                        check2 = convertHexToDecimal(tag2.getLength());
                        tag2.setLength(String.valueOf(check2));
                        tag2.setValue(lv_string1.substring(4, check2 * 2 + 4));
                        lv_string2 = tag2.getValue();
                        tag2.setValue(convertHexToChar(lv_string2));
                        arrayList.add(tag2);

                        if (tag2.getLevel2().equals("63")) {
                            length_ii = Integer.parseInt(tag2.getLength());

                            do {
                                //i++;
                                DataCusStringModel tag3_1 = new DataCusStringModel();
                                tag3_1.setLevel1(tag2.getLevel1());
                                tag3_1.setLevel2(tag2.getLevel2());
                                if (lv_string2.substring(0, 2).equals("57")) {
                                    tag3_1.setLevel3(lv_string2.substring(0, 2));
                                    tag3_1.setLength(lv_string2.substring(2, 4));

                                } else {
                                    if (lv_string2.substring(0, 4).equals("9F24")) {
                                        tag3_1.setLevel3(lv_string2.substring(0, 4));
                                        tag3_1.setLength(lv_string2.substring(4, 6));
                                    } else {
                                        break;
                                    }
                                }
                                int j;
                                j = tag3_1.getLevel3().length();
                                check = convertHexToDecimal(tag3_1.getLength());
                                tag3_1.setLength(String.valueOf(check));
                                tag3_1.setValue(lv_string2.substring(j + 2, check * 2 + 2 + j));
                                i++;
                                tag3_1.setValue(convertHexToChar(tag3_1.getValue()));
                                arrayList.add(tag3_1);
                                lv_string2 = lv_string2.substring(check * 2 + 2 + j);

                                length_ii = length_ii - (check + 2 + j);

                            } while (length_ii > 0);

                        }
                        length_i = length_i - (check2 + 4);
                        lv_string1 = lv_string1.substring(Integer.parseInt(tag2.getLength()) * 2 + 4);
                    } while (length_i > 0);

                    break;
                case "62":
                    length_i = Integer.parseInt(tag1.getLength());

                    do {
                        i++;
                        DataCusStringModel tag2_1 = new DataCusStringModel();
                        tag2_1.setLevel1(tag1.getLevel1());
                        tag2_1.setLevel2(lv_string1.substring(0, 4));
                        tag2_1.setLength(lv_string1.substring(4, 6));
                        check = convertHexToDecimal(tag2_1.getLength());
                        tag2_1.setLength(String.valueOf(check));
                        tag2_1.setValue(lv_string1.substring(6, check * 2 + 6));
                        tag2_1.setValue(convertHexToChar(lv_string1.substring(6, check * 2 + 6)));
                        arrayList.add(tag2_1);
                        length_i = length_i - (check + 6);
                        lv_string1 = lv_string1.substring(Integer.parseInt(tag2_1.getLength()) * 2 + 6);

                    } while (length_i > 0);

                    break;
            }

            qrCusString = qrCusString.substring((Integer.parseInt(tag1.getLength()) * 2) + 4);
            i++;

        } while (length > 0);

        return arrayList;
    }

}
