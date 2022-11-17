package chess_game;

public class Board {
	private int n=8;
	private byte[] hor = {'A','B','C','D','E','F','G','H'};
private Square[][] sqr=new Square[n][n];

public Board(Set s1,Set s2) {
	int k=0;
	for(int i=0;i<n;i++) {
		for(byte j=0;j<n;j++) {
			if(k%2==0)
				sqr[i][j]=new Square(hor[i],j,Color.BLACK);
			else
				sqr[i][j]=new Square(hor[i],j,Color.WHITE);
			k++;
		}
	}
	if(s1.getColor().equals(Color.WHITE)) {
		sqr[0][0].setPiece(s1.getR1());
		sqr[1][0].setPiece(s1.getKn1());
		sqr[2][0].setPiece(s1.getB1());
		sqr[3][0].setPiece(s1.getQ());
		sqr[4][0].setPiece(s1.getK());
		sqr[5][0].setPiece(s1.getB2());
		sqr[6][0].setPiece(s1.getKn2());
		sqr[7][0].setPiece(s1.getR2());
		sqr[0][1].setPiece(s1.getP1());
		sqr[1][1].setPiece(s1.getP2());
		sqr[2][1].setPiece(s1.getP3());
		sqr[3][1].setPiece(s1.getP4());
		sqr[4][1].setPiece(s1.getP5());
		sqr[5][1].setPiece(s1.getP6());
		sqr[6][1].setPiece(s1.getP7());
		sqr[7][1].setPiece(s1.getP8());
		
		sqr[0][7].setPiece(s2.getR1());
		sqr[1][7].setPiece(s2.getKn1());
		sqr[2][7].setPiece(s2.getB1());
		sqr[3][7].setPiece(s2.getQ());
		sqr[4][7].setPiece(s2.getK());
		sqr[5][7].setPiece(s2.getB2());
		sqr[6][7].setPiece(s2.getKn2());
		sqr[7][7].setPiece(s2.getR2());
		sqr[0][6].setPiece(s2.getP1());
		sqr[1][6].setPiece(s2.getP2());
		sqr[2][6].setPiece(s2.getP3());
		sqr[3][6].setPiece(s2.getP4());
		sqr[4][6].setPiece(s2.getP5());
		sqr[5][6].setPiece(s2.getP6());
		sqr[6][6].setPiece(s2.getP7());
		sqr[7][6].setPiece(s2.getP8());
	}
	else {
		sqr[0][0].setPiece(s2.getR1());
		sqr[1][0].setPiece(s2.getKn1());
		sqr[2][0].setPiece(s2.getB1());
		sqr[3][0].setPiece(s2.getQ());
		sqr[4][0].setPiece(s2.getK());
		sqr[5][0].setPiece(s2.getB2());
		sqr[6][0].setPiece(s2.getKn2());
		sqr[7][0].setPiece(s2.getR2());
		sqr[0][1].setPiece(s2.getP1());
		sqr[1][1].setPiece(s2.getP2());
		sqr[2][1].setPiece(s2.getP3());
		sqr[3][1].setPiece(s2.getP4());
		sqr[4][1].setPiece(s2.getP5());
		sqr[5][1].setPiece(s2.getP6());
		sqr[6][1].setPiece(s2.getP7());
		sqr[7][1].setPiece(s2.getP8());
		
		sqr[0][7].setPiece(s1.getR1());
		sqr[1][7].setPiece(s1.getKn1());
		sqr[2][7].setPiece(s1.getB1());
		sqr[3][7].setPiece(s1.getQ());
		sqr[4][7].setPiece(s1.getK());
		sqr[5][7].setPiece(s1.getB2());
		sqr[6][7].setPiece(s1.getKn2());
		sqr[7][7].setPiece(s1.getR2());
		sqr[0][6].setPiece(s1.getP1());
		sqr[1][6].setPiece(s1.getP2());
		sqr[2][6].setPiece(s1.getP3());
		sqr[3][6].setPiece(s1.getP4());
		sqr[4][6].setPiece(s1.getP5());
		sqr[5][6].setPiece(s1.getP6());
		sqr[6][6].setPiece(s1.getP7());
		sqr[7][6].setPiece(s1.getP8());
	}
	
}

public Square getSquare(int a,int b) {
	return sqr[a][b];
}
}
