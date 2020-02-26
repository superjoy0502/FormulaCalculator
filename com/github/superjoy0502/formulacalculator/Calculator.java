
// Copyright (C) 2020  superjoy0502
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

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
			li.answerString = "Voltage";
		} else if (o.equalsIgnoreCase("I")) {
			double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
			double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
			li.answer = li.Divide(a, b);
			li.unit = "A";
			li.answerString = "Amperage";
		} else if (o.equalsIgnoreCase("R")) {
			double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
			double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Amperage:"));
			li.answer = li.Divide(a, b);
			li.unit = "Ω";
			li.answerString = "Ohms";
		} else {
			return;
		}
		displayString = li.answerString + ": " + li.answer + li.unit;
		label1.setText(displayString);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.CENTER);
		Font font = new Font("Roboto", Font.PLAIN, 48);
		label1.setFont(font);
		label1.setOpaque(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((dim.width / 3 - f.getSize().width / 2), (dim.height / 4 - f.getSize().height / 2));
		f.setSize(600, 500);
		f.add(label1);
		f.setVisible(true);

	}

}
