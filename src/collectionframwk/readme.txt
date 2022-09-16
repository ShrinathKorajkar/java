iterable -> Collection -> List , Queue, Set             Map             
(all are interfaces, collections class is also available)



List -> ArrayList, LinkedList, Vector -> Stack
Queue -> PriorityQueue, LinkedList, Deque -> ArrayDeque
Set -> HashSet, LinkedHashSet, SortedSet -> TreeSet
Map -> HashMap, LinkedHashMap, SortedMap -> TreeMap, HashTable


methods -> add, remove, size, isEmpty, contains, iterator, addAll, removeAll, retainAll, clear, toArray
goto arrayList.java for all methods.



Time Complexity (h -> table Capacity)

List                get     add     contains    next    remove      iterator.remove
ArrayList ->        O(1)    O(1)    O(n)        O(1)    O(n)        O(n)
LinkedList ->       O(n)    O(1)    O(n)        O(1)    O(1)        O(1)


Queue               offer       peek    poll        size    contains
PriorityQueue ->    O(log n)    O(1)   O(log n)     O(1)    O(n)
LinkedList ->       O(1)        O(1)    O(1)        O(1)    O(n)
ArrayDeque ->       O(1)        O(1)    O(1)        O(1)    O(n)


Set                 add/remove  contains    next
HashSet ->          O(1)        O(1)        O(h/n)
LinkedHashSet ->    O(1)        O(1)        O(1)
TreeSet ->          O(log n)    O(log n)    O(log n)


Map                 get         containskey     next        put/remove
HashMap ->          O(1)        O(1)            O(h/n)      O(1)
LinkedHashMap ->    O(1)        O(1)            O(1)        O(1)
TreeMap ->          O(log n)    O(log n)        O(log n)    O(log n)
