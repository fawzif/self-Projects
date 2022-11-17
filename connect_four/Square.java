package connect_four;

public class Square {
private byte hor,vert;
private Token T;
public Square (byte h,byte v) {
	hor=h;
	vert=v;
}
public boolean isOccupied() {
	return T!=null;
}
public Token getToken() {
	return T;
}
public void setToken(Token T) {
	this.T=T;
}
public byte getHor() {
	return hor;
}
public byte getVert() {
	return vert;
}


public String toString() {
	if(T==null) {
		return " ";
	}
	if(T.getColor()==Color.RED)
		return "R";
	return "Y";
	
}
}
