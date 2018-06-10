package com.my.osgi.application.statusbar.services.impl;

import javax.swing.JPanel;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import com.my.osgi.application.common.util.ApplicationEvents;
import com.my.osgi.application.common.util.IApplicationConfigurationService;
import com.my.osgi.application.statusbar.controller.IStatusBarUIController;
import com.my.osgi.application.statusbar.controller.impl.StatusBarUIControllerImpl;
import com.my.osgi.application.statusbar.services.IStatusBarService;

@Component(property = {
		org.osgi.service.event.EventConstants.EVENT_TOPIC + "=" + ApplicationEvents.APP_STATUS_EVENTS})
public class StatusBarServiceImpl implements IStatusBarService, EventHandler{
	
	private static final String BUNDLE_NAME = "applicationStatusBar";
	
	private IStatusBarUIController statusBarUIController;
	public static IApplicationConfigurationService configurationService;
	
	@Reference
	void setConfigurationService(IApplicationConfigurationService configurationSrvc){
		configurationService = configurationSrvc;
		configurationService.loadProperties(BUNDLE_NAME);
	}
	
	void unsetConfigurationService(IApplicationConfigurationService configurationSrvc){
		configurationService = null;
	}
	
	@Activate
	void activate(){
		System.out.println("StatusBarServiceImpl activated!");
	}
	
	@Deactivate
	void deactivate(){
		System.out.println("StatusBarServiceImpl deactivated!");
	}

	@Override
	public JPanel getStatusBar() {
		if(statusBarUIController == null){
			statusBarUIController = new StatusBarUIControllerImpl();
		}
		return statusBarUIController.getStatusBar();
	}

	@Override
	public void handleEvent(Event event) {
		if(event.getTopic().equals(ApplicationEvents.APP_STATUS_PRINT_EVENT)){
			statusBarUIController.printMessageToStatusBar(event.getProperty("message").toString());
		}
	}

}
