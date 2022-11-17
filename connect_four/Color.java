package connect_four;

public class Color {
private int red,green,blue;
public final static Color RED=new Color(255,0,0);
public final static Color YELLOW=new Color(255,255,0);
public Color(int r,int g,int b) {
	red=r;
	green=g;
	blue=b;
}
public String toString() {
	if(this==Color.RED)
		return "RED";
	else if(this==Color.YELLOW)
		return "YELLOW";
	return this.toString();
}
}
