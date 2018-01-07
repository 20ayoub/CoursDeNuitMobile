package pi.com.coursdenuitmobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import pi.com.coursdenuitmobile.R;
import pi.com.coursdenuitmobile.entities.User;

public class MainActivity extends AppCompatActivity {
    Button btnCallRestApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCallRestApi =findViewById(R.id.btnCallRestApi);
        btnCallRestApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                new HttpReqTask().execute();


            }
        });
    }

    private class HttpReqTask extends AsyncTask<Void,Void,User> {

        @Override
        protected User doInBackground(Void... params) {

            try {
                String apiUrl="http://cc846dcc.ngrok.io/users/";
                RestTemplate restTemplate= new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                User user= restTemplate.getForObject(apiUrl,User.class);
                return user;
            }catch (Exception e){
                Log.e("",e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);

            Log.i("User: ","###############");
            Log.i("user.id",String.valueOf(user.getId()));
            Log.i("user.name",String.valueOf(user.getName()));


        }
    }
}
