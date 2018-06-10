package com.my.osgi.application.toolbar.controller.view;


public interface IToolBarUI {
	
	String PREVIOUS = "previous";
	String UP = "up";
	String NEXT = "next";
	String SOMETHING_ELSE = "other";
	String TEXT_ENTERED = "text";
	
	String NEW_LINE = "\n";

	void initToolBar();
	
}
