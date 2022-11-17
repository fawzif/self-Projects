package chess_game;

public class Set {
private Piece k,q,b1,b2,kn1,kn2,r1,r2,p1,p2,p3,p4,p5,p6,p7,p8;
private Color col;
public Set(Color c) {
	col=c;
	k=new King(c);
	q=new Queen(c);
	b1=new Bishop(c);
	b2=new Bishop(c);
	kn1=new Knight(c);
	kn2=new Knight(c);
	r1=new Rook(c);
	r2=new Rook(c);
	p1=new Pawn(c);
	p2=new Pawn(c);
	p3=new Pawn(c);
	p4=new Pawn(c);
	p5=new Pawn(c);
	p6=new Pawn(c);
	p7=new Pawn(c);
	p8=new Pawn(c);
}

public Color getColor() {
	return col;
}

public Piece getK() {
	return k;
}

public Piece getQ() {
	return q;
}

public Piece getB1() {
	return b1;
}

public Piece getB2() {
	return b2;
}

public Piece getKn1() {
	return kn1;
}

public Piece getKn2() {
	return kn2;
}

public Piece getR1() {
	return r1;
}

public Piece getR2() {
	return r2;
}

public Piece getP1() {
	return p1;
}

public Piece getP2() {
	return p2;
}

public Piece getP3() {
	return p3;
}

public Piece getP4() {
	return p4;
}

public Piece getP5() {
	return p5;
}

public Piece getP6() {
	return p6;
}

public Piece getP7() {
	return p7;
}

public Piece getP8() {
	return p8;
}

}
