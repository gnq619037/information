package com.query.info.entity;

import java.io.Serializable;

/**
 * @author guonanqing
 * @version 1.0
 * @desc 用户信息
 * @date 2020/9/28 14:33
 */
public class Information implements Serializable {
    private static final long serialVersionUID = -2493208036286837846L;

    //费用批次
    private String codeBatch;
    //专家编号
    private String expertCode;
    //专家姓名
    private String expertName;
    //性别
    private String sex;
    //出生年月
    private String birthDate;
    //证件类型
    private String cardType;
    //证件号码
    private String cardNumber;
    //国籍
    private String country;
    //是否境外人员
    private String outside;
    //中文姓名（境外）
    private String cnName;
    //境内有无住所
    private String insideHome;
    //境内是否居住满183天
    private String insideLiveReachDay;
    //银行账户姓名
    private String bankAccountName;
    //银行账号
    private String bankCode;
    //开户行名称
    private String bankName;
    //开户行联行号
    private String unionBankCode;
    //移动电话
    private String telPhone;
    //电子信箱
    private String email;
    //学校代码
    private String schoolCode;
    //学校名称
    private String schoolName;
    //应发金额
    private String payAmount;
    //税额
    private String tax;
    //实发金额
    private String realPayAmount;
    //当前状态
    private String currentStatus;
    //评审篇数
    private String reviewNum;
    //结算状态
    private String settlementStatus;
    //失败类型
    private String failStatus;
    //发放时间
    private String publishTime;
    //发放批次
    private String publishBatch;
    //发放结果
    private String publishResult;
    //发放次数（上次）
    private String publishNum;
    //经费类型
    private String fundType;
    //信息标记
    private String infoFlag;
    //银行开户验证状态（上次）
    private String backAccountVerify;
    //发放失败原因
    private String publishFailMsg;
    //银行发放用途标识
    private String publishFailUseFlag;
    //往期批次
    private String pastBatch;
    //消息状态
    private String messageStatus;


    public String getCodeBatch() {
        return codeBatch;
    }

    public void setCodeBatch(String codeBatch) {
        this.codeBatch = codeBatch;
    }

    public String getExpertCode() {
        return expertCode;
    }

    public void setExpertCode(String expertCode) {
        this.expertCode = expertCode;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOutside() {
        return outside;
    }

    public void setOutside(String outside) {
        this.outside = outside;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getInsideHome() {
        return insideHome;
    }

    public void setInsideHome(String insideHome) {
        this.insideHome = insideHome;
    }

    public String getInsideLiveReachDay() {
        return insideLiveReachDay;
    }

    public void setInsideLiveReachDay(String insideLiveReachDay) {
        this.insideLiveReachDay = insideLiveReachDay;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUnionBankCode() {
        return unionBankCode;
    }

    public void setUnionBankCode(String unionBankCode) {
        this.unionBankCode = unionBankCode;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getRealPayAmount() {
        return realPayAmount;
    }

    public void setRealPayAmount(String realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(String reviewNum) {
        this.reviewNum = reviewNum;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getFailStatus() {
        return failStatus;
    }

    public void setFailStatus(String failStatus) {
        this.failStatus = failStatus;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishBatch() {
        return publishBatch;
    }

    public void setPublishBatch(String publishBatch) {
        this.publishBatch = publishBatch;
    }

    public String getPublishResult() {
        return publishResult;
    }

    public void setPublishResult(String publishResult) {
        this.publishResult = publishResult;
    }

    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getInfoFlag() {
        return infoFlag;
    }

    public void setInfoFlag(String infoFlag) {
        this.infoFlag = infoFlag;
    }

    public String getBackAccountVerify() {
        return backAccountVerify;
    }

    public void setBackAccountVerify(String backAccountVerify) {
        this.backAccountVerify = backAccountVerify;
    }

    public String getPublishFailMsg() {
        return publishFailMsg;
    }

    public void setPublishFailMsg(String publishFailMsg) {
        this.publishFailMsg = publishFailMsg;
    }

    public String getPublishFailUseFlag() {
        return publishFailUseFlag;
    }

    public void setPublishFailUseFlag(String publishFailUseFlag) {
        this.publishFailUseFlag = publishFailUseFlag;
    }

    public String getPastBatch() {
        return pastBatch;
    }

    public void setPastBatch(String pastBatch) {
        this.pastBatch = pastBatch;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
