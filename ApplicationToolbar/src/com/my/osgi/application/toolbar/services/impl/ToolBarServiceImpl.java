package com.my.osgi.application.toolbar.services.impl;

import javax.swing.JToolBar;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.my.osgi.application.toolbar.services.IToolBarService;

@Component
public class ToolBarServiceImpl implements IToolBarService{
	
	@Activate
	void activate(){
		System.out.println("ToolBarServiceImpl activated!");
	}
	
	@Deactivate
	void deactivate(){
		System.out.println("ToolBarServiceImpl deactivated!");
	}

	@Override
	public JToolBar createToolBar() {
		// TODO Auto-generated method stub
		return null;
	}

}
