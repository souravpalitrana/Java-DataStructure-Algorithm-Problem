# 🧠 Coding Patterns Cheat Sheet - Kotlin Edition

## Quick Pattern Recognition Guide

**Use this guide to quickly identify which pattern to apply based on problem characteristics.**

---

## 🔍 Pattern Recognition Flowchart

```
Is it about arrays/strings with conditions?
├─ Need to find pairs/triplets? → Two Pointers
├─ Need subarray/substring with condition? → Sliding Window
├─ Need to merge/schedule intervals? → Merge Intervals
└─ Need to find elements in ranges? → Binary Search

Is it about linked lists?
├─ Detect cycles/find middle? → Fast & Slow Pointers
├─ Reverse parts of list? → In-place Reversal
└─ Merge multiple lists? → K-way Merge

Is it about trees?
├─ Need to search/traverse all paths? → Tree DFS
├─ Need level-by-level processing? → Tree BFS
└─ Need to find specific nodes? → Binary Search (if BST)

Is it about graphs/matrices?
├─ Connected components/islands? → Graph DFS/BFS
├─ Find shortest path? → BFS
└─ Detect cycles/grouping? → Union Find

Is it about combinations/permutations?
├─ All possible subsets? → Subsets/Backtracking
├─ Find optimal choice? → Greedy
└─ Count ways (avoid for Meta)? → Dynamic Programming

Is it about finding top/bottom K elements?
├─ K largest/smallest? → Top K Elements
├─ Running median? → Two Heaps
└─ K closest points? → Top K Elements

Is it about special data structures?
├─ Need prefix/autocomplete? → Trie
├─ Need next greater/smaller? → Monotonic Stack
└─ Need to track order? → Custom Design
```

---

## 📚 Pattern Templates in Kotlin

### 1. Two Pointers Pattern

**When to use:** Array/string problems requiring pairs, removing duplicates, or palindrome checks.

```kotlin
// Template 1: Opposite ends
fun twoPointersOpposite(arr: IntArray): Boolean {
    var left = 0
    var right = arr.size - 1
    
    while (left < right) {
        // Process arr[left] and arr[right]
        if (condition) {
            // Found solution
            return true
        } else if (needMoveLeft) {
            left++
        } else {
            right--
        }
    }
    return false
}

// Template 2: Same direction
fun twoPointersSame(arr: IntArray): IntArray {
    var slow = 0
    
    for (fast in arr.indices) {
        if (arr[fast] != target) {
            arr[slow] = arr[fast]
            slow++
        }
    }
    return arr.sliceArray(0 until slow)
}
```

**Key Problems:**
- Two Sum II - Input Array Is Sorted
- 3Sum
- Container With Most Water
- Remove Duplicates from Sorted Array

---

### 2. Sliding Window Pattern

**When to use:** Subarray/substring problems with size constraints or conditions.

```kotlin
// Template 1: Fixed size window
fun slidingWindowFixed(arr: IntArray, k: Int): Int {
    var windowSum = arr.take(k).sum()
    var maxSum = windowSum
    
    for (i in k until arr.size) {
        windowSum += arr[i] - arr[i - k]
        maxSum = maxOf(maxSum, windowSum)
    }
    return maxSum
}

// Template 2: Dynamic size window
fun slidingWindowDynamic(s: String): Int {
    val charCount = mutableMapOf<Char, Int>()
    var left = 0
    var maxLength = 0
    
    for (right in s.indices) {
        charCount[s[right]] = charCount.getOrDefault(s[right], 0) + 1
        
        while (violatesCondition(charCount)) {
            charCount[s[left]] = charCount[s[left]]!! - 1
            if (charCount[s[left]] == 0) charCount.remove(s[left])
            left++
        }
        
        maxLength = maxOf(maxLength, right - left + 1)
    }
    return maxLength
}
```

**Key Problems:**
- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Sliding Window Maximum
- Longest Repeating Character Replacement

---

### 3. Fast & Slow Pointers (Floyd's Cycle Detection)

**When to use:** Linked list cycle detection, finding middle element, or detecting patterns.

```kotlin
// Template: Cycle detection
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        
        if (slow == fast) return true
    }
    return false
}

// Template: Find middle
fun findMiddle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}
```

