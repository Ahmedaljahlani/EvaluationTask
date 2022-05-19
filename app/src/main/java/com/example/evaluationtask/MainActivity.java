package com.example.evaluationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText agentCodeEDTxt,usernameEDTxt,passwordEDTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.transparent));


        agentCodeEDTxt=findViewById(R.id.agentcode);
        usernameEDTxt=findViewById(R.id.username);
        passwordEDTxt=findViewById(R.id.password);

        Button login=findViewById(R.id.loginbtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String agentCode = agentCodeEDTxt.getText().toString();
                String username = usernameEDTxt.getText().toString();
                String password = passwordEDTxt.getText().toString();

                if (agentCode.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    if (agentCode.isEmpty()) {
                        agentCodeEDTxt.setError("required");
                    }
                    if (username.isEmpty()) {
                        usernameEDTxt.setError("required");
                    }
                    if (password.isEmpty()) {
                        passwordEDTxt.setError("required");
                    }
                    return;
                }
                password = EncryptionData.calculateRFC2104HMAC(password);

                JSONObject param = new JSONObject();
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("P_AGT_CODE", agentCode);
                    jsonObject.put("P_AGT_NO", agentCode);
                    jsonObject.put("P_APP_VER", "1.9.27%201.11.2020");
                    jsonObject.put("P_DVC_SRL", "101010");
                    jsonObject.put("P_MOB_TYP", "1");
                    jsonObject.put("P_USER_CODE", username);
                    jsonObject.put("P_USER_PASS", "oLtaG397mP9RvwQcsxKpPlGbU8s=");

                    param.put("Value", jsonObject);
                } catch (JSONException e) {

                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        "http://mapp.yemensoft.net/MTXAgentService/api/MTXAgent/CheckLogIn",
                        param, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        startActivity(new Intent(MainActivity.this,ProcessesActivity.class));
                        finish();
                        try {
                            Log.e("error",response.toString());

                            JSONObject data = response.getJSONObject("Data");
                            JSONObject result = data.getJSONObject("Result");

                            if (result.getInt("ErrNo") != 0) {
                                Toast.makeText(MainActivity.this, "Not valid", Toast.LENGTH_SHORT).show();
                            } else {
                                JSONObject login = data.getJSONObject("Login");

                                startActivity(new Intent(MainActivity.this, ProcessesActivity.class));
                                finish();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(MainActivity.this,ProcessesActivity.class);
//                        startActivity(intent);
                        Log.e("error",error.toString());
                    }
                });
                VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
            }
        });
    }
}