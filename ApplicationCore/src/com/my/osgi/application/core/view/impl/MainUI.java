package com.my.osgi.application.core.view.impl;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import com.my.osgi.application.core.view.IMainUI;

public class MainUI extends JFrame implements IMainUI {

	@Override
	public void initUI() {	
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void showMainPanel() {
		System.out.println("asdasdasdasdsd");
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void addStatusBar(JPanel statusPanel) {
		this.getContentPane().add(statusPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void addToolBar(JToolBar toolBar) {
		add(toolBar, BorderLayout.PAGE_START);
		
	}

	@Override
	public void addLeftPanel(JPanel leftPanel) {
		this.getContentPane().add(leftPanel, BorderLayout.WEST);
		
	}

	@Override
	public void addCenterPanel(JPanel centerPanel) {
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
	}

	@Override
	public void addRightPanel(JPanel rightPanel) {
		this.getContentPane().add(rightPanel, BorderLayout.EAST);
		
	}

}
