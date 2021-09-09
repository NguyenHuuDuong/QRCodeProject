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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qrcode.IF.QRCodeIF;
import qrcode.model.DataStringModel;
import qrcode.model.QRCodeMerchantPaymentModel;
import qrcode.model.QRCodeModel;
import qrcode.model.QRCodeRefundModel;

/**
 * @author huuduong
 */
public class QRCodeController implements QRCodeIF {
//private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    QRCodeModel qrModel = new QRCodeModel();
    //private static final String SECRET_KEY = "vnpay@Merchant";
    QRCodeMerchantPaymentModel qrPayment = new QRCodeMerchantPaymentModel();
    QRCodeRefundModel qrRefund = new QRCodeRefundModel();

    @Override
    public void writeQRImage(String text, int width, int height, String filePath) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);  // write image into path.
        } catch (WriterException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (IOException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String loadParamsDefault_CreateQR() {
        String jsonString = "{"
                + "\n" + " \"appId\": \"MERCHANT\","
                + "\n" + " \"merchantName\": \"PSS TEAM\","
                + "\n" + " \"serviceCode\": \"03\","
                + "\n" + " \"countryCode\": \"VN\","
                + "\n" + " \"masterMerCode\": \"A000000775\","
                + "\n" + " \"merchantType\": \"9999\","
                + "\n" + " \"merchantCode\": \"88888888\","
                + "\n" + " \"payloadFormat\": \"\","
                + "\n" + " \"terminalId\": \"PSSTEST\","
                + "\n" + " \"payType\": \"03\","
                + "\n" + " \"productId\": \"\","
                + "\n" + " \"productName\": \"\","
                + "\n" + " \"imageName\": \"\","
                + "\n" + " \"txnId\": \"VNP_TEST006\","
                + "\n" + " \"amount\": \"100000\","
                + "\n" + " \"tipAndFee\": \"\","
                + "\n" + " \"ccy\": \"704\","
                + "\n" + " \"expDate\": \"2108080900\","
                + "\n" + " \"desc\": \"\","
                //+ " \"checksum\": \"3A764750324687C0439444EDEA8FC8E8\","
                + "\n" + " \"merchantCity\": \"\","
                + "\n" + " \"merchantCC\": \"\","
                + "\n" + " \"fixedFee\": \"\","
                + "\n" + " \"percentageFee\": \"\","
                + "\n" + " \"pinCode\": \"\","
                + "\n" + " \"mobile\": \"\","
                + "\n" + " \"billNumber\": \"VNP_TEST006\","
                + "\n" + " \"creator\": \"\","
                + "\n" + " \"consumerID\": \"\","
                + "\n" + " \"purpose\": \"\""
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String convertJsontoString_CreateQR(String jsonString, String secretKey) {
        //QRCodeModel qrModel = new QRCodeModel();
        try {
            //add jsonString to the constructor
            JSONObject jsonObject = new JSONObject(jsonString);
            qrModel.setAppId(jsonObject.getString("appId"));
            qrModel.setMerchantName(jsonObject.getString("merchantName"));
            qrModel.setServiceCode(jsonObject.getString("serviceCode"));
            qrModel.setCountryCode(jsonObject.getString("countryCode"));
            qrModel.setMasterMerCode(jsonObject.getString("masterMerCode"));
            qrModel.setMerchantType(jsonObject.getString("merchantType"));
            qrModel.setMerchantCode(jsonObject.getString("merchantCode"));
            qrModel.setPayloadFormat(jsonObject.getString("payloadFormat"));
            qrModel.setTerminalId(jsonObject.getString("terminalId"));
            qrModel.setPayType(jsonObject.getString("payType"));
            qrModel.setProductId(jsonObject.getString("productId"));
            qrModel.setProductName(jsonObject.getString("productName"));
            qrModel.setImageName(jsonObject.getString("imageName"));
            qrModel.setTxnId(jsonObject.getString("txnId"));
            qrModel.setAmount(jsonObject.getString("amount"));
            qrModel.setTipAndFee(jsonObject.getString("tipAndFee"));
            qrModel.setCcy(jsonObject.getString("ccy"));
            qrModel.setExpDate(jsonObject.getString("expDate"));
            qrModel.setDesc(jsonObject.getString("desc"));
            //qrModel.setChecksum(jsonObject.getString("checksum"));
            qrModel.setMerchantCity(jsonObject.getString("merchantCity"));
            qrModel.setMerchantCC(jsonObject.getString("merchantCC"));
            qrModel.setFixedFee(jsonObject.getString("fixedFee"));
            qrModel.setPercentageFee(jsonObject.getString("percentageFee"));
            qrModel.setPinCode(jsonObject.getString("pinCode"));
            qrModel.setMobile(jsonObject.getString("mobile"));
            qrModel.setBillNumber(jsonObject.getString("billNumber"));
            qrModel.setCreator(jsonObject.getString("creator"));
            qrModel.setConsumerID(jsonObject.getString("consumerID"));
            qrModel.setPurpose(jsonObject.getString("purpose"));
            String encodeString = qrModel.getAppId() + "|"
                    + qrModel.getMerchantName() + "|"
                    + qrModel.getServiceCode() + "|"
                    + qrModel.getCountryCode() + "|"
                    + qrModel.getMasterMerCode() + "|"
                    + qrModel.getMerchantType() + "|"
                    + qrModel.getMerchantCode() + "|"
                    + qrModel.getTerminalId() + "|"
                    + qrModel.getPayType() + "|"
                    + qrModel.getProductId() + "|"
                    + qrModel.getTxnId() + "|"
                    + qrModel.getAmount() + "|"
                    + qrModel.getTipAndFee() + "|"
                    + qrModel.getCcy() + "|"
                    + qrModel.getExpDate() + "|"
                    + secretKey;

            return encodeString;
        } catch (JSONException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String encodeMD5(String encodeString) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(encodeString.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            String checksum = no.toString(16);
            while (checksum.length() < 32) {
                checksum = "0" + checksum;
            }
            return checksum;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String loadParamsDefault_Checktrans() {

        String jsonString = "{"
                + "\n" + " \"merchantCode\":\"88888888\","
                //+ " \"checkSum\":\"2F950ABEF41DBC13A027932B72F645D5\","
                + "\n" + " \"terminalID\":\"PSSTEST\","
                + "\n" + " \"txnId\":\"VNP_TEST006\","
                + "\n" + " \"payDate\":\"05/08/2021\""
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String convertJsontoString_Checktrans(String jsonString, String secretKey) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            qrModel.setMerchantCode(jsonObject.getString("merchantCode"));
            //qrModel.setChecksum(jsonObject.getString("checkSum"));
            qrModel.setTerminalId(jsonObject.getString("terminalID"));
            qrModel.setTxnId(jsonObject.getString("txnId"));
            qrModel.setPayDate(jsonObject.getString("payDate"));

            String encodeString = qrModel.getPayDate() + "|"
                    + qrModel.getTxnId() + "|"
                    + qrModel.getMerchantCode() + "|"
                    + qrModel.getTerminalId() + "|"
                    + secretKey;
            return encodeString;

        } catch (JSONException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String loadParamsOfficial_CreateQR(String checksum) {
        String jsonString = "{"
                + "\n" + " \"appId\": \"" + qrModel.getAppId() + "\","
                + "\n" + " \"merchantName\": \"" + qrModel.getMerchantName() + "\","
                + "\n" + " \"serviceCode\": \"" + qrModel.getServiceCode() + "\","
                + "\n" + " \"countryCode\": \"" + qrModel.getCountryCode() + "\","
                + "\n" + " \"masterMerCode\": \"" + qrModel.getMasterMerCode() + "\","
                + "\n" + " \"merchantType\": \"" + qrModel.getMerchantType() + "\","
                + "\n" + " \"merchantCode\": \"" + qrModel.getMerchantCode() + "\","
                + "\n" + " \"payloadFormat\": \"" + qrModel.getPayloadFormat() + "\","
                + "\n" + " \"terminalId\": \"" + qrModel.getTerminalId() + "\","
                + "\n" + " \"payType\": \"" + qrModel.getPayType() + "\","
                + "\n" + " \"productId\": \"" + qrModel.getProductId() + "\","
                + "\n" + " \"productName\": \"" + qrModel.getProductName() + "\","
                + "\n" + " \"imageName\": \"" + qrModel.getImageName() + "\","
                + "\n" + " \"txnId\": \"" + qrModel.getTxnId() + "\","
                + "\n" + " \"amount\": \"" + qrModel.getAmount() + "\","
                + "\n" + " \"tipAndFee\": \"" + qrModel.getTipAndFee() + "\","
                + "\n" + " \"ccy\": \"" + qrModel.getCcy() + "\","
                + "\n" + " \"expDate\": \"" + qrModel.getExpDate() + "\","
                + "\n" + " \"desc\": \"" + qrModel.getDesc() + "\","
                + "\n" + " \"checksum\": \"" + checksum.toUpperCase() + "\","
                + "\n" + " \"merchantCity\": \"" + qrModel.getMerchantCity() + "\","
                + "\n" + " \"merchantCC\": \"" + qrModel.getMerchantCC() + "\","
                + "\n" + " \"fixedFee\": \"" + qrModel.getFixedFee() + "\","
                + "\n" + " \"percentageFee\": \"" + qrModel.getPercentageFee() + "\","
                + "\n" + " \"pinCode\": \"" + qrModel.getPinCode() + "\","
                + "\n" + " \"mobile\": \"" + qrModel.getMobile() + "\","
                + "\n" + " \"billNumber\": \"" + qrModel.getBillNumber() + "\","
                + "\n" + " \"creator\": \"" + qrModel.getCreator() + "\","
                + "\n" + " \"consumerID\": \"" + qrModel.getConsumerID() + "\","
                + "\n" + " \"purpose\": \"" + qrModel.getPurpose() + "\""
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String loadParamsOfficial_Checktrans(String checksum) {
        String jsonString = "{"
                + "\n" + " \"merchantCode\":\"" + qrModel.getMerchantCode() + "\","
                + "\n" + " \"checkSum\":\"" + checksum.toUpperCase() + "\","
                + "\n" + " \"terminalID\":\"" + qrModel.getTerminalId() + "\","
                + "\n" + " \"txnId\":\"" + qrModel.getTxnId() + "\","
                + "\n" + " \"payDate\":\"" + qrModel.getPayDate() + "\""
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public ArrayList addRowTable(String qrString) {
        int len, i, lv_convert, leni, lv_convert1;
        String lv_string;
        ArrayList<DataStringModel> arrayList = new ArrayList<DataStringModel>();
        //String col[] = {"LEVEL_1", "LEVEL_2", "LENGTH", "VALUE"};
        //DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        len = qrString.length();
        i = 0;

        do {

            DataStringModel data1 = new DataStringModel();

            data1.setLevel1(qrString.substring(0, 2));
            //lv_convert = Integer.parseInt(qrString.substring(2,4));
            data1.setLength((qrString.substring(2, 4)));
            //lv_convert = data1.getLength();
            data1.setValue(qrString.substring(4, Integer.parseInt(data1.getLength()) + 4));
            //array.set(i, data1);
            arrayList.add(i, data1);
            len = len - (4 + Integer.parseInt(data1.getLength()));
            //System.out.println(data1.getLevel1() + "\t" + data1.getLevel2() + "\t" + data1.getLength() + "\t" + data1.getValue());
            switch (data1.getLevel1()) {
                case "26":

                    //i++;
                    leni = data1.getValue().length();
                    lv_string = data1.getValue();
                    //data2.level1 = data1.level1;

                    do {

                        i++;
                        DataStringModel data2 = new DataStringModel();
                        data2.setLevel1(data1.getLevel1());
                        //data2.level2 = lv_string.substring(0, 2);
                        data2.setLevel2(lv_string.substring(0, 2));
                        //lv_convert1 = Integer.parseInt(lv_string.substring(2,4));
                        data2.setLength((lv_string.substring(2, 4)));
                        //data2.value = lv_string.substring(4, lv_convert1 + 4);
                        data2.setValue(lv_string.substring(4, Integer.parseInt(data2.getLength()) + 4));
                        //array.set(i, data2);
                        arrayList.add(i, data2);

                        leni = leni - (4 + Integer.parseInt(data2.getLength()));
                        lv_string = lv_string.substring(Integer.parseInt(data2.getLength()) + 4);
                        //System.out.println(data2.getLevel1() + "\t" + data2.getLevel2() + "\t" + data2.getLength() + "\t" + data2.getValue());
                        //i++;

                    } while (leni > 0);

                    break;
                case "62":

                    //i++;
                    leni = data1.getValue().length();
                    lv_string = data1.getValue();
                    //data2.level1 = data1.level1;

                    do {
                        i++;
                        DataStringModel data3 = new DataStringModel();
                        data3.setLevel1(data1.getLevel1());
                        //data2.level2 = lv_string.substring(0, 2);
                        data3.setLevel2(lv_string.substring(0, 2));
                        //lv_convert1 = Integer.parseInt(lv_string.substring(2,4));
                        data3.setLength((lv_string.substring(2, 4)));
                        //data2.value = lv_string.substring(4, lv_convert1 + 4);
                        data3.setValue(lv_string.substring(4, Integer.parseInt(data3.getLength()) + 4));
                        //array.set(i, data2);
                        arrayList.add(i, data3);

                        leni = leni - (4 + Integer.parseInt(data3.getLength()));
                        lv_string = lv_string.substring(Integer.parseInt(data3.getLength()) + 4);
                        //System.out.println(data3.getLevel1() + "\t" + data3.getLevel2() + "\t" + data3.getLength() + "\t" + data3.getValue());
                        //i++;
                    } while (leni > 0);

                    break;

                default:
                    break;
            }

            qrString = qrString.substring(Integer.parseInt(data1.getLength()) + 4);
            i++;

        } while (len > 0);

        return arrayList;
    }

    @Override
    public String loadParamsDefault_IPNQRCode() {

        String ipnString = "{"
                + "\n" + " \"code\":\"00\","
                + "\n" + " \"message\":\"Tru tien vi thanh cong\","
                + "\n" + " \"msgType\":\"1\","
                + "\n" + " \"txnId\":\"VNP_TEST006\","
                + "\n" + " \"qrTrace\":\"244203946\","
                + "\n" + " \"bankCode\":\"VNPAYEWALLET\","
                + "\n" + " \"mobile\":\"0333521818\","
                + "\n" + " \"accountNo\":\"\","
                + "\n" + " \"amount\":\"500000\","
                + "\n" + " \"payDate\":\"20210805144501\","
                + "\n" + " \"masterMerCode\":\"A000000775\","
                + "\n" + " \"merchantCode\":\"88888888\","
                + "\n" + " \"terminalId\":\"PSSTEST\","
                + "\n" + " \"addData\":[{\"merchantType\":\"9999\","
                + "\n" + " \"serviceCode\":\"06\","
                + "\n" + " \"masterMerCode\":\"A000000775\","
                + "\n" + " \"merchantCode\":\"88888888\","
                + "\n" + " \"terminalId\":\"PSSTEST\","
                + "\n" + " \"productId\":\"\","
                + "\n" + " \"amount\":\"500000\","
                + "\n" + " \"ccy\":\"704\","
                + "\n" + " \"qty\":\"1\","
                + "\n" + " \"note\":\"\"}],"
                //+ " \"checksum\":\"0A3BB9491FB9DCE9AE362E618848652A\","
                + "\n" + " \"ccy\":\"704\","
                + "\n" + " \"address\":\"\","
                + "\n" + " \"secretKey\":\"VNPAY\""
                + "\n" + "}";

        return ipnString;

    }

    @Override
    public String convertJsontoString_IPNQRCode(String jsonString, String secretKey) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            qrPayment.setCode(jsonObject.getString("code"));
            qrPayment.setMessage(jsonObject.getString("message"));
            qrPayment.setMsgType(jsonObject.getString("msgType"));
            qrPayment.setTxnId(jsonObject.getString("txnId"));
            qrPayment.setQrTrace(jsonObject.getString("qrTrace"));
            qrPayment.setBankCode(jsonObject.getString("bankCode"));
            qrPayment.setMobile(jsonObject.getString("mobile"));
            qrPayment.setAccountNo(jsonObject.getString("accountNo"));
            qrPayment.setAmount(jsonObject.getString("amount"));
            qrPayment.setPayDate(jsonObject.getString("payDate"));
            qrPayment.setMasterMerCode(jsonObject.getString("masterMerCode"));
            qrPayment.setMerchantCode(jsonObject.getString("merchantCode"));
            qrPayment.setTerminalId(jsonObject.getString("terminalId"));
            //qrPayment.setMerchantType(jsonObject.getString("merchantType"));
            //qrPayment.setServiceCode(jsonObject.getString("serviceCode"));
            //qrPayment.setProductId(jsonObject.getString("productId"));
            qrPayment.setCcy(jsonObject.getString("ccy"));
            //qrPayment.setQty(jsonObject.getString("qty"));
            //qrPayment.setNote(jsonObject.getString("note"));
            qrPayment.setAddress(jsonObject.getString("address"));
            JSONArray addData = jsonObject.getJSONArray("addData");
            for (int i = 0; i < addData.length(); i++) {
                JSONObject jsonObjectChill = addData.getJSONObject(i);
                qrPayment.setMerchantType(jsonObjectChill.getString("merchantType"));
                qrPayment.setServiceCode(jsonObjectChill.getString("serviceCode"));
                qrPayment.setProductId(jsonObjectChill.getString("productId"));
                qrPayment.setQty(jsonObjectChill.getString("qty"));
                qrPayment.setNote(jsonObjectChill.getString("note"));
            }

            String encodeString = qrPayment.getCode() + "|"
                    + qrPayment.getMsgType() + "|"
                    + qrPayment.getTxnId() + "|"
                    + qrPayment.getQrTrace() + "|"
                    + qrPayment.getBankCode() + "|"
                    + qrPayment.getMobile() + "|"
                    + qrPayment.getAccountNo() + "|"
                    + qrPayment.getAmount() + "|"
                    + qrPayment.getPayDate() + "|"
                    + qrPayment.getMerchantCode() + "|"
                    + secretKey;
            return encodeString;

        } catch (JSONException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String loadParamsOfficial_IPNQRCode(String checksum) {

        String ipnString = "{"
                + "\n" + " \"code\":\"" + qrPayment.getCode() + "\","
                + "\n" + " \"message\":\"" + qrPayment.getMessage() + "\","
                + "\n" + " \"msgType\":\"" + qrPayment.getMsgType() + "\","
                + "\n" + " \"txnId\":\"" + qrPayment.getTxnId() + "\","
                + "\n" + " \"qrTrace\":\"" + qrPayment.getQrTrace() + "\","
                + "\n" + " \"bankCode\":\"" + qrPayment.getBankCode() + "\","
                + "\n" + " \"mobile\":\"" + qrPayment.getMobile() + "\","
                + "\n" + " \"accountNo\":\"" + qrPayment.getAccountNo() + "\","
                + "\n" + " \"amount\":\"" + qrPayment.getAmount() + "\","
                + "\n" + " \"payDate\":\"" + qrPayment.getPayDate() + "\","
                + "\n" + " \"masterMerCode\":\"" + qrPayment.getMasterMerCode() + "\","
                + "\n" + " \"merchantCode\":\"" + qrPayment.getMerchantCode() + "\","
                + "\n" + " \"terminalId\":\"" + qrPayment.getTerminalId() + "\","
                + "\n" + " \"addData\":[{\"merchantType\":\"" + qrPayment.getMerchantType() + "\","
                + "\n" + " \"serviceCode\":\"" + qrPayment.getServiceCode() + "\","
                + "\n" + " \"masterMerCode\":\"" + qrPayment.getMasterMerCode() + "\","
                + "\n" + " \"merchantCode\":\"" + qrPayment.getMerchantCode() + "\","
                + "\n" + " \"terminalId\":\"" + qrPayment.getTerminalId() + "\","
                + "\n" + " \"productId\":\"" + qrPayment.getProductId() + "\","
                + "\n" + " \"amount\":\"" + qrPayment.getAmount() + "\","
                + "\n" + " \"ccy\":\"" + qrPayment.getCcy() + "\","
                + "\n" + " \"qty\":\"" + qrPayment.getQty() + "\","
                + "\n" + " \"note\":\"" + qrPayment.getNote() + "\"}],"
                + "\n" + " \"checksum\":\"" + checksum.toUpperCase() + "\","
                + "\n" + " \"ccy\":\"" + qrPayment.getCcy() + "\","
                + "\n" + " \"address\":\"" + qrPayment.getAddress() + "\","
                + "\n" + " \"secretKey\":\"VNPAY\""
                + "\n" + "}";

        return ipnString;
    }

    @Override
    public String loadParamsDefault_RefundQR() {
        String jsonString = "{"
                + "\n" + "\"merchantCode\": \"88888888\","
                + "\n" + "\"qrTrace\": \"244203946\","
                + "\n" + "\"payTxnId\": \"VNP_TEST006\","
                + "\n" + "\"refundTxnId\": \"100\","  //you must enter the value with type variable is LONG.
                + "\n" + "\"typeRefund\": \"2\","
                + "\n" + "\"amount\": \"10000\","
                + "\n" + "\"refundContent\": \"Hoan tien test\","
                + "\n" + "\"payDate\": \"20210805144501\""
                // "\n" +"\checkSum\": \"f74b7d8906122113cbb22dc43b3fd95e\"
                + "\n" + "}";

        return jsonString;
    }

    @Override
    public String convertJsontoString_RefundQR(String jsonString, String secretKey) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            qrRefund.setMerchantCode(jsonObject.getString("merchantCode"));
            qrRefund.setQrTrace(jsonObject.getString("qrTrace"));
            qrRefund.setPayTxnId(jsonObject.getString("payTxnId"));
            qrRefund.setRefundTxnId(jsonObject.getString("refundTxnId"));
            qrRefund.setTypeRefund(jsonObject.getString("typeRefund"));
            qrRefund.setAmount(jsonObject.getString("amount"));
            qrRefund.setRefundContent(jsonObject.getString("refundContent"));
            qrRefund.setPayDate(jsonObject.getString("payDate"));
            String encodeString = secretKey
                    + qrRefund.getMerchantCode()
                    + qrRefund.getQrTrace()
                    + qrRefund.getPayTxnId()
                    + qrRefund.getRefundTxnId()
                    + qrRefund.getTypeRefund()
                    + qrRefund.getAmount()
                    + qrRefund.getPayDate();

            return encodeString;
        } catch (JSONException ex) {
            Logger.getLogger(QRCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String loadParamsOfficial_RefundQR(String checksum) {

        String jsonString = "{"
                + "\n" + "\"merchantCode\": \"" + qrRefund.getMerchantCode() + "\","
                + "\n" + "\"qrTrace\": \"" + qrRefund.getQrTrace() + "\","
                + "\n" + "\"payTxnId\": \"" + qrRefund.getPayTxnId() + "\","
                + "\n" + "\"refundTxnId\": \"" + qrRefund.getRefundTxnId() + "\","
                + "\n" + "\"typeRefund\": \"" + qrRefund.getTypeRefund() + "\","
                + "\n" + "\"amount\": \"" + qrRefund.getAmount() + "\","
                + "\n" + "\"refundContent\": \"" + qrRefund.getRefundContent() + "\","
                + "\n" + "\"payDate\": \"" + qrRefund.getPayDate() + "\","
                + "\n" + "\"checkSum\": \"" + checksum.toUpperCase() + "\""
                + "\n" + "}";
        return jsonString;

    }

}
