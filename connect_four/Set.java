package connect_four;

public class Set {
	private Color c;
	private int nbToken = 21;

	public Set(Color c) {
		this.c = c;
	}

	public Token getToken() {
		nbToken--;
		return new Token(c);
	}

	public int getNbToken() {
		return nbToken;
	}

	public Color getColor() {
		return c;
	}

}
