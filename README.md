# Data Structures and Algorithms Project

This repository is a comprehensive collection of **data structures** and **algorithms**, implemented in Java. It is organized systematically to facilitate learning and practical implementation of key computer science concepts.

---

## **Folder Structure**

### **1. Data Structure**
#### **Graph**
- **Representations**:
  - `GraphAdjList.java` - Graph representation using adjacency lists.
  - `GraphAdjMatrix.java` - Graph representation using adjacency matrices.
- **MST (Minimum Spanning Tree)**:
  - `KruskalAlgorithm.java` - Kruskal's algorithm for MST.
  - `PrimAlgorithm.java` - Prim's algorithm for MST.
- **Searching**:
  - `GraphListBfsDfs.java` - BFS and DFS using adjacency lists.
  - `GraphMatBfsDfs.java` - BFS and DFS using adjacency matrices.

#### **List**
- `SinglyLinkedList.java` - Singly linked list implementation.
- `DoublyLinkedList.java` - Doubly linked list implementation.
- `SinglyCircularLinkedList.java` - Singly circular linked list.
- `DoublyCircularLinkedList.java` - Doubly circular linked list.

#### **Queue**
- `Queue.java` - Linked-list-based queue implementation.
- `QueueArrayBased.java` - Array-based queue implementation with dynamic resizing.

#### **Stack**
- `Stack.java` - Linked-list-based stack implementation.
- `StackArrayBased.java` - Array-based stack implementation with dynamic resizing.

#### **Tree**
- `BinaryTree.java` - Basic binary tree structure and operations.
- `BinarySearchTree.java` - Binary search tree implementation.
- `AVLTree.java` - Self-balancing AVL tree.
- `RedBlackTree.java` - Red-Black tree implementation.
- `Trie.java` - Prefix tree (trie) for string operations.

---

### **2. Shortest Path**
- `BellmanFord.java` - Bellman-Ford algorithm for single-source shortest paths.
- `FloydWarshall.java` - Floyd-Warshall algorithm for all-pairs shortest paths.

---

### **3. Sorting**
#### **Comparison-Based Sorting**
- `BubbleSort.java` - Simple sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order.
- `SelectionSort.java` - Sorting algorithm that selects the smallest element from an unsorted list and moves it to the sorted part.

#### **Non-Comparison-Based Sorting**
- `CountingSort.java` - A sorting technique based on keys between a specific range.
- `RadixSort.java` - A non-comparison-based sorting algorithm that processes individual digits.

---

### **4. String Methods**
- **Documentation**:
  - `String Methods.md` - A detailed guide on various string manipulation methods available in Java.

---

## **How to Use**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
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

## **Future Enhancements**
- Add advanced graph algorithms like Dijkstra's and A*.
- Include additional data structures like heaps and hash tables.
- Add more non-comparison-based sorting techniques.
- Include test cases for each implementation using JUnit.

---

## **Contributors**
- **Mani S** - Developer and Maintainer

Feel free to contribute by submitting pull requests or suggesting features in the issues section.

---

## **License**
This project is licensed under the MIT License. See the `LICENSE` file for more details.

You can customize it further by adding your repository link, your name, or specific enhancements you'd like to implement. Let me know if you need help adding additional details! 😊