package edu.wmich.CS3310.PA3.JakeKonkowski;

//We need T extends Comparable<T> to compare the Node data values
public class Node<T extends Comparable<T>> implements INode<T> {
	
	T data;
	INode<T> leftChild;
	INode<T> rightChild;
	
	public Node(T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public INode<T> getLeftChild() {
		return this.leftChild;
	}

	@Override
	public void setLeftChild(INode<T> leftChild) {
		this.leftChild = leftChild;
	}

	@Override
	public INode<T> getRightChild() {
		return this.rightChild;
	}

	@Override
	public void setRightChild(INode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
//	public int compareTo(T data2) {
//		return this.data.compareTo(data2);
//	}
//	
//	public int compareTo(INode<T> node) {
//		return this.data.compareTo(node.getData());
//	}

}
