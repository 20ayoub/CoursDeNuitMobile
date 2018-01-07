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

    private class HttpReqTask extends AsyncTask<Void, Void, List<Etudiant>> {

        @Override
        protected List<Etudiant> doInBackground(Void... params) {

            try {
                URI url = new URI("http://0ae9b072.ngrok.io/etudiants/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<List<Etudiant>> entity = restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Etudiant>>(){});
                List<Etudiant> etudiants =entity.getBody();


                return etudiants;

            } catch (Exception e) {
                Log.e("", e.getMessage());

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Etudiant> etudiants) {
            super.onPostExecute(etudiants);
            int i=0;
            for(Etudiant etudiant:etudiants) {
                i=i++;

                Log.i("Requete: ", "###############");
                Log.i("requete.id", String.valueOf(etudiant.getEmail()));



            }

        }
    }
}
