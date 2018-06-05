package com.my.osgi.application.core.services.impl;


import javax.swing.SwingUtilities;

import org.osgi.service.component.annotations.Activate;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.my.osgi.application.core.controller.IMainUIController;
import com.my.osgi.application.core.controller.impl.MainUIController;
import com.my.osgi.application.core.services.IApplicationCoreService;
import com.my.osgi.application.toolbar.services.IToolBarService;

@Component(immediate=true)
public class ApplicationCoreServiceImpl implements IApplicationCoreService {
	
	private IMainUIController mainUIController;
	
	private IToolBarService toolBarService;
	
	@Reference
	void setToolBarService(IToolBarService toolBarService){
		this.toolBarService = toolBarService;
	}
	
	void unsetToolBarService(IToolBarService toolBarService){
		this.toolBarService = null;
	}
	
	@Activate
	void activate() {
		System.out.println("ApplicationCore activated!");
		initUI();
	}
	
	@Deactivate
	void deactivate(){
		System.out.println("ApplicationCore deactivated!");
	}
	
	public void initUI(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainUIController = new MainUIController();
				mainUIController.initUI();
				mainUIController.addToolBar(toolBarService.createToolBar());
				mainUIController.showMainPanel();
			}
		});
	}
	
	

}
