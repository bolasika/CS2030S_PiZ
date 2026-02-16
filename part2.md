# PiZ (part 2)

## Part 2

In this part, you will be making changes to your task 1.


### Task 2

First, add a new food in PiZ.

- `PersonalFries` with a fixed sugar intake of 250g but it can only have a maximum capacity of 1.
    If there is more than 1 eater trying to eat the food, it will throw an
    _unchecked_ exception named `PersonalException`.
    - **String output**: Since the food is only for ONE eater, the string output do not require to 
    output the number of eaters.

Second, add a new method in PiZ app.

- Implement the method `addPersonalFries`.  The method accepts no parameter.
    - **Description:** The method adds a new PersonalFries food to the pool. The
        food is added to a queue. The method returns a string in the
        following format.
        ```
        <index>: <food> added
        ```
        `<index>` is the index of the food.
        `<food>` is the description of the food.
        See the sample run for more information
    - **Usage:** `piz.addPersonalFries()`

Finally, make sure that the methods are compatible with `eat`. If you have
followed good OO principles, there should be minimal change to `eat`.<br><br>
Note that `PiZ::eat` method now returns the following string.
```
<index>: <food> (<pax> eater(s)) with <sugar>g sugar intake each
```

Since the exception is unchecked, you do not have to modify `eat` and simply 
let the exception propagates via stack unrolling to the caller.

**Reminder:** All _unchecked_ exceptions are a subclass of the following.
```java
java.lang.RuntimeException
```

The class has the following constructor.
```java
RuntimeException(String msg)
```

The constructor constructs a new exception with the  specified detail message 
`msg` that can be retrieved via `getMessage()` to get the message as a string.


### Sample Run

```java
jshell> PiZ piz = new PiZ(3);
jshell> piz.addBeefPizza();
$.. ==> "0: BeefPizza added"
jshell> piz.addPersonalFries();
$.. ==> "1: PersonalFries added"
jshell> piz.eat(0, 3);
$.. ==> "0: BeefPizza (3 eater(s)) with 1666g sugar intake each"
jshell> piz.eat(1, 1);
$.. ==> "1: PersonalFries with 0g sugar intake"
jshell> piz.addPersonalFries();
$.. ==> "2: PersonalFries added"
jshell> piz.eat(1, 4);
|  Exception PersonalException: PERSONAL FOOD! Not for 4
```

## Submit
you will need to pass all test cases on task 2 run the test case 
`Test2.class` using the following command.

```shell
java Test2
```
