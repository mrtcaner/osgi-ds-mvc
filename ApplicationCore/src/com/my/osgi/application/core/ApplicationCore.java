package com.my.osgi.application.core;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(immediate=true)
public class ApplicationCore {
	
	@Activate
	void activate() {
		System.out.println("ApplicationCore activated!");
	}

}
