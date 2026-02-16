# PiZ

## Preliminary

Any inconsistency or problems with the question, please telegram @yikleong.

## Important Note

### Sample Run

You need to get yourself familiar with sample run.  The sample run will 
contain the expected format.


### Compilation

Make sure your submission compiles by 
running the following command before submission.

```shell
javac *.java
```



## Description

For this exercise, we will show how "inheritance + polymorphism" can help us guard against potential 
changes.

You should also follow good OOP practices.  In the PE, we will be very strict 
with accessors and mutators.  So, think carefully if you need them.  Note that 
the check in this lab exercise will be less strict than the check in PE.


## Task

PiZ is a new online pizza ordering and eating tracker. For now, PiZ provides
only **one kind of food** but this may change in the future.

All foods have a sugar level. The sugar intake typically depends on how many
people share the food.

The food that PiZ currently offers is called BeefPizza. It has a total
sugar of 5000 grams. 

For the total number of eaters (`pax`), the sugar intake per eater
can be computed as follows:

```java
sugarIntakePerEater = 5000 / pax;
```

All sugar intake values are in `int`, so this is an integer division. The result of the division would be floored.
In other words, if 2 people share the BeefPizza, each consumes 2500g of sugar.
If 3 people share BeefPizza, each consumes 1666g of sugar.

Your task is to implement the PiZ app. Implement a class called PiZ with
the following operations:

- Implement the `PiZ` constructor. The constructor accepts 1 parameter.
    - Par 1: `num` is an integer. It is the number of foods that will be
        available.
    - **Description:** The constructor initializes a `PiZ` with the given 
        number of future available foods.
    - **Usage:** `new PiZ(num)`

- Implement the method `addBeefPizza`.  The method accepts no parameter.
    - **Description:** The method adds a new BeefPizza food to the pool. The
        food is added to a queue. The method returns a string in the
        following format.
        ```
        <index>: <food> added
        ```
        `<index>` is the index of the food.
        `<food>` is the description of the food.
        See the sample run for more information
    - **Usage:** `piz.addBeefPizza()`

- Implement the method `eat`.  The method accepts 3 parameters.
    - Par #1: `idx` is a no-negative integer.  It is the index of the food.
        You are guaranteed that this is a valid index. In other words, the
        food is available and no uesr has eaten it yet.    
    - Par #2: `pax` is an integer. It is the number of eaters.
    - **Description:** The method assigns the eaters to the food that is
        specified by the index. The method returns a string in the following
        format:
        ```
        <index>: <food> for <pax> eater(s) with <sugar>g sugar intake each
        ```
    - **Usage:** `piz.eat(idx, pax)`


### Sample Run

```java
jshell> PiZ piz = new PiZ(3)
jshell> piz.addBeefPizza()
$.. ==> "0: BeefPizza added"
jshell> piz.addBeefPizza()
$.. ==> "1: BeefPizza added"
jshell> piz.eat(1, 2)
$.. ==> "1: BeefPizza for 2 eater(s) with 2500g sugar intake each"
jshell> piz.eat(0, 6)
$.. ==> "0: BeefPizza for 6 eater(s) with 833g sugar intake each"
jshell> piz.addBeefPizza()
$.. ==> "2: BeefPizza added"
jshell> piz.eat(2, 1)
$.. ==> "2: BeefPizza for 1 eater(s) with 5000g sugar intake each"
```

### Warning

There would be part 2.


## Part 2

The question for part 2 is in the file named `part2.md`.  
you will need to pass all test cases on task 1, run the test case 
`Test1.class` using the following command.

```shell
java Test1
```

If you pass all the test cases, then go next.

If you have done the design correctly, the changes should be minimal.


### Potential Changes

- We may change the way we compute sugar intake.
- We may change the way a food is printed.
- We may add new food with new sugar structure.
- We may add new food with different eater limits.

