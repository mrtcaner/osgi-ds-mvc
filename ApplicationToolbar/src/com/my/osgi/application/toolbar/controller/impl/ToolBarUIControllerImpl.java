package com.my.osgi.application.toolbar.controller.impl;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;

import org.osgi.service.event.Event;

import com.my.osgi.application.common.util.ApplicationEvents;
import com.my.osgi.application.toolbar.controller.IToolBarUIController;
import com.my.osgi.application.toolbar.controller.view.IToolBarUI;
import com.my.osgi.application.toolbar.controller.view.impl.ToolBarUIImpl;
import com.my.osgi.application.toolbar.services.impl.ToolBarServiceImpl;

public class ToolBarUIControllerImpl implements IToolBarUIController{
	
	private IToolBarUI toolBarUI;

	@Override
	public JToolBar getToolBar() {
		// TODO Auto-generated method stub
		if(toolBarUI == null){
			toolBarUI = new ToolBarUIImpl(this);
			toolBarUI.initToolBar();	
		}
		
		return (JToolBar) toolBarUI;
	}
	
	public class NavButtonActionHandler extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
	        String description = null;
	 
	        // Handle each button.
	        if (IToolBarUI.PREVIOUS.equals(cmd)) { //first button clicked
	            description = "taken you to the previous <something>.";
	        } else if (IToolBarUI.UP.equals(cmd)) { // second button clicked
	            description = "taken you up one level to <something>.";
	        } else if (IToolBarUI.NEXT.equals(cmd)) { // third button clicked
	            description = "taken you to the next <something>.";
	        } else if (IToolBarUI.SOMETHING_ELSE.equals(cmd)) { // fourth button clicked
	            description = "done something else.";
	        }

	        Map<String,String> eventMap = new HashMap<>();
	        eventMap.put("message", description);
	        Event toolBarEvent = new Event(ApplicationEvents.APP_STATUS_PRINT_EVENT, eventMap);
	        ToolBarServiceImpl.eventAdmin.postEvent(toolBarEvent);
		}
		
	}

}
