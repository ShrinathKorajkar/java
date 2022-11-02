Given question :                timeComplexity          spaceComplexity
1. Brute force                      O(N^2)                  O(1)
2. Sorting                         O(nlogN)                 O(1)
3. using space                      O(N)                    O(N)
    (dp, hashmap, array)
4. in linear time/space             O(N)                    O(1)
    using Pointers
    using variable storage



Algorithms
1. Seive of erathosthenes       ->  prime numbers in range 
2. Kadane's algorithm           ->  sum of largest subArray
3. Euclid's algorithm           ->  GCD
4. Moore's algorithm            ->  majority element
5. Floyds cycle detection       ->  cycle detection in linked list
6. Sliding Window Maximum       ->  find max in given window
7. Kahan's algorithm            ->  Topological sort using bfs
8. Prime's algorithm            ->  minimum cost spanning tree
9. Dijkstra's algorithm         ->  single source shortest path
10. Bellman-Ford's algorithm    ->  single source shortest path
11. Kruskal's algorithm         ->  minimum cost spanning tree
12. Floyds algorithm            ->  all source shortest paths



DATA STRUCTURES
1. HashMap :- maintains HashTable with internal binay search tree for n = 8.
2. Heap :- insert(bottom heapify), delete(top heapify), heapify -> O(n), complete binay search tree(filled with last filling from left)
3. LinkedList :- 
    3.1 Insert -> toAdd.next = prev.next, prev.next = toAdd
    3.2 Delete -> prev.next = prev.next.next
    3.3 Reverse -> headNext = head.next, headNext.next = head, head.next = null, return newHead(last node)
    3.4 Pallindrome -> mid -> fastPointer, last = reverse(mid), cur = head, while(last.next != cur.next) if last.data != cur.data return false
    3.5 DetectCycle -> fastPointers till equal, loop -> start.next, match.next -> return if equal
    3.6 Clone -> temp = cur.next, cur.next = newNode(cur.data), cur.next.next = temp, cur = temp, cur.next.random = cur.random.next
4. Stack :- implement using dequeue -> ArrayDeque, postfix exp -> compiler
    4.1 largest area submatrix -> row wise find max histogram
5. PriorityQueue :- Find the median of infinite number stream at any given time - use two queues min and max heap
6. Queue :- Use arrayDeque 
    6.1 Flaten linked list -> store child in queue, or use two pointers -> cur, last
7. BinaryTree :- preorder, postorder, inorder
7. BinarySearchTree :- left tree < root < right tree, types -> AVL, REDBLACK TREE  (both are self balancing)
    7.1 AVL :- 4 cases - RR, RL, LL, LR (3 nodes)
    7.2 In RL, LR we first rotate lower than upper