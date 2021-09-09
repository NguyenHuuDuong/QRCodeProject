/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class QRCodeModel {
    private String qrText;

    public QRCodeModel() {
    }

    public QRCodeModel(String qrText) {
        this.qrText = qrText;
    }

    public String getQrText() {
        return qrText;
    }

    public void setQrText(String qrText) {
        this.qrText = qrText;
    }

    private String appId;
    private String merchantName;
    private String serviceCode;
    private String countryCode;
    private String masterMerCode;
    private String merchantType;
    private String merchantCode;
    private String payloadFormat;
    private String terminalId;
    private String payType;
    private String productId;
    private String productName;
    private String imageName;
    private String txnId;
    private String amount;
    private String tipAndFee;
    private String ccy;
    private String expDate;
    private String desc;
    private String checksum;
    private String merchantCity;
    private String merchantCC;
    private String fixedFee;
    private String percentageFee;
    private String pinCode;
    private String mobile;
    private String billNumber;
    private String creator;
    private String consumerID;
    private String purpose;
    private String payDate;

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getAppId() {
        return appId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getMasterMerCode() {
        return masterMerCode;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public String getPayloadFormat() {
        return payloadFormat;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getPayType() {
        return payType;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getImageName() {
        return imageName;
    }

    public String getTxnId() {
        return txnId;
    }

    public String getAmount() {
        return amount;
    }

    public String getTipAndFee() {
        return tipAndFee;
    }

    public String getCcy() {
        return ccy;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getDesc() {
        return desc;
    }

    public String getChecksum() {
        return checksum;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public String getMerchantCC() {
        return merchantCC;
    }

    public String getFixedFee() {
        return fixedFee;
    }

    public String getPercentageFee() {
        return percentageFee;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getCreator() {
        return creator;
    }

    public String getConsumerID() {
        return consumerID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setMasterMerCode(String masterMerCode) {
        this.masterMerCode = masterMerCode;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public void setPayloadFormat(String payloadFormat) {
        this.payloadFormat = payloadFormat;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setTipAndFee(String tipAndFee) {
        this.tipAndFee = tipAndFee;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public void setMerchantCC(String merchantCC) {
        this.merchantCC = merchantCC;
    }

    public void setFixedFee(String fixedFee) {
        this.fixedFee = fixedFee;
    }

    public void setPercentageFee(String percentageFee) {
        this.percentageFee = percentageFee;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setConsumerID(String consumerID) {
        this.consumerID = consumerID;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public QRCodeModel(String appId, String merchantName, String serviceCode, String countryCode, String masterMerCode, String merchantType, String merchantCode, String payloadFormat, String terminalId, String payType, String productId, String productName, String imageName, String txnId, String amount, String tipAndFee, String ccy, String expDate, String desc, String checksum, String merchantCity, String merchantCC, String fixedFee, String percentageFee, String pinCode, String mobile, String billNumber, String creator, String consumerID, String purpose, String payDate) {
        this.appId = appId;
        this.merchantName = merchantName;
        this.serviceCode = serviceCode;
        this.countryCode = countryCode;
        this.masterMerCode = masterMerCode;
        this.merchantType = merchantType;
        this.merchantCode = merchantCode;
        this.payloadFormat = payloadFormat;
        this.terminalId = terminalId;
        this.payType = payType;
        this.productId = productId;
        this.productName = productName;
        this.imageName = imageName;
        this.txnId = txnId;
        this.amount = amount;
        this.tipAndFee = tipAndFee;
        this.ccy = ccy;
        this.expDate = expDate;
        this.desc = desc;
        this.checksum = checksum;
        this.merchantCity = merchantCity;
        this.merchantCC = merchantCC;
        this.fixedFee = fixedFee;
        this.percentageFee = percentageFee;
        this.pinCode = pinCode;
        this.mobile = mobile;
        this.billNumber = billNumber;
        this.creator = creator;
        this.consumerID = consumerID;
        this.purpose = purpose;
        this.payDate = payDate;
    }


}
