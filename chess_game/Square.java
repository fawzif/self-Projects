package chess_game;

public class Square {
private Color c;
private byte hor,vert;
private Piece p;

public Square(byte hor,byte vert, Color col) {
	this.hor=hor;
	this.vert=vert;
	this.c=col;
}

public byte getHor() {
	return hor;
}


public byte getVert() {
	return vert;
}


public Piece getPiece() {
	return p;
}

public void setPiece(Piece p) {
	this.p = p;
}

public Color getColor() {
	return c;
}

public String toString() {
	return "Coor: "+hor+""+vert+". Color: "+c;
}

}
