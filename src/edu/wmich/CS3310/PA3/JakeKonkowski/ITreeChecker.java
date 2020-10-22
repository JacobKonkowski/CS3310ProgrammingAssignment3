package edu.wmich.CS3310.PA3.JakeKonkowski;
public interface ITreeChecker<T extends Comparable<T>> {
	
    boolean isMirror(ITree<T> root1, ITree<T> root2); // check if two trees are mirror 
    												  // images
	boolean isSame(ITree<T> root1, ITree<T> root2);  // check if two trees are identical
}
