# DATA STRUCTURE AND ALGORITHM 2

These were that the assignments that we have done during our third semester of Engineering for the course Data Structure and Algorithm 2


## JON SNOW - THE KING OF NORTH

Jon Snow is fighting with White walkers on a narrow bridge that connects north and south. Currently, on the bridge, there are three White walkers with health indexes a, b and c respectively. The health index is a positive integer that indicates how healthy is the white walker.

Jon Snow holds the sword of dragons that never misses a cut against white walkers. When ever Jon Snow wields the dragon sword, it cuts exactly one white walker and reduces its health index by one point. Note that jon Snow cannot cut a dead White walker (with health index 0). Since Jon Snow is the seventh king of The North, every seventh cut (i,e 7-th, 14-th,21-st etc) is an enhanced cut that can reduce the health index of all three White walkers by one.

Jon Snow wants to cross the bridge heroically, i. e., kill all the White walkers with the same enhanced cut. Given the health index of the three White walkers, check whether Jon Snow can cross the bridge heroically.

## SMALLEST NUMBER

Here is an interesting challenge with numbers. You are given the digits of a positive decimal integer along with the number of digits it contains. You are expected to find the integer formed using the same digits which is less than the given integer. However, no other integer formed using the same digits should lie between the integer found by you and the original integer.

## FUN WITH AVL

Here is a simple problem involving AVL trees. First, you will have to create an AVL tree by starting with a blank tree and performing a series of insertions and deletions of nodes based on their keys as given in the command line. If the key to be removed is not present in the AVL tree or if the key to be inserted is already present in the AVL tree, ignore the key; it is a no-op. Thereafter, for every node whose key is given in the next command line, you should print,

1. the height of the node.
2. the min, max, and average of all keys in the subtree rooted at that node.

## LONGEST PREFIX MATCH USING KMP ALGORITHM


As you know, Knuth-Morris-Pratt (KMP) algorithm finds the location of a given pattern P of length m in a text string T of length n in O(n+m) time. You are required to suitably enhance the KMP algorithm to find the location of the longest prefix of P as a substring of T even when there is no match for the complete pattern P in text T.

## SUGGEST SPELLING CORRECTIONS USING HASH TABLE

You will need to construct a hash table by inserting and deleting some words as instructed. Inserting a word that already exists and deleting a word that does not exist are no-ops, meaning, they result in no action being taken. You may use any hash function of your choice and any collision handling scheme of your choice – separate chaining or any form of open addressing. Thereafter, you will be asked to find a given string in the hash table. If it exists in the hash table, you report success. If it doesn’t exist, it is possible that it represents a word that has been spelled incorrectly. Therefore, you find all words similar to the given string in the hash table so that you can suggest possible spelling corrections. The similarity is determined by the following five rules:

(i) Look for all the words that can be formed by replacing any one letter in the given string with any other letter in the alphabet.

(ii) Look for all the words that can be formed by inserting any one letter of the alphabet at any position in the given string.

(iii) Look for all the words that can be formed by deleting one letter from the given string.

(iv) Look for all the words that can be formed by swapping two neighbouring characters in the string.

(v) Look for every pair of words that can be formed by inserting a space anywhere into the given string. If you find both the words of a pair that was formed in the hash table, then that pair of words will become a suggestion.

Your output is the letter Y if the given string is found in the hash table. If it is not found, your output is the count of suggestions for spelling corrections found by you in the hash table. Assume that only the 26 lower case English alphabet will be used in all strings

## SPARSE MATRIX MANIPULATION
This exercise involves manipulation of sparse matrices. Given two sparse matrices A (m x n) & B (n x p), you need to transpose both and then multiply BT (p x n) with AT (n x m). BT is the transpose of B and AT is the transpose of A. The matrices will be specified using the doubly compressed sparse column (DCSC) format.

Ideally, you should manipulate the matrices using the DCSC format itself. However, you are welcome to convert them to any other format (CSC / Triples / etc.) if you prefer. You may also use libraries such as numpy and ndarray. After transposing the two matrices, you need to compute their product (BT . AT) as a sum of non-zero rank-1 matrices, i.e., sum of outer products of non-zero columns in BT with their corresponding non-zero rows in AT.

Your output will be the following, all in one line:

• Number of non-zero rank-1 matrices (outer products) computed

• Number of non-zero elements in each of the rank-1 matrices computed

• Number of non-zero elements in the final product matrix

• Sum of all the elements in the final product matrix

## GRAPH DATA STRUCTURE TRANSFORMATION

This assignment involves transforming an edge-weighted simple undirected graph represented as an adjacency list into an adjacency matrix representation. The elements of the adjacency matrix will contain the edge weights. The input will specify the adjacency information of each vertex along with the edge weights, one vertex per row. This will be followed by an output option in the form of a number ranging from 1 to 5. For each option, the expected output is different as explained below:

Option (1): Output the degrees of the vertices specified in the next line.

Option (2): Output the edge weights of the edges specified in the next line.

Option (3): Output the number of non-zero elements in the lower triangle of the adjacency matrix representation.

Option (4): Output the cumulative weight of all edges in the graph.

Option (5): Output the upper triangle of the adjacency matrix of the graph in triples (single linear list) format in row-major order.

## UNION-FIND ALGORITHM

This assignment will evaluate your understanding of the Union-Find data structures and algorithms discussed in the class. The input to your program is a set of nodes denoted with integer keys and the instructions on how to combine these nodes using union commands. This is followed by an output option along with its parameters if any. The details of the various output options along with any parameters wherever applicable are described in the input and output format sections.

You are expected to use the weighted quick-union algorithm when executing the union command, i.e., always make the root of the smaller tree as a child of the root of the larger tree. In addition, if the two trees are of the same size, make the root with the larger key as the parent of the other root. Note: This is important; otherwise, your output may not match with the expected output.

• The letter N. You are required to print the number of disjoint sets present, i.e., the number of trees present in the forest.

• The letter Z followed by a number (k) followed by k integer keys separated by space. You are required to print the size of the tree to which each of the k nodes (whose keys are listed) belongs.

• The letter F followed by a number (k) followed by k integer keys separated by space. You are required to run the find command on each of the k nodes whose keys are listed and print the output.

• The letter D followed by a number (k) followed by k integer keys separated by space. You are required to print the depth of each of the k nodes whose keys are listed. Note: The depth of the root node is zero.

• The letter S followed by a number (k) followed by k integer keys separated by space. You are required to print the number of siblings of each of the k nodes whose keys are listed.
