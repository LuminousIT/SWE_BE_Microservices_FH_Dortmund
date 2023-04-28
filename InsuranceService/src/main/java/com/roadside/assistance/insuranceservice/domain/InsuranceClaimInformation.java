package com.roadside.assistance.insuranceservice.domain;

public class InsuranceClaimInformation
{

    public String claim_id;

    public String claim_type;

    public String claim_status;

    public String user_information;


    public String getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(String claim_id)
    {
        this.claim_id = claim_id;
    }

    public String getClaim_type() {
        return claim_type;
    }

    public void setClaim_type(String claim_type)
    {
        this.claim_type = claim_type;
    }

    public String getClaim_status()
    {
        return claim_status;
    }

    public void setClaim_status(String claim_status)
    {
        this.claim_status = claim_status;
    }

    public String getUser_information() {
        return user_information;
    }

    public void setUser_information(String user_information)
    {
        this.user_information = user_information;
    }



}
