package edu.wmich.CS3310.PA3.JakeKonkowski;
public interface ITree<T extends Comparable<T>> {
	void setRoot(INode<T> root);
	INode<T> getRoot();
	void preorder();	// print tree in a preorder traversal
	void inorder();	    // print tree in an inorder traversal
	void postorder();	    // print tree in a postorder traversal
	INode<T> insert(INode<T> root, T data);     // insert data into tree
	INode<T> remove(INode<T> root, T data); //search/remove node with data
	T search(INode<T> root, T data); //search and return data if it exists
	INode<T> getMax(INode<T> root); //return node with maximum value of subtree
	INode<T> getMin(INode<T> root); //return node with minimum value of subtree
}
