# Abstraction

## Overview
Abstraction is a concept of `exposing` the essential features of an object while `hiding` its complex implementation details, 
hence enabling developers and users to `interact` with higher-level concepts without needing to understand the underlying complexities.

## Importance
- **Simplifies Interaction**: Provides a clear and simple interface, making it easier to use complex systems.
- **Reduces Complexity**: Hides intricate details, making the system easier to manage and understand.
- **Enhances Flexibility**: Changes in implementation details do not affect the user-facing interface.
- **Promotes Reusability**: Common abstractions can be reused across different parts of the application.

## Implementation
- **[Abstract class](https://github.com/shumarb/learning/blob/main/readmes/abstract-class.md)**
- **[Interface](https://github.com/shumarb/learning/blob/main/readmes/interface.md)**
- **Modular Design**

## Example
Here is an example of abstraction via a modular design:

```java
import java.util.Arrays;
import java.util.Scanner;

class Calculator {

    private static void displaySum(int[] numbers, int sum) {
        System.out.println(numbers[0] + " + " + numbers[1] + " = " + sum);    
    }
    
    private static int computeSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] readsNumber() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[2];
        System.out.print("Enter two numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = readNumbers();
        int sum = computeSum(numbers);
        displaySum(numbers, sum);
    }
}
```
In the `Calculator` class:
- The `main` method handles high-level operations (reading numbers, computing the sum, displaying the result) without exposing the underlying details.
- Each method encapsulates a specific task, hiding its complex implementation.
- Method implementations can be modified without affecting the `main` method.
- The methods are reusable across different parts of the application.
