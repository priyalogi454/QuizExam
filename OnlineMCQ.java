package com.App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: What does the == operator compare in Java objects?");
			radioButton[0].setText("Values");
			radioButton[1].setText("References");
			radioButton[2].setText("Hash codes");
			radioButton[3].setText("Fields");
		}
		if (current == 1) {
			label.setText("Que2: Which of the following is a valid data structure in java?");
			radioButton[0].setText("Array");
			radioButton[1].setText("List");
			radioButton[2].setText("Vector");
			radioButton[3].setText("All of these");
		}
		if (current == 2) {
			label.setText("Que3: Which of the following is not a Java features?");
			radioButton[0].setText("Dynamic");
			radioButton[1].setText("Architecture Neutral");
			radioButton[2].setText("Use of pointers");
			radioButton[3].setText("Object-oriented");
		}
		if (current == 3) {
			label.setText("Que4: _____ is used to find and fix bugs in the Java programs?");
			radioButton[0].setText("JVM");
			radioButton[1].setText("JRE");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JDB");
		}
		if (current == 4) {
			label.setText("Que5:  Which of the following for loop declaration is not valid?");
			radioButton[0].setText("for ( int i = 99; i >= 0; i / 9 )");
			radioButton[1].setText("for ( int i = 7; i <= 77; i += 7 )");
			radioButton[2].setText("for ( int i = 20; i >= 2; - -i )");
			radioButton[3].setText("for ( int i = 2; i <= 20; i = 2* i )");
		}
		if (current == 5) {
			label.setText("Que6: Which of these is a non-access modifier?");
			radioButton[0].setText("public");
			radioButton[1].setText("private");
			radioButton[2].setText("native");
			radioButton[3].setText("All of these");
		}
		if (current == 6) {
			label.setText("Que7:  Which keyword is used to inherit classes in Java?");
			radioButton[0].setText("extends");
			radioButton[1].setText("inheritance");
			radioButton[2].setText("isChild");
			radioButton[3].setText("None of these");
		}
		if (current == 7) {
			label.setText("Que8:  Which class in Java is used to take input from the user?");
			radioButton[0].setText("Scanner");
			radioButton[1].setText("Input");
			radioButton[2].setText("Applier");
			radioButton[3].setText("None of these");
		}
		if (current == 8) {
			label.setText("Que9: What does JVM stand for?");
			radioButton[0].setText("Java Version Machine");
			radioButton[1].setText("Java Virtual Mechanism");
			radioButton[2].setText("Java Verified Module");
			radioButton[3].setText("Java Virtual Machine");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is NOT a part of the JRE?");
			radioButton[0].setText("Bytecode verifier()");
			radioButton[1].setText("Classloader");
			radioButton[2].setText("Java Compiler");
			radioButton[3].setText("Java API classes");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[0].isSelected());
		if (current == 7)
			return (radioButton[0].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("OnlineExam Java MCQ (10 Questions)");
	}

}
