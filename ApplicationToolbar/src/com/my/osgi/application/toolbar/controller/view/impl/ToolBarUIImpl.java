package com.my.osgi.application.toolbar.controller.view.impl;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.my.osgi.application.toolbar.controller.impl.ToolBarUIControllerImpl;
import com.my.osgi.application.toolbar.controller.view.IToolBarUI;
import com.my.osgi.application.toolbar.services.impl.ToolBarServiceImpl;

public class ToolBarUIImpl extends JToolBar implements IToolBarUI {

	private ToolBarUIControllerImpl toolBarUIController;
	
	protected JTextArea textArea;
	
	public ToolBarUIImpl(ToolBarUIControllerImpl toolBarUIController){
		this.toolBarUIController = toolBarUIController;
	}

	@Override
	public void initToolBar() {
		addButtons();
		setFloatable(false);
		setRollover(true);
	}

	protected JButton makeNavigationButton(String imageName, String actionCommand, String toolTipText, String altText) {
		// Look for the image.
		String imgLocation = "./resources/icons/" + imageName + ".gif";
		URL imageURL = ToolBarUIImpl.class.getResource(imgLocation);

		// Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(toolBarUIController.new NavButtonActionHandler());

		ImageIcon imageIcon = new ImageIcon("./resources/icons/"+imageName + ".gif", altText);
		
		if (imageIcon == null) { // image found
			button.setText(altText);
			System.err.println(ToolBarServiceImpl.configurationService.getText("resource.not.found") + ": " + imgLocation);
		}else{
			button.setIcon(imageIcon);	
		}
		
		return button;
	}

	protected void addButtons() {
		JButton button = null;

		// first button
		button = makeNavigationButton("previous", IToolBarUI.PREVIOUS, ToolBarServiceImpl.configurationService.getText("tooltip.previous"), "Previous");
		add(button);

		// second button
		button = makeNavigationButton("up", IToolBarUI.UP, ToolBarServiceImpl.configurationService.getText("tooltip.up"), "Up");
		add(button);

		// third button
		button = makeNavigationButton("next", IToolBarUI.NEXT, ToolBarServiceImpl.configurationService.getText("tooltip.next"), "Next");
		add(button);

		// separator
		addSeparator();

		// fourth button
		button = new JButton(ToolBarServiceImpl.configurationService.getText("another.button"));
		button.setActionCommand(SOMETHING_ELSE);
		button.setToolTipText(ToolBarServiceImpl.configurationService.getText("tooltip.another.button"));
		button.addActionListener(toolBarUIController.new NavButtonActionHandler());
		add(button);
	}

}
