# Data Structures and Algorithms

This repository is a comprehensive collection of **data structures** and **algorithms**, implemented in Java. It is organized systematically to facilitate learning and practical implementation of key computer science concepts.

---

## **Folder Structure**

### **1. Data Structure**
#### **Graph**
- **Representations**:
  - [GraphAdjList.java](./Data%20Structure/Graph/GraphAdjList.java) - Graph representation using adjacency lists.
  - [GraphAdjMatrix.java](./Data%20Structure/Graph/GraphAdjMatrix.java) - Graph representation using adjacency matrices.
- **MST (Minimum Spanning Tree)**:
  - [KruskalAlgorithm.java](./Data%20Structure/Graph/MST/KruskalAlgorithm.java) - Kruskal's algorithm for MST.
  - [PrimAlgorithm.java](./Data%20Structure/Graph/MST/PrimAlgorithm.java) - Prim's algorithm for MST.
- **Searching**:
  - [GraphListBfsDfs.java](./Data%20Structure/Graph/Searching/GraphListBfsDfs.java) - BFS and DFS using adjacency lists.
  - [GraphMatBfsDfs.java](./Data%20Structure/Graph/Searching/GraphMatBfsDfs.java) - BFS and DFS using adjacency matrices.

#### **List**
- [SinglyLinkedList.java](./Data%20Structure/List/SinglyLinkedList.java) - Singly linked list implementation.
- [DoublyLinkedList.java](./Data%20Structure/List/DoublyLinkedList.java) - Doubly linked list implementation.
- [SinglyCircularLinkedList.java](./Data%20Structure/List/SinglyCircularLinkedList.java) - Singly circular linked list.
- [DoublyCircularLinkedList.java](./Data%20Structure/List/DoublyCircularLinkedList.java) - Doubly circular linked list.

#### **Queue**
- [Queue.java](./Data%20Structure/Queue/Queue.java) - Linked-list-based queue implementation.
- [QueueArrayBased.java](./Data%20Structure/Queue/QueueArrayBased.java) - Array-based queue implementation with dynamic resizing.

#### **Stack**
- [Stack.java](./Data%20Structure/Stack/Stack.java) - Linked-list-based stack implementation.
- [StackArrayBased.java](./Data%20Structure/Stack/StackArrayBased.java) - Array-based stack implementation with dynamic resizing.

#### **Tree**
- [BinaryTree.java](./Data%20Structure/Tree/BinaryTree.java) - Basic binary tree structure and operations.
- [BinarySearchTree.java](./Data%20Structure/Tree/BinarySearchTree.java) - Binary search tree implementation.
- [AVLTree.java](./Data%20Structure/Tree/AVLTree.java) - Self-balancing AVL tree.
- [RedBlackTree.java](./Data%20Structure/Tree/RedBlackTree.java) - Red-Black tree implementation.
- [Trie.java](./Data%20Structure/Tree/Trie.java) - Prefix tree (trie) for string operations.

For a detailed explanation of all the data structures, refer to the [**Data Structures Overview**](./Documentaion/DataStructures.md).

---

### **2. Recursion**
#### **Direct Recursion**
- [HeadRecursion.java](./Recursion/Direct/HeadRecursion.java) and [HeadRecursion.md](./Recursion/Direct/HeadRecursion.md) - Explanation and implementation of head recursion.
- [TailRecursion.java](./Recursion/Direct/TailRecursion.java) and [TailRecursion.md](./Recursion/Direct/TailRecursion.md) - Explanation and implementation of tail recursion.
- [TreeRecursion.java](./Recursion/Direct/TreeRecursion.java) and [TreeRecursion.md](./Recursion/Direct/TreeRecursion.md) - Explanation and implementation of tree recursion.
- [NestedRecursion.java](./Recursion/Direct/NestedRecursion.java) and [NestedRecursion.md](./Recursion/Direct/NestedRecursion.md) - Explanation and implementation of nested recursion.

#### **Indirect Recursion**
- [IndirectRecursion.java](./Recursion/Direct/IndirectRecursion.java) and [IndirectRecursion.md](./Recursion/Indirect/IndirectRecursion.md) - Explanation and implementation of indirect recursion, supported by [image.png](./Recursion/Indirect/image.png) for visualization.

---

### **3. Shortest Path**
- [BellmanFord.java](./ShortestPath/BellmanFord.java) - Bellman-Ford algorithm for single-source shortest paths.
- [FloydWarshall.java](./ShortestPath/FloydWarshall.java) - Floyd-Warshall algorithm for all-pairs shortest paths.

---

### **4. Sorting**
#### **Comparison-Based Sorting**
- [BubbleSort.java](./Sorting/ComparisonBased/BubbleSort.java) - Simple sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order.
- [SelectionSort.java](./Sorting/ComparisonBased/SelectionSort.java) - Sorting algorithm that selects the smallest element from an unsorted list and moves it to the sorted part.

#### **Non-Comparison-Based Sorting**
<p align ="center"> Will be Added</p>

- `CountingSort.java` - A sorting technique based on keys between a specific range.
- `RadixSort.java` - A non-comparison-based sorting algorithm that processes individual digits.

---

### **5. String Methods**
- [**String Methods:**](./Documentaion/String%20Methods.md) A detailed guide on various string manipulation methods available in Java.

---

### **6. Time and Space Complexity**
- [**Big-O-Notation:**](./Documentaion/Big-O-Notation.md)  An overview of the Big-O notation and how it is used to express time and space complexities of algorithms.
- [**Time Complexity:**](./Documentaion/TimeComplexity.md)  A detailed explanation of time complexity analysis for common algorithms.
- [**Space Complexity:**](./Documentaion/SpaceComplexity.md) An overview of space complexity and how it is measured for different algorithms.

---

## **How to Use**
1. Clone the repository:
   ```bash
   git clone https://github.com/Mani-26/YM_DSA.git
   ```
2. Navigate to the desired folder and compile the Java file:
   ```bash
   javac FileName.java
   ```
3. Run the compiled Java program:
   ```bash
   java FileName
   ```
---

## **Features**
- **Comprehensive**: Covers fundamental and advanced data structures and algorithms.
- **Systematic Organization**: Well-structured folders for easy navigation.
- **Dynamic Implementations**: Includes dynamic resizing for stacks and queues.
- **Educational**: Includes both simple and advanced algorithms with clean, understandable code.

---

## **Contributors**
- [**Mani S**](https://github.com/Mani-26) - Developer and Maintainer


## **From the Developer:** 
If you find this repository helpful, please consider giving it a ⭐ on GitHub for easy access, to stay updated with new additions and to support its development.

Feel free to contribute by submitting pull requests or suggesting features in the issues section.

---
