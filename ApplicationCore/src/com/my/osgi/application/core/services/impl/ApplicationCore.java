package com.my.osgi.application.core.services.impl;


import org.osgi.service.component.annotations.Activate;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.my.osgi.application.core.services.IApplicationCore;

@Component(immediate=true)
public class ApplicationCore implements IApplicationCore {
	
	@Activate
	void activate() {
		System.out.println("ApplicationCore activated!");
	}
	
	@Deactivate
	void deactivate(){
		
	}

}
