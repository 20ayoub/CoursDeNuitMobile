package pi.com.coursdenuitmobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import pi.com.coursdenuitmobile.R;
import pi.com.coursdenuitmobile.entities.User;

public class MainActivity extends AppCompatActivity {
    Button btnCallRestApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCallRestApi = findViewById(R.id.btnCallRestApi);
        btnCallRestApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpReqTask().execute();


            }
        });
    }

    private class HttpReqTask extends AsyncTask<Void, Void, ArrayList<User>> {

        @Override
        protected ArrayList<User> doInBackground(Void... params) {

            try {
                URI url = new URI("http://b4ddce7b.ngrok.io/users/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                ResponseEntity<ArrayList<User>> entity = restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<User>>(){});
                ArrayList<User> users =entity.getBody();


                return users;

            } catch (Exception e) {
                Log.e("", e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            for(User user:users) {

                Log.i("User: ", "###############");
                Log.i("user.id", String.valueOf(user.getId()));
                Log.i("user.name", String.valueOf(user.getName()));
            }

        }
    }
}