**Key Problems:**
- Linked List Cycle
- Find the Duplicate Number
- Middle of the Linked List
- Happy Number

---

### 4. Tree DFS Pattern

**When to use:** Tree traversal, path finding, tree modification problems.

```kotlin
// Template 1: Preorder traversal
fun preorderDFS(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    
    fun dfs(node: TreeNode?) {
        if (node == null) return
        
        result.add(node.`val`) // Process current
        dfs(node.left)         // Left subtree
        dfs(node.right)        // Right subtree
    }
    
    dfs(root)
    return result
}

// Template 2: Path sum problems
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    }
    
    val remaining = targetSum - root.`val`
    return hasPathSum(root.left, remaining) || 
           hasPathSum(root.right, remaining)
}

// Template 3: Tree modification
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    
    val temp = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(temp)
    
    return root
}
```

**Key Problems:**
- Binary Tree Maximum Path Sum
- Path Sum II
- Diameter of Binary Tree
- Serialize and Deserialize Binary Tree

---

### 5. Tree BFS Pattern

**When to use:** Level-order traversal, finding tree width, shortest path in trees.

```kotlin
// Template: Level order traversal
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    
    val result = mutableListOf<List<Int>>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()
        
        repeat(levelSize) {
            val node = queue.poll()
            currentLevel.add(node.`val`)
            
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        
        result.add(currentLevel)
    }
    
    return result
}
```

**Key Problems:**
- Binary Tree Level Order Traversal
- Binary Tree Right Side View
- Binary Tree Zigzag Level Order Traversal
- Maximum Width of Binary Tree

---

### 6. Binary Search Pattern

**When to use:** Searching in sorted arrays, finding boundaries, optimization problems.

```kotlin
// Template 1: Standard binary search
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}

// Template 2: Find boundary (leftmost/rightmost)
fun findBoundary(nums: IntArray, target: Int, findLeft: Boolean): Int {
    var left = 0
    var right = nums.size - 1
    var result = -1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> {
                result = mid
                if (findLeft) right = mid - 1
                else left = mid + 1
            }
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return result
}
```

**Key Problems:**
- Search in Rotated Sorted Array
- Find First and Last Position of Element
- Search a 2D Matrix
- Find Minimum in Rotated Sorted Array

---

### 7. Top K Elements Pattern

**When to use:** Finding K largest/smallest elements, K frequent elements.

```kotlin
// Template: Using heap
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencyMap = nums.groupingBy { it }.eachCount()
    
    // Min heap to keep top k frequent elements
    val minHeap = PriorityQueue<Int> { a, b -> 
        frequencyMap[a]!! - frequencyMap[b]!! 
    }
    
    for (num in frequencyMap.keys) {
        minHeap.offer(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    
    return minHeap.toIntArray()
}
```

**Key Problems:**
- Top K Frequent Elements
- Kth Largest Element in an Array
- K Closest Points to Origin
- Find K Pairs with Smallest Sums

---

### 8. Merge Intervals Pattern

**When to use:** Overlapping intervals, scheduling problems, range queries.

```kotlin
// Template: Merge overlapping intervals
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()
    
    intervals.sortBy { it[0] }
    val merged = mutableListOf<IntArray>()
    
    for (interval in intervals) {
        if (merged.isEmpty() || merged.last()[1] < interval[0]) {
            merged.add(interval)
        } else {
            merged.last()[1] = maxOf(merged.last()[1], interval[1])
        }
    }
    
    return merged.toTypedArray()
}
```

**Key Problems:**
- Merge Intervals
- Insert Interval
- Meeting Rooms II
- Non-overlapping Intervals

---

### 9. Graph DFS/BFS Pattern

**When to use:** Connected components, shortest path, graph traversal.

```kotlin
// Template: DFS for connected components
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0
    
    val rows = grid.size
    val cols = grid[0].size
    var islands = 0
    
    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') return
        
        grid[r][c] = '0' // Mark as visited
        
        // Visit all 4 directions
        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
    }
    
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                islands++
                dfs(r, c)
            }
        }
    }
    
    return islands
}

// Template: BFS for shortest path
fun shortestPath(grid: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = mutableSetOf<Pair<Int, Int>>()
    queue.offer(0 to 0)
    visited.add(0 to 0)
    
    var steps = 0
    val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val (row, col) = queue.poll()
            
            if (row == grid.size - 1 && col == grid[0].size - 1) {
                return steps
            }
            
            for ((dr, dc) in directions) {
                val newRow = row + dr
                val newCol = col + dc
                val newPos = newRow to newCol
                
                if (newRow in grid.indices && 
                    newCol in grid[0].indices && 
                    grid[newRow][newCol] == 0 && 
                    newPos !in visited) {
                    
                    queue.offer(newPos)
                    visited.add(newPos)
                }
            }
        }
        steps++
    }
    
    return -1
}
```

