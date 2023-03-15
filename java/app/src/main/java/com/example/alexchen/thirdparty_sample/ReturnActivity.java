package com.example.alexchen.thirdparty_sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReturnActivity extends AppCompatActivity {

    private String TAG_RETURN_CODE = "RtnCode";

    private String TAG_RERTURN_MESSAGE = "RtnMsg";

    private String TAG_RERTURN_URL = "redirectURL";

    private String TAG_RERTURN_TOKEN = "TradeToken";

    private String TAG_RERTURN_DATA = "Data";

    private String rtnCode;

    private String rtnMsg,rtnURL,rtnToken,rtnData;

    private TextView txv_RtnData;

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);

        txv_RtnData = (TextView) findViewById(R.id.txv_RtnData);
        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ReturnActivity.this,MainActivity.class);
                startActivity(it);
                finish();
            }
        });

        Uri uri_message_data = getIntent().getData();
        if(uri_message_data != null) {
            rtnCode = uri_message_data.getQueryParameter(TAG_RETURN_CODE);
            rtnMsg = uri_message_data.getQueryParameter(TAG_RERTURN_MESSAGE);
            rtnURL = uri_message_data.getQueryParameter(TAG_RERTURN_URL);
            rtnToken = uri_message_data.getQueryParameter(TAG_RERTURN_TOKEN);
            rtnData = uri_message_data.getQueryParameter(TAG_RERTURN_DATA);

            txv_RtnData.setText("redirectURL = " + rtnURL + "\nRtnCode = " + rtnCode
                    +"\nRtnMsg = " + rtnMsg + "\nTradeToken = " + rtnToken + "\nData = " + rtnData);
        }
    }
}
