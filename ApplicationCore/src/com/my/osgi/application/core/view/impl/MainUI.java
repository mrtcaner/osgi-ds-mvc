package com.my.osgi.application.core.view.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import com.my.osgi.application.core.view.IMainUI;

public class MainUI extends JFrame implements IMainUI {

	private JTextArea toolBarActionTextArea;

	@Override
	public void initUI() {
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void showMainPanel() {
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void addStatusBar(JPanel statusPanel) {
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
		this.getContentPane().add(statusPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void addToolBar(JToolBar toolBar) {
		// Create the text area used for output. Request
		// enough space for 5 rows and 30 columns.
		toolBarActionTextArea = new JTextArea(5, 30);
		toolBarActionTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(toolBarActionTextArea);

		// Lay out the main panel.
		add(toolBar, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

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
