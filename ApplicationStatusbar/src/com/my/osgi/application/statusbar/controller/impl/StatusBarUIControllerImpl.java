package com.my.osgi.application.statusbar.controller.impl;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.my.osgi.application.statusbar.controller.IStatusBarUIController;
import com.my.osgi.application.statusbar.controller.view.IStatusBarUI;
import com.my.osgi.application.statusbar.controller.view.impl.StatusBarUIImpl;

public class StatusBarUIControllerImpl implements IStatusBarUIController{
	
	private IStatusBarUI statusBarUI;

	@Override
	public JPanel getStatusBar() {
		if(statusBarUI == null){
			statusBarUI = new StatusBarUIImpl(this);
			statusBarUI.initStatusBar();	
		}
		
		return (JPanel) statusBarUI;
	}
	
	public class StatusBarActionHandler extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}

	@Override
	public void printMessageToStatusBar(String message) {
		statusBarUI.printMessageToStatusBar(message);
		
	}
 
}
