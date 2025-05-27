# core-java-2024

Jay's proj repo for Core Java practice. List below ARE NOT NOTES. They are topics covered.

package: jayslabs.corejava.coachv : notes and practice code created from coach Venkats lectures
- C4ComputingStatistics - Counting Occurences - Collectors.partitioningBy(predicate);groupingBy(classifier, func);collectingAndThen(); transforming data - .map(), flatMap(), .mapToDouble(); Stats - .average(), Collectors.averagingDouble(func)/summarizingDouble(func), .sum(), .min(), .max(), .anyMatch/noneMatch(predicate)
- C3FilesAndDirectories - watchFileChange() : event notifier when there are changes to a directory/file. Used WatchService, .poll(), WatchKey, .pollEvents(), Path.register(wsrvc, StandardWatchEventKinds.ENTRY_MODIFY)
- C3FilesAndDirectories - .filter(), .newDirectoryStream(), listSelectFiles(), listSubDirs()
- C3FilesAndDirectories - Files, Paths, .list(), .get(), Path, isDirectory()
- C3Collectors - used groupingBy(), reducing(BinaryOperator.maxBy(comparator)) to get map where key is 1st char of name, and val is eldest if persons under that k (reducing)
- C3Collectors - Collectors, .toList(), .toMap(name, <Person>), .toSet(), .groupingBy(classifier, collector), .mapping(function, accumulator) 
- C3Compare - used .thenComparing(comparator) to chain comparators; Defined comparator var
- Chap3: C3Compare - added .min(Comparator), .max(Comparator) tests
- Chap3: C3Compare - used .sorted(Comparator), (2) Comparator implementations: define method() calling compareTo(), call Comparator.comparing(T.x), reversed(); C3StringIteration - .chars(), forEach(Consumer), filter(Predicate)
- Chap2: Chap2ReducingCollection - reduce(accumulator), reduce(id, accumulator), accumulator is lambda returning the longer of two strings; .max(Comparator.comparing())
- Chap2: Chap2PickingElement - used Optional<String>, .orElse(string)
- Chap2: create Chap2ReusingLambdaExpressions: created method returning Predicate<String>, and another using inline Function -> Function<String, Predicate<String>>, both to be passed in .filter() 
- Chap2: created reusable var for Predicate
- Chap2: forEach(consumer), map(function), method reference, mapToInt(), IntStream.average(). orElse(), filter(predicate), skip(n), dropWhile(predicate), limit(n), takeWhile(predicate)
- Chap1 topics: stream(), filter(predicate), mapToDouble(function), sum()

practice:
- Fibonacci, StringReverse, IsPalindrome
- Factorial with recursive and iterative solution

proj: functionalprog (mvn, jdk21, junit5)
- LinkedList: addFirst(), addLast(), removeFirst(), removeLast()
- Stack: push(), pop()
- List: replaceAll(), set()
- Collections practice; Collection methods: forEach(), removeIf(), Arrays.asList(), add()
- Streams Assignment #8-14
- Streams Assignment #1-7
- Parallel Streams demo
- Optionals Demo
- Primitive Streams demo; added examples
- Streams Demo: Intermediate Operations - sorted()
- Streams Demo: Intermediate Operations - flatMap()
- Streams Demo: Intermediate Operations - map()
- Streams Demo: Intermediate Operations - filter(), distinct(), limit()
- Collectors.partitioningBy() demo: with and without duplicates (using set and supplier to return a TreeMap) and sorted (using TreeSet)
- Collectors.groupingBy() demo: with and without duplicates (using set and supplier to return a TreeMap) and sorted (using TreeSet)
- added samples: Collectors.joining(), Collectors.averagingInt(), Collectors.toMap(), Collectors.toMap(merge values function for duplicate keys), Collectors.toMap(merge function and supplier)
- collect() - demo of collect method with Supplier, accumulator, combiner
- reduce() - count and total chars of all words in a stream: accumulator(BiFunction), combiner(BinaryOperator)
- Demo of Terminal operations: forEach, reduce, collect, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny
- Stream creation demo: create stream from array, file, collection; try-with-resources
- Streams Demo: laziness, anymatch, map
- Streams Demo: creating streams, filter, count, peek, forEach
- Answered Assignment 2: Method References
- Answered Assignment 1: Lambdas
- Static and Constructor Method reference demo
- CustomFileReader: use regex to find and replace credit card number with ****
- Unbound method reference demo
- updated bound method reference demo
- Bound method reference demo
- Method reference demo
- final and effectively final demo
- UnaryOperator, BinaryOperator demo
- Function, BiFunction demo, using andThen() and compose()
- Consumer, BiConsumer demo
- Added demoes: Generic method for Predicate, BiPredicate
- Added lambda Predicate demo
- Functional Interface, lambda expression demo
- project and workspace init; fixed tests
