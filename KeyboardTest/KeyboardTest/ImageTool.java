

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;

public class ImageTool {

	// 设置Graphics2D抗锯齿,具体请查看RenderingHints类的API  
	public static void setAntiAliasing(Graphics2D g2d) {  
		setRenderingHint(g2d, RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
	}  

	public static void setRenderingHint(Graphics2D g2d, Key key, Object value) {  
		if (g2d.getRenderingHints() == null) {  
			g2d.setRenderingHints(new RenderingHints(key, value));  
		} else {  
			g2d.setRenderingHint(key, value);  
		}  
	}  

	// 绘制圆角  
	public static void drawRoundRect(Graphics2D g2d, int width, int height, int r, Paint anglePaint, Paint[] borderPaints) {  
		clearAngle(g2d, anglePaint, width, height, r);// 清除角落  
		drawMultiBorder(g2d, width, height, r, anglePaint, borderPaints);// 画边框  
	}  

	// 清除角落  
	public static void clearAngle(Graphics2D g2d, Paint anglePaint, int width, int height, int r) {  
		setAntiAliasing(g2d);  
		Composite oldComposite = g2d.getComposite();  

		if (anglePaint == null) {  
			g2d.setComposite(AlphaComposite.Clear);// 设置Composite为清空  
		} else {  
			g2d.setPaint(anglePaint);  
		}  

		int npoints = 5;// 5点定位一个角落轨迹  
		// 左上角  
		int[] xpoints1 = { r, 0, 0, r / 4, r / 2 };  
		int[] ypoints1 = { 0, 0, r, r / 2, r / 4 };  
		Polygon polygon = new Polygon(xpoints1, ypoints1, npoints);  
		g2d.fillPolygon(polygon);  
		// 右上角  
		int[] xpoints2 = { width - r, width, width, width - r / 4, width - (r / 2) };  
		int[] ypoints2 = ypoints1;  
		polygon = new Polygon(xpoints2, ypoints2, npoints);  
		g2d.fillPolygon(polygon);  
		// 右下角  
		int[] xpoints3 = xpoints2;  
		int[] ypoints3 = { height, height, height - r, height - (r / 2), height - r / 4 };  
		polygon = new Polygon(xpoints3, ypoints3, npoints);  
		g2d.fillPolygon(polygon);  
		// 左下角  
		int[] xpoints4 = xpoints1;  
		int[] ypoints4 = ypoints3;  
		polygon = new Polygon(xpoints4, ypoints4, npoints);  
		g2d.fillPolygon(polygon);  
		// 还原Composite  
		g2d.setComposite(oldComposite);  
	}  

	// 绘制有层次感的边框  
	public static void drawMultiBorder(Graphics2D g2d, int width, int height, int r, Paint anglePaint, Paint[] borderPaints) {  
		setAntiAliasing(g2d);  

		int roundx = r * 2;  
		int roundy = roundx;  
		int grow = 2;  
		int x = 0;  
		int y = 0;  
		int w = width;  
		int h = height;  

		// 从外层往内层开始画  
		for (int i = 0; i < borderPaints.length; i++, x++, y++, w -= grow, h -= grow) {  
			g2d.setPaint(borderPaints[i]);  
			if (r > 0) {  
				g2d.drawRoundRect(x, y, w - 1, h - 1, roundx, roundy);  
			} else {  
				g2d.drawRect(x, y, w - 1, h - 1);  
			}  
		}  
	}  
}
