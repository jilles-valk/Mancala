package nl.sogyo.mancala;

public class Bowl extends AbstractBowl{

	public Bowl(AbstractBowl first, AbstractBowl next, int size) {
		super(first, next, size);
	}
	
	public Bowl(int size) {
		new Bowl(new Bowl(), new Bowl(), size);
	}
	
	public Bowl() {
		super();
	}
	
//	public Bowl(int size) {
//		super(this, this, size - 1);
//	}

}
