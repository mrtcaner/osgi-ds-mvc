package com.my.osgi.application.statusbar.controller.view.impl;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.my.osgi.application.statusbar.controller.impl.StatusBarUIControllerImpl;
import com.my.osgi.application.statusbar.controller.view.IStatusBarUI;
import com.my.osgi.application.statusbar.services.impl.StatusBarServiceImpl;

public class StatusBarUIImpl extends JPanel implements IStatusBarUI {

	private StatusBarUIControllerImpl statusBarUIController;
	
	private JLabel statusLabel; 
	
	public StatusBarUIImpl(StatusBarUIControllerImpl statusBarUIController){
		this.statusBarUIController = statusBarUIController;
	}

	@Override
	public void initStatusBar() {
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		statusLabel = new JLabel(StatusBarServiceImpl.configurationService.getText("ready"));
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(statusLabel);
	}

	@Override
	public void printMessageToStatusBar(String message) {
		statusLabel.setText(message);	
	}

	
}
