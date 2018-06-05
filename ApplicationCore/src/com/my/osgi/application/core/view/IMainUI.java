package com.my.osgi.application.core.view;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public interface IMainUI {
	
	void initUI();
	
	void addToolBar(JToolBar toolBar);
	
	void addStatusBar(JPanel statusPanel);
	
	void addLeftPanel(JPanel leftPanel);
	
	void addCenterPanel(JPanel centerPanel);
	
	void addRightPanel(JPanel rightPanel);
	
	void showMainPanel();
	
	void refresh();
	
	void toFront();
	
}
