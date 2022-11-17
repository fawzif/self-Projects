package chess_game;

public class Color {
private int red, blue, green;
static final Color WHITE=new Color(0,0,0);
static final Color BLACK=new Color(255,255,255);
public Color(int r, int b, int g) {
	red=r;
	blue=b;
	green=g;
}
public boolean equals (Color c) {
	return red==c.red && blue==c.blue && green==c.green;
}

public String toString() {
	String c=red+", "+blue+", "+"green";
	if(this.equals(BLACK))
		c="Black";
	else if(this.equals(WHITE))
		c="White";
	return c;
}
}
