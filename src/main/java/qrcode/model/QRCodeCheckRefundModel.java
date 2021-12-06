package qrcode.model;

public class QRCodeCheckRefundModel {
    private String merchantCode;
    private String qrTrace;
    private String refundTxnId;
    private String typeRefund;
    private String amount;
    private String initRefundTime;

    public QRCodeCheckRefundModel() {

    }

    public QRCodeCheckRefundModel(String merchantCode, String qrTrace, String refundTxnId, String typeRefund, String amount, String initRefundTime) {
        this.merchantCode = merchantCode;
        this.qrTrace = qrTrace;
        this.refundTxnId = refundTxnId;
        this.typeRefund = typeRefund;
        this.amount = amount;
        this.initRefundTime = initRefundTime;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getQrTrace() {
        return qrTrace;
    }

    public void setQrTrace(String qrTrace) {
        this.qrTrace = qrTrace;
    }

    public String getRefundTxnId() {
        return refundTxnId;
    }

    public void setRefundTxnId(String refundTxnId) {
        this.refundTxnId = refundTxnId;
    }

    public String getTypeRefund() {
        return typeRefund;
    }

    public void setTypeRefund(String typeRefund) {
        this.typeRefund = typeRefund;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInitRefundTime() {
        return initRefundTime;
    }

    public void setInitRefundTime(String initRefundTime) {
        this.initRefundTime = initRefundTime;
    }

    @Override
    public String toString() {
        return "QRCodeCheckRefundModel{" +
                "merchantCode='" + merchantCode + '\'' +
                ", qrTrace='" + qrTrace + '\'' +
                ", refundTxnId='" + refundTxnId + '\'' +
                ", typeRefund='" + typeRefund + '\'' +
                ", amount='" + amount + '\'' +
                ", initRefundTime='" + initRefundTime + '\'' +
                '}';
    }
}
