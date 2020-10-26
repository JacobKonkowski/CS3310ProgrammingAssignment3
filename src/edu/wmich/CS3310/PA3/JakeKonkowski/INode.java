package edu.wmich.CS3310.PA3.JakeKonkowski;
public interface INode<T extends Comparable<T>> {

	//Getter of node data
	T getData();

	//Setter of node data
	void setData(T data);

    INode<T> getLeftChild();

	void setLeftChild(INode<T> leftChild);

	INode<T> getRightChild();

	void setRightChild(INode<T> rightChild);
	
//	public int compareTo(T data2);
//	
//	public int compareTo(INode<T> node);
    
}
