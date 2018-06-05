package com.my.osgi.application.core.controller;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public interface IMainUIController {
	
	void initUI();
	
	void showMainPanel();
	
	void addToolBar(JToolBar toolBar);
	
	void addStatusBar(JPanel statusPanel);
	
	void addLeftPanel(JPanel leftPanel);
	
	void addCenterPanel(JPanel centerPanel);
	
	void addRightPanel(JPanel rightPanel);

}
