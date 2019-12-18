package com.util.tool;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class WindowUtil {
	private static Toolkit tool = Toolkit.getDefaultToolkit();
	private static Dimension screenSize = tool.getScreenSize();

	public static Point setLocation(Dimension d) {
		int x = (int) ((screenSize.getWidth() - d.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - d.getHeight()) / 2);

		return new Point(x, y);
	}
	
	public static Dimension getAllScreen() {
		return screenSize;
	}
}
