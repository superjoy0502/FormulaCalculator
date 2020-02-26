package com.github.superjoy0502.formulacalculator;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.github.superjoy0502.formulacalculator.CalculatorLib;

public class Calculator {

	public static JFrame f = new JFrame("Result");;
	static String o = JOptionPane.showInputDialog("Enter Calculation (V, I, R):");

	public static CalculatorLib li = new CalculatorLib();

	public static void main(String[] args) {
		String displayString = "";

		JLabel label1 = new JLabel("");

		if (o.equalsIgnoreCase("V")) {
			double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Amperage:"));
			double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
			li.answer = li.Multiply(a, b);
			li.unit = "V";
		}
		else if (o.equalsIgnoreCase("I")) {
			double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
			double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
			li.answer = li.Divide(a, b);
			li.unit = "A";
		}
		else if (o.equalsIgnoreCase("R")) {
			double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
			double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Amperage:"));
			li.answer = li.Divide(a, b);
			li.unit = "Ω";
		}
		else {
			return;
		}
		displayString = "Answer: " + li.answer + li.unit;
		label1.setText(displayString);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.CENTER);
		Font font = new Font("Roboto", Font.PLAIN, 48);
		label1.setFont(font);
		label1.setOpaque(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((dim.width/3-f.getSize().width/2), (dim.height/4-f.getSize().height/2));
		f.setSize(600, 500);
		f.add(label1);
		f.setVisible(true);
		
	}

}
