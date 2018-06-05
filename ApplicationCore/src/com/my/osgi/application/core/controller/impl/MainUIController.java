package com.my.osgi.application.core.controller.impl;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.my.osgi.application.core.controller.IMainUIController;
import com.my.osgi.application.core.view.IMainUI;
import com.my.osgi.application.core.view.impl.MainUI;

public class MainUIController implements IMainUIController{

	private IMainUI mainUI;

	@Override
	public void initUI() {
		mainUI = new MainUI();
		mainUI.initUI();
	}

	@Override
	public void showMainPanel() {
		mainUI.showMainPanel();
	}

	@Override
	public void addToolBar(JToolBar toolBar) {
		mainUI.addToolBar(toolBar);
		
	}

	@Override
	public void addStatusBar(JPanel statusPanel) {
		mainUI.addStatusBar(statusPanel);
		
	}

	@Override
	public void addLeftPanel(JPanel leftPanel) {
		mainUI.addLeftPanel(leftPanel);
		
	}

	@Override
	public void addCenterPanel(JPanel centerPanel) {
		mainUI.addCenterPanel(centerPanel);
		
	}

	@Override
	public void addRightPanel(JPanel rightPanel) {
		mainUI.addRightPanel(rightPanel);
		
	}
	
}
