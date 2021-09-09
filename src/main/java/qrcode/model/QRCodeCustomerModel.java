/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class QRCodeCustomerModel {
    private String qrCustomerText;

    public QRCodeCustomerModel() {
    }

    public QRCodeCustomerModel(String qrCustomerText) {
        this.qrCustomerText = qrCustomerText;
    }

    public String getQrCustomerText() {
        return qrCustomerText;
    }

    public void setQrCustomerText(String qrCustomerText) {
        this.qrCustomerText = qrCustomerText;
    }

    private String token;
    private String masterMC;
    private String merchantCode;
    private String terminalId;
    private String mobile;
    private String payDate;
    private String debitAmount;
    private String traceTransfer;
    private String qrInfo;
    private String userName;
    private String messageType;
    private String invoiceNo;
    private String voucherCode;
    private String mobileId;
    private String clientId;
    private String device;
    private String location;
    private String imei;
    private String note;

    public QRCodeCustomerModel(String token, String masterMC, String merchantCode, String terminalId, String mobile, String payDate, String debitAmount, String traceTransfer, String qrInfo, String userName, String messageType, String invoiceNo, String voucherCode, String mobileId, String clientId, String device, String location, String imei, String note) {
        this.token = token;
        this.masterMC = masterMC;
        this.merchantCode = merchantCode;
        this.terminalId = terminalId;
        this.mobile = mobile;
        this.payDate = payDate;
        this.debitAmount = debitAmount;
        this.traceTransfer = traceTransfer;
        this.qrInfo = qrInfo;
        this.userName = userName;
        this.messageType = messageType;
        this.invoiceNo = invoiceNo;
        this.voucherCode = voucherCode;
        this.mobileId = mobileId;
        this.clientId = clientId;
        this.device = device;
        this.location = location;
        this.imei = imei;
        this.note = note;
    }

    public String getToken() {
        return token;
    }

    public String getMasterMC() {
        return masterMC;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPayDate() {
        return payDate;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public String getTraceTransfer() {
        return traceTransfer;
    }

    public String getQrInfo() {
        return qrInfo;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getDevice() {
        return device;
    }

    public String getLocation() {
        return location;
    }

    public String getImei() {
        return imei;
    }

    public String getNote() {
        return note;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMasterMC(String masterMC) {
        this.masterMC = masterMC;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setTraceTransfer(String traceTransfer) {
        this.traceTransfer = traceTransfer;
    }

    public void setQrInfo(String qrInfo) {
        this.qrInfo = qrInfo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
