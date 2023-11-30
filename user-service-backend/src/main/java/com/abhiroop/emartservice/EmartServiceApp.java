package com.abhiroop.emartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abhiroop"})
public class EmartServiceApp {

	static {
	    
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){

	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            if (hostname.equals("ohp537.lfnet.se")) {
	                return true;
	            }
	            return false;
	        }
	    });
	}
	public static void main(String[] args) {
		SpringApplication.run(EmartServiceApp.class, args);
		System.out.println("emart-backend started");
	}
}
