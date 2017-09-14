package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;

import java.io.InputStream;

@SpringBootApplication
public class DemoApplication {

	static String JSON = "C:\\Users\\ryohei_ohashi\\Documents\\JavaTightChatWebApp-614125612574.json" + "";
	static String URL = "https://JavaTightChatWebApp.firebaseio.com/";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);

		InputStream json = new FileInputStream(JSON);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setServiceAccount(json)
				.setDatabaseUrl(URL)
				.build();

		FirebaseApp.initializeApp(options);

		DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

		reference.child("ryohei_ohashi-send1").setValue("こんにちは");
	}
}
