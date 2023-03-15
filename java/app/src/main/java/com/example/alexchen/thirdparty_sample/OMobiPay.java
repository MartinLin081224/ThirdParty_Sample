package com.example.alexchen.thirdparty_sample;

import android.util.Log;

/**
 * Created by alex.chen on 2017/4/6.
 */

public class OMobiPay {

    String MerchantID;
    String APPID;
    public String ENVIRONMENT = OPAY_PRO;
    public String URL_SCHEMA = "opay";
    public static String OPAY_STAGE = "STAGE";
    public static String OPAY_PRO = "PRODUCTION";

    public OMobiPay(String merchantID, String APPID) {
        this.MerchantID = merchantID;
        this.APPID = APPID;
    }

    public void setAppEnvironment(String ENVIRONMENT){
        this.ENVIRONMENT = ENVIRONMENT;
        if(ENVIRONMENT.equals(OPAY_STAGE)){
            URL_SCHEMA = "opay-stage";
        }else{
            URL_SCHEMA = "opay";
        }
    }

    public OMobiPay(String merchantID) {
        this.MerchantID = merchantID;
    }

    public String checkoutWithTradeToken(String TradeToken,String redirectURL){
        String url = "";
        if(APPID == null){
            url = URL_SCHEMA+"://checkout?MerchantID="+MerchantID+"&TradeToken="+TradeToken+"&redirectURL="+redirectURL+
                    "&Version=2&native1=1";
        }else{
            url = URL_SCHEMA + "://checkout?MerchantID="+MerchantID+"&APPID="+APPID+"&TradeToken="+TradeToken+"&redirectURL="+redirectURL+
                    "&Version=2&native1=1";
        }
        Log.d("third","url = " + url);
        return url;
    }

}
