package nl.sogyo.mancala;

public class Bowl extends AbstractBowl{

	public Bowl(AbstractBowl first, AbstractBowl next, int size) {
		super(first, next, size);
	}
	
	public Bowl(int size) {
		super(size);
	}
}
