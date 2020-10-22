package edu.wmich.CS3310.PA3.JakeKonkowski;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException {	
		// build a tree for the following lists
        Integer[] array1 = {4,1,9,12,3,2,8,7,16,20,13,11};
		Integer[] array2 = {4,1,9,12,3,2,8,7,16,20,13,11};

		//add more examples here

		ITree<Integer> bst1 = new BinarySearchTree<Integer>(array1);
		ITree<Integer> bst2 = new BinarySearchTree<Integer>(array2);
		

		//more trees for each example

		TreeChecker<Integer> treeChecker = new TreeChecker<Integer>();

		bst1.inorder();
		bst1.preorder();
		bst1.postorder();
		System.out.println("");
		bst2.inorder();
		bst2.preorder();
		bst2.postorder();
		System.out.println("");
		
		if (treeChecker.isMirror(bst1, bst2)) {
			System.out.println("The trees are mirrors of each other.\n");
		} else if (treeChecker.isSame(bst1, bst2)) {
			System.out.println("The trees are the same.\n");
		} else {
			System.out.println("The trees have no relation.\n");
		}
		
		Random random = new Random();
		bst1.remove(bst1.getRoot(), array1[random.nextInt(array1.length)]);
		bst2.remove(bst2.getRoot(), array2[random.nextInt(array2.length)]);
		
		bst1.inorder();
		bst1.preorder();
		bst1.postorder();
		System.out.println("");
		bst2.inorder();
		bst2.preorder();
		bst2.postorder();
		System.out.println("");
		
		if (treeChecker.isMirror(bst1, bst2)) {
			System.out.println("The trees are mirrors of each other.\n");
		} else if (treeChecker.isSame(bst1, bst2)) {
			System.out.println("The trees are the same.\n");
		} else {
			System.out.println("The trees have no relation.\n");
		}
		
		//Sorry I wanted to be fancy
		
		ArrayList<BinarySearchTree<Integer>> fancyArray1 = 
				new ArrayList<BinarySearchTree<Integer>>();
		ArrayList<BinarySearchTree<Integer>> fancyArray2 = 
				new ArrayList<BinarySearchTree<Integer>>();
		ArrayList<Integer[]> fancyIntArray1 = new ArrayList<Integer[]>();
		for (int i = 10; i < 15; i++) {
			Integer[] fancyIntArray = new Integer[i];
			for (int j = 0; j < fancyIntArray.length; j++) {
				fancyIntArray[j] = random.nextInt(Integer.MAX_VALUE);
			}
			fancyArray1.add(new BinarySearchTree<Integer>(fancyIntArray));
			fancyArray2.add(new BinarySearchTree<Integer>(fancyIntArray));
			fancyIntArray1.add(fancyIntArray);
		}
		
		for (int i = 0; i < fancyArray1.size(); i++) {
			
			System.out.println("Extra test #" + (i + 1));
			
			fancyArray1.get(i).inorder();
			fancyArray1.get(i).preorder();
			fancyArray1.get(i).postorder();
			System.out.println("");
			fancyArray2.get(i).inorder();
			fancyArray2.get(i).preorder();
			fancyArray2.get(i).postorder();
			System.out.println("");
			
			if (treeChecker.isMirror(fancyArray1.get(i), fancyArray2.get(i))) {
				System.out.println("The trees are mirrors of each other.\n");
			} else if (treeChecker.isSame(fancyArray1.get(i), fancyArray2.get(i))) {
				System.out.println("The trees are the same.\n");
			} else {
				System.out.println("The trees have no relation.\n");
			}
			
			fancyArray1.get(i).remove(fancyArray1.get(i).getRoot(), 
					fancyIntArray1.get(i)[random.nextInt(fancyIntArray1.get(i).length)]);
			fancyArray2.get(i).remove(fancyArray2.get(i).getRoot(), 
					fancyIntArray1.get(i)[random.nextInt(fancyIntArray1.get(i).length)]);
			
			fancyArray1.get(i).inorder();
			fancyArray1.get(i).preorder();
			fancyArray1.get(i).postorder();
			System.out.println("");
			fancyArray2.get(i).inorder();
			fancyArray2.get(i).preorder();
			fancyArray2.get(i).postorder();
			System.out.println("");
			
			if (treeChecker.isMirror(fancyArray1.get(i), fancyArray2.get(i))) {
				System.out.println("The trees are mirrors of each other.\n");
			} else if (treeChecker.isSame(fancyArray1.get(i), fancyArray2.get(i))) {
				System.out.println("The trees are the same.\n");
			} else {
				System.out.println("The trees have no relation.\n");
			}
		}
	}
}
