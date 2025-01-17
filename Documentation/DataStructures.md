### **Types of Data Structures**

1. **Linear Data Structures**
2. **Non-Linear Data Structures**
3. **Hash-based Data Structures**

---

### **1. Linear Data Structures**

In linear data structures, elements are stored in a linear (sequential) order. Each element has a unique predecessor and successor, except the first and last elements.

#### **a) Arrays**
- **Description**: An array is a fixed-size collection of elements of the same type.
- **Example**: [10, 20, 30, 40]
- **Use Case**: When you need a collection of data elements of the same type and you need fast access via indexes.
  
#### **b) Linked Lists**
- **Description**: A linked list consists of nodes, where each node contains data and a reference to the next node.
- **Types of Linked Lists**:
  - **Singly Linked List**: Each node points to the next node.
  - **Doubly Linked List**: Each node has references to both the next and previous nodes.
  - **Circular Linked List**: The last node points back to the first node.
  
- **Example (Singly Linked List)**:
  ```java
  class Node {
      int data;
      Node next;
      Node(int data) {
          this.data = data;
          this.next = null;
      }
  }
  ```

- **Use Case**: When you want to dynamically allocate memory and avoid resizing, like in queues or stacks.

#### **c) Stack**
- **Description**: A stack follows **Last In, First Out (LIFO)** order. The last element added is the first to be removed.
- **Operations**:
  - **Push**: Add an element.
  - **Pop**: Remove an element.
  - **Peek**: View the top element without removing it.
  
- **Example (Stack)**:
  ```java
  Stack<Integer> stack = new Stack<>();
  stack.push(10);
  stack.push(20);
  stack.pop(); // Outputs 20
  ```

- **Use Case**: Undo operations, recursive function calls, and parsing expressions.

#### **d) Queue**
- **Description**: A queue follows **First In, First Out (FIFO)** order. The first element added is the first to be removed.
- **Operations**:
  - **Enqueue**: Add an element.
  - **Dequeue**: Remove an element.
  - **Peek**: View the front element without removing it.
  
- **Example (Queue)**:
  ```java
  Queue<Integer> queue = new LinkedList<>();
  queue.add(10);
  queue.add(20);
  queue.remove(); // Outputs 10
  ```

- **Use Case**: Task scheduling, handling requests in servers, or simulating processes like printing jobs.

---

### **2. Non-Linear Data Structures**

Non-linear data structures store data in a hierarchical or interconnected manner, unlike linear structures where data is stored in a sequence.

#### **a) Trees**
- **Description**: A tree is a hierarchical data structure where each node has a value and links to its child nodes.
- **Types of Trees**:
  - **Binary Tree**: Each node has at most two children.
  - **Binary Search Tree (BST)**: A binary tree with the left child smaller and the right child larger than the parent node.
  - **AVL Tree**: A self-balancing binary search tree.
  - **Heap**: A special binary tree used for priority queues.
  
- **Example (Binary Tree)**:
  ```java
  class Node {
      int data;
      Node left, right;
      Node(int item) {
          data = item;
          left = right = null;
      }
  }
  ```

- **Use Case**: Storing hierarchical data like file systems, or performing efficient searching and sorting with BSTs.

#### **b) Graphs**
- **Description**: A graph is a collection of nodes (vertices) and edges (connections between nodes).
- **Types of Graphs**:
  - **Directed Graph (Digraph)**: Edges have direction (e.g., social media followers).
  - **Undirected Graph**: Edges have no direction (e.g., roads between cities).
  - **Weighted Graph**: Edges have weights (e.g., distances between cities).
  - **Unweighted Graph**: Edges do not have weights.

- **Example (Graph)**:
  ```java
  class Graph {
      Map<Integer, List<Integer>> adjList = new HashMap<>();
      
      void addEdge(int node, int neighbor) {
          adjList.putIfAbsent(node, new ArrayList<>());
          adjList.get(node).add(neighbor);
      }
  }
  ```

- **Use Case**: Modeling networks, social media connections, or city road maps.

---

### **3. Hash-Based Data Structures**

Hash-based data structures are used for fast data retrieval by associating values with unique keys.

#### **a) Hash Table (HashMap)**
- **Description**: A hash table is a structure that stores key-value pairs. The key is passed through a hash function to find the corresponding value.
  
- **Operations**:
  - **Put**: Insert a key-value pair.
  - **Get**: Retrieve a value using a key.
  
- **Example (HashMap)**:
  ```java
  HashMap<String, Integer> map = new HashMap<>();
  map.put("Apple", 10);
  map.put("Banana", 5);
  System.out.println(map.get("Apple"));  // Outputs 10
  ```

- **Use Case**: Fast lookups for data where each piece of data is associated with a unique key (e.g., a dictionary).

---

### **Summary of Types of Data Structures**

| Type of Data Structure | Examples                            | Key Feature                             |
|------------------------|-------------------------------------|-----------------------------------------|
| **Linear**             | Arrays, Linked Lists, Stacks, Queues| Data is stored sequentially            |
| **Non-Linear**         | Trees, Graphs                      | Data is stored hierarchically or connected|
| **Hash-based**         | Hash Tables (HashMaps)              | Fast access via keys                   |

---

### **When to Use Each Data Structure?**

- **Arrays**: When you need a fixed-size collection and need fast access by index.
- **Linked Lists**: When you frequently add/remove elements and don't need fast access by index.
- **Stacks**: For reversing data, undo functionality, or recursion handling.
- **Queues**: For processing items in a first-come, first-served manner (e.g., print queue).
- **Trees**: For hierarchical data storage, and efficient searching or sorting.
- **Graphs**: For modeling networks, social connections, or relationships between entities.
- **Hash Tables**: For fast lookups where data is associated with a key (e.g., dictionaries).

---