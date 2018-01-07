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
import pi.com.coursdenuitmobile.entities.Etudiant;
import pi.com.coursdenuitmobile.entities.Requete;
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

    private class HttpReqTask extends AsyncTask<Void,Void,List<Requete>> {

        @Override
        protected List<Requete> doInBackground(Void... params) {

            try {
                String apiUrl="http://192.168.101.1:8080/requetes";
                RestTemplate restTemplate= new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                ResponseEntity<Requete[]> utilisateur= restTemplate.getForEntity(apiUrl,Requete[].class);

                Requete[] etudiants = utilisateur.getBody();

                List<Requete> et = new ArrayList<Requete>();

                for(Requete etud : etudiants){
                    et.add(etud);
                }

                return et;
            }catch (Exception e){
                Log.e("",e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Requete> utilisateur) {
            super.onPostExecute(utilisateur);

            for(Requete etudia : utilisateur) {

                Log.i("User: ", "###############");
                Log.i("user.id", String.valueOf(etudia.getId()));
                Log.i("user.name", String.valueOf(etudia.getEtat()));

            }

        }
    }
}
