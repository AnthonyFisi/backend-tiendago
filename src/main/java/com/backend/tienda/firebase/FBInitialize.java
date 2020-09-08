package com.backend.tienda.firebase;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FBInitialize {

	@PostConstruct
	private  void initDB() {
		try {

			InputStream serviceAccount=this.getClass().getClassLoader()
					.getResourceAsStream("./yego-22b59-firebase-adminsdk-zdchs-523c599d14.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://yego-22b59.firebaseio.com")
					.build();

			if(FirebaseApp.getApps().isEmpty()) {
				
				FirebaseApp.initializeApp(options);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Firestore getFirebase()
	{
		return FirestoreClient.getFirestore();
	}
}
