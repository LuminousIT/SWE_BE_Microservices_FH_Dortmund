package com.roadside.assistance.insuranceservice.domain;

public class InsurancePolicy {


    public  String insurance_type;
    public String ContractInfo;

    public String getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(String insurance_type) {
        this.insurance_type = insurance_type;
    }

    public String getContractInfo() {
        return ContractInfo;
    }

    public void setContractInfo(String contractInfo) {
        ContractInfo = contractInfo;
    }

    public int getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(int payment_method) {
        this.payment_method = payment_method;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCoverage_details() {
        return Coverage_details;
    }

    public void setCoverage_details(String coverage_details) {
        Coverage_details = coverage_details;
    }

    public int payment_method;

    public int amount;
    public int time;

    public String Coverage_details;

}