**Key Problems:**
- Number of Islands
- Clone Graph
- Course Schedule
- Pacific Atlantic Water Flow

---

### 10. Backtracking Pattern

**When to use:** Finding all solutions, combinations, permutations.

```kotlin
// Template: Generate subsets
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()
    
    fun backtrack(index: Int) {
        result.add(current.toList()) // Add current subset
        
        for (i in index until nums.size) {
            current.add(nums[i])      // Choose
            backtrack(i + 1)          // Explore
            current.removeAt(current.size - 1) // Unchoose
        }
    }
    
    backtrack(0)
    return result
}

// Template: Generate permutations
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()
    val used = BooleanArray(nums.size)
    
    fun backtrack() {
        if (current.size == nums.size) {
            result.add(current.toList())
            return
        }
        
        for (i in nums.indices) {
            if (!used[i]) {
                current.add(nums[i])  // Choose
                used[i] = true
                backtrack()           // Explore
                current.removeAt(current.size - 1) // Unchoose
                used[i] = false
            }
        }
    }
    
    backtrack()
    return result
}
```

**Key Problems:**
- Subsets
- Permutations
- Combination Sum
- N-Queens

---

## 🎯 Meta-Specific Pattern Priority

### High Priority (70% of questions):
1. **Two Pointers** - Arrays and strings
2. **Sliding Window** - Substring problems
3. **Tree DFS/BFS** - Tree traversal
4. **Graph DFS/BFS** - Connected components
5. **Binary Search** - Search problems
6. **Hash Tables** - Fast lookups

### Medium Priority (25% of questions):
7. **Fast & Slow Pointers** - Linked lists
8. **Top K Elements** - Heap problems
9. **Merge Intervals** - Scheduling
10. **Backtracking** - Combinations

### Lower Priority (5% of questions):
11. **Union Find** - Connectivity
12. **Trie** - Prefix matching
13. **Monotonic Stack** - Next greater/smaller

### Avoid (Meta doesn't ask):
- Dynamic Programming patterns
- Complex mathematical algorithms
- String matching algorithms (KMP, etc.)

---

## 🚀 Quick Problem Identification

**See these keywords → Use this pattern:**

- "Two numbers that sum to..." → **Two Pointers**
- "Longest/shortest substring..." → **Sliding Window**
- "Cycle in linked list..." → **Fast & Slow Pointers**
- "All paths in tree..." → **Tree DFS**
- "Level by level..." → **Tree BFS**
- "Search in sorted..." → **Binary Search**
- "K largest/smallest..." → **Top K Elements**
- "Overlapping intervals..." → **Merge Intervals**
- "Connected components..." → **Graph DFS/BFS**
- "All combinations..." → **Backtracking**

---

## 💡 Pro Tips for Pattern Mastery

1. **Start with brute force** - then optimize with patterns
2. **Draw examples** - visualize the problem
3. **Identify constraints** - guides pattern selection  
4. **Practice templates** - muscle memory for interviews
5. **Time complexity** - know the Big O for each pattern
6. **Edge cases** - empty inputs, single elements, etc.

---

## 📝 Pattern Practice Checklist

### Mastery Indicators:
- [ ] Can identify pattern from problem description
- [ ] Can write template from memory
- [ ] Can solve Easy problems in <15 minutes
- [ ] Can solve Medium problems in <25 minutes  
- [ ] Can explain approach clearly while coding
- [ ] Can handle edge cases confidently

### For Each Pattern:
- [ ] Understand the core concept
- [ ] Memorize the template
- [ ] Solve 3-5 practice problems
- [ ] Can teach it to someone else
- [ ] Know time/space complexity

This cheat sheet covers the essential patterns you need for Meta interviews. Focus on the high-priority patterns first, and use this as a quick reference during your practice sessions!