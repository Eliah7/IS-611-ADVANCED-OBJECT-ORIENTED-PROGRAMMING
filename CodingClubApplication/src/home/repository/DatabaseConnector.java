package home.repository;


import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnector {
    Firestore db;

    DatabaseConnector(){
        try{
            this.db = this.connectToDb();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private Firestore connectToDb() throws Exception{
            InputStream serviceAccount = new FileInputStream("src/home/assets/codingclub-27658-16a6650d70e4.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://codingclub-27658-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();


            return db;


    }
}
