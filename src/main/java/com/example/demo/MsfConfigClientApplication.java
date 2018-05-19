package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MsfConfigClientApplication {
	
	@Value("${messege.local}")
	String localMessege;
	@Value("${messege.remote.specific}")
	String remoteSpecific;
	@Value("${messege.remote.generic}")
	String remoteGeneric;

	public String getRemoteSpecific() {
		return remoteSpecific;
	}


	public void setRemoteSpecific(String remoteSpecific) {
		this.remoteSpecific = remoteSpecific;
	}


	public String getRemoteGeneric() {
		return remoteGeneric;
	}


	public void setRemoteGeneric(String remoteGeneric) {
		this.remoteGeneric = remoteGeneric;
	}


	public String getLocalMessege() {
		return localMessege;
	}


	public void setLocalMessege(String localMessege) {
		this.localMessege = localMessege;
	}


	@RequestMapping("/")
	String getTheApplicationName() {
		return "Local msg:"+this.getLocalMessege()+""
				+ "\n Remote generic msg:"+this.getRemoteGeneric()+""
				+ "\n Remote specific msg:"+this.getRemoteSpecific()+""
				+ " taking the server from the remote";
	}


	public static void main(String[] args) {
		SpringApplication.run(MsfConfigClientApplication.class, args);
	}
}
