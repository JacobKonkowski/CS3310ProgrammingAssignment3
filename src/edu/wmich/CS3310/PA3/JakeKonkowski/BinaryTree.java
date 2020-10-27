package edu.wmich.CS3310.PA3.JakeKonkowski;

import java.util.Stack;

//We need T extends Comparable<T> to compare the Node data values
public class BinaryTree<T extends Comparable<T>> implements ITree<T> {
	
	INode<T> root;
	
	public BinaryTree() {
		
	}
	
	public BinaryTree(INode<T> root) {
		this.root = root;
	}
	
	public BinaryTree(T[] array) {
		if (array.length == 0) {
			return;
		}
		
		this.root = new Node<T>(array[0]);
	}

	@Override
	public void setRoot(INode<T> root) {
		this.root = root;
	}

	@Override
	public INode<T> getRoot() {
		return this.root;
	}

	@Override
	public void preorder() {
		
		//Fail fast
		if (this.root == null) {
			return;
		}
		
		//Push root node to empty stack
		Stack<INode<T>> stack = new Stack<INode<T>>();
		stack.push(this.root);
		
		//Print node, push the right child, push the left child
		while(!stack.empty()) {
			INode<T> node = stack.peek();
			System.out.print(node.getData() + " ");
			stack.pop();
			
			if (node.getRightChild() != null) {
				stack.push(node.getRightChild());
			}
			
			if (node.getLeftChild() != null) {
				stack.push(node.getLeftChild());
			}
		}
		
		//New line
		System.out.println("");
	}

	@Override
	public void inorder() {
		
		if (this.root == null) {
			return;
		}
		
		Stack<INode<T>> stack = new Stack<INode<T>>();
		INode<T> node = root;

		while (!stack.empty() || node != null) {
			
			//If current node is not null, push it to the stack and move to its left child
			if (node != null) {
				stack.push(node);
				node = node.getLeftChild();
			} else {
				//Else if node is null, we pop an element from stack,
				//Print the data and set node to its right child
				node = stack.pop();
				System.out.print(node.getData() + " ");

				node = node.getRightChild();
			}
		}
		
		//New line
		System.out.println("");
	}

	@Override
	public void postorder() {
		if (this.root == null) {
			return;
		}
		
		Stack<INode<T>> stack1 = new Stack<INode<T>>();
		Stack<INode<T>> stack2 = new Stack<INode<T>>();

		stack1.push(this.root);
		
		while(!stack1.isEmpty()) {
			//Pop from stack 1 and push to stack 2
			INode<T> tempNode = stack1.pop();
			stack2.push(tempNode);
			
			//Push the children of the tempNode to to stack1
			if (tempNode.getLeftChild() != null) {
				stack1.push(tempNode.getLeftChild());
			}
			
			if (tempNode.getRightChild() != null) {
				stack1.push(tempNode.getRightChild());
			}
		}
		
		//Print everything in stack 2
		while(!stack2.isEmpty()) {
			INode<T> tempNode = stack2.pop();
			System.out.print(tempNode.getData() + " ");
		}
		
		//New line
		System.out.println("");
	}

	@Override
	public T search(final INode<T> root, final T data) {
		
		//Because of the new project requirements I converted the inorder traversal method
		//To the search method for a regular binary tree
		
		if (this.root == null) {
			return null;
		}
		
		Stack<INode<T>> stack = new Stack<INode<T>>();
		INode<T> node = root;

		while (!stack.empty() || node != null) {
			
			//If current node is not null, push it to the stack and move to its left child
			if (node != null) {
				stack.push(node);
				node = node.getLeftChild();
			} else {
				//Else if node is null, we pop an element from stack,
				//Print the data and set node to its right child
				node = stack.pop();
				System.out.print(node.getData() + " ");

				node = node.getRightChild();
			}
		}
		
		while (!stack.isEmpty()) {
			if (stack.peek().getData().equals(data)) {
				return stack.peek().getData();
			} else {
				stack.pop();
			}
		}

		return null;
		
//		INode<T> node = root;
//		
//		//Move throughout the binary tree if we don't
//		//have what we want
//		while (node != null && node.getData() != data) {
//			//This method returning positive means the node is greater than the data
//			//If it returns negative, the node is less than the data
//			if (node.compareTo(data) < 0) {
//				node = node.getRightChild();
//			} else {
//				node = node.getLeftChild();
//			}
//		}
//		
//		//Return the data
//		if (node == null) {
//			return null;
//		} else {
//			return node.getData();
//		}
	}

	@Override
	public INode<T> getMax(INode<T> root) {
		INode<T> node = root;
		
		//Get the right most node;
		while (node.getRightChild() != null) {
			node = node.getRightChild();
		}
		
		return node;
	}

	@Override
	public INode<T> getMin(INode<T> root) {
		INode<T> node = root;
		
		//Get the left most node
		while (node.getLeftChild() != null) {
			node = node.getLeftChild();
		}
		
		return node;
	}
	
}
