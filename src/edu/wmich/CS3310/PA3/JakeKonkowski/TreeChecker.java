package edu.wmich.CS3310.PA3.JakeKonkowski;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//We need T extends Comparable<T> to compare the Node data values
public class TreeChecker<T extends Comparable<T>> implements ITreeChecker<T> {

	@Override
	public boolean isMirror(ITree<T> root1, ITree<T> root2) {
		
		//Fail fast
		if (root1 == null && root2 == null) {
			return true;
		}
		//Check if one is null
		if (root1 == null || root2 == null) {
			return false;
		}
		
		//Fail fast
		if (root1.getRoot() == null && root2.getRoot() == null) {
			return true;
		}
		//Check if one is null
		if (root1.getRoot() == null || root2.getRoot() == null) {
			return false;
		}
		
		Stack<INode<T>> stack1 = new Stack<INode<T>>();
		Stack<INode<T>> stack2 = new Stack<INode<T>>();
		
		//compare the front nodes
		INode<T> node1 = root1.getRoot();
		INode<T> node2 = root2.getRoot();
		
		while (true) {
			
			//Inorder traversal of the first tree
			//Reverse Inorder traversal of the second tree
			while (node1 != null && node2 != null) {
				
				if (!node1.getData().equals(node2.getData())) {
					return false;
				}
				
				stack1.push(node1);
				stack2.push(node2);
				node1 = node1.getLeftChild();
				node2 = node2.getRightChild();
			}
			
			//Checks if one is null and the other isn't
			if (!(node1 == null && node2 == null)) {
				return false;
			}
			
			if (!stack1.isEmpty() && !stack2.isEmpty()) {
				node1 = stack1.peek();
				node2 = stack2.peek();
				
				stack1.pop();
				stack2.pop();
				
				//Right subtree
				node1 = node1.getRightChild();
				node2 = node2.getLeftChild();
			} else { //Fully traversed
				break;
			}
		}
		
		return true;
	}

	@Override
	public boolean isSame(ITree<T> root1, ITree<T> root2) {
		
		//Fail fast
		if (root1 == null && root2 == null) {
			return true;
		}
		//Check if one is null
		if (root1 == null || root2 == null) {
			return false;
		}
		
		//Fail fast
		if (root1.getRoot() == null && root2.getRoot() == null) {
			return true;
		}
		//Check if one is null
		if (root1.getRoot() == null || root2.getRoot() == null) {
			return false;
		}
		
		Queue<INode<T>> queue1 = new LinkedList<INode<T>>();
		Queue<INode<T>> queue2 = new LinkedList<INode<T>>();
		
		//Enqueue the first values
		queue1.add(root1.getRoot());
		queue2.add(root2.getRoot());
		
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			
			//compare the front nodes
			INode<T> node1 = queue1.peek();
			INode<T> node2 = queue2.peek();
			
			if (!node1.getData().equals(node2.getData())) {
				return false;
			}
			
			//remove them
			queue1.remove();
			queue2.remove();
			
			//Enqueue children
			if (node1.getLeftChild() != null 
					&& node2.getLeftChild() != null) {
				
				queue1.add(node1.getLeftChild());
				queue2.add(node2.getLeftChild());
			} else if (node1.getLeftChild() != null //If one is empty
					|| node2.getLeftChild() != null) {
				
				return false;
			}
			
			//Enqueue children
			if (node1.getRightChild() != null 
					&& node2.getRightChild() != null) {
				
				queue1.add(node1.getRightChild());
				queue2.add(node2.getRightChild());
			} else if (node1.getRightChild() != null //If one is empty
					|| node2.getRightChild() != null) {
				
				return false;
			}
		}
		
		return true;
	}

}
