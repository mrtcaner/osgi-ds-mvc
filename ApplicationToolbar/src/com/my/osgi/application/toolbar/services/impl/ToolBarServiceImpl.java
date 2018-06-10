package com.my.osgi.application.toolbar.services.impl;

import javax.swing.JToolBar;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventAdmin;

import com.my.osgi.application.common.util.IApplicationConfigurationService;
import com.my.osgi.application.toolbar.controller.IToolBarUIController;
import com.my.osgi.application.toolbar.controller.impl.ToolBarUIControllerImpl;
import com.my.osgi.application.toolbar.services.IToolBarService;

@Component
public class ToolBarServiceImpl implements IToolBarService{
	
	private static final String BUNDLE_NAME = "applicationToolBar";
	
	private IToolBarUIController toolBarUIController;
	
	public static EventAdmin eventAdmin;
	public static IApplicationConfigurationService configurationService;
	
	@Reference
	void setConfigurationService(IApplicationConfigurationService configurationSrvc){
		configurationService = configurationSrvc;
		configurationService.loadProperties(BUNDLE_NAME);
	}
	
	void unsetConfigurationService(IApplicationConfigurationService configurationSrvc){
		configurationService = null;
	}
	
	@Reference
	void setEventAdmin(EventAdmin eventAdminService) {
		eventAdmin = eventAdminService;
	}

	void unsetEventAdmin(EventAdmin eventAdminService) {
		eventAdmin = eventAdminService;
	}
	
	@Activate
	void activate(){
		System.out.println("ToolBarServiceImpl activated!");
	}
	
	@Deactivate
	void deactivate(){
		System.out.println("ToolBarServiceImpl deactivated!");
	}

	@Override
	public JToolBar getToolBar() {
		if(toolBarUIController == null){
			toolBarUIController = new ToolBarUIControllerImpl();
		}
		return toolBarUIController.getToolBar();
	}

}
