/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.model;

/**
 * @author huuduong
 */
public class QRCodeRefundModel {
    private String merchantCode;
    private String qrTrace;
    private String payTxnId;
    private String refundTxnId;
    private String typeRefund;
    private String amount;
    private String refundContent;
    private String payDate;

    public QRCodeRefundModel() {
    }

    public QRCodeRefundModel(String merchantCode, String qrTrace, String payTxnId, String refundTxnId, String typeRefund, String amount, String refundContent, String payDate) {
        this.merchantCode = merchantCode;
        this.qrTrace = qrTrace;
        this.payTxnId = payTxnId;
        this.refundTxnId = refundTxnId;
        this.typeRefund = typeRefund;
        this.amount = amount;
        this.refundContent = refundContent;
        this.payDate = payDate;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public String getQrTrace() {
        return qrTrace;
    }

    public String getPayTxnId() {
        return payTxnId;
    }

    public String getRefundTxnId() {
        return refundTxnId;
    }

    public String getTypeRefund() {
        return typeRefund;
    }

    public String getAmount() {
        return amount;
    }

    public String getRefundContent() {
        return refundContent;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public void setQrTrace(String qrTrace) {
        this.qrTrace = qrTrace;
    }

    public void setPayTxnId(String payTxnId) {
        this.payTxnId = payTxnId;
    }

    public void setRefundTxnId(String refundTxnId) {
        this.refundTxnId = refundTxnId;
    }

    public void setTypeRefund(String typeRefund) {
        this.typeRefund = typeRefund;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setRefundContent(String refundContent) {
        this.refundContent = refundContent;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }


}
