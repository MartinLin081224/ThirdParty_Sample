package com.example.alexchen.thirdparty_sample;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txv_MerchantID, txv_TradeToken, txv_redirectURL, txv_RtnData;
    private Button btn_ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * 格式：aaaa://bbbb
        * 這邊範例third+MID://lauch
        * */
        final String redirectURL = "third" + getResources().getString(R.string.MID) + "://launch";

        txv_MerchantID = (TextView) findViewById(R.id.txv_MerchantID);
        txv_TradeToken = (TextView) findViewById(R.id.txv_TradeToken);
        txv_redirectURL = (TextView) findViewById(R.id.txv_redirectURL);
        txv_RtnData = (TextView) findViewById(R.id.txv_RtnData);
        btn_ok = (Button) findViewById(R.id.btn_ok);

        txv_MerchantID.setText("MerchantID = " + getResources().getString(R.string.MID));
        txv_TradeToken.setText("TradeToken = " + getResources().getString(R.string.TradeToken));
        txv_redirectURL.setText("redirectURL = " + redirectURL);


        final OMobiPay oMobiPay = new OMobiPay(
                getResources().getString(R.string.MID),
                getResources().getString(R.string.APPID));

        oMobiPay.setAppEnvironment(OMobiPay.OPAY_STAGE);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                "opay://checkout?
// MerchantID=1006089&
// Version=2&
// inAppWebView=1&
// APPID=9000010303&
// useJSCallback=1&
// TradeToken=7558067F54F34B8180FD05F1526294EB&
// jsCallbackFuncName"

                try{
                    Uri uri = Uri.parse(oMobiPay.checkoutWithTradeToken
                            (getResources().getString(R.string.TradeToken), redirectURL));
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);
                    finish();

                } catch (ActivityNotFoundException e) {
                    /*
                    * 如果沒裝APP,導向GooglePlay下載頁
                    * */
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.allpay.tw" )));

                }


            }
        });

    }

}
