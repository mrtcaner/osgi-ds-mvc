package com.my.osgi.application.statusbar.controller;

import javax.swing.JPanel;

public interface IStatusBarUIController {

	JPanel getStatusBar();

	void printMessageToStatusBar(String message);

}
