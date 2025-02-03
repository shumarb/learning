# Exceptions

## Overview
An exception is an event that disrupts the normal flow of a program's execution. 
It is an object that describes an error or unexpected behavior in a program.
Java provides an exception handling mechanism via `try`, `catch`, `finally`, `throw`, and `throws` keywords.

## Importance
| Importance      | Explanation                                                                                                                                                    |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Error Location  | Exceptions thrown pinpoint the location where the error occurred, making it easier for developers to fix bugs.                                                 |
| Error Diagnosis | The stack trace and exception message provide insights into what went wrong, making it easier for developers to fix bugs and improve the program's logic flow. |
| Prevent Crashes | Proper exception handling allows developers to catch errors and link it to corrective actions so that the program does not crash.                              |

## Types of Exceptions
| Exception Type | Explanation                                                                                                                                                       | Examples                                                |
|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| Checked        | Exceptions checked at `compile-time`. The compiler forces you to handle them, either by using a try-catch block or by declaring them with the throws keyword.     | IOException and SQLException.                           |
| Unchecked      | Exceptions checked at `runtime`. Only `RuntimeExceptions` are unchecked, all other exceptions are checked. These exceptions typically represent programming bugs. | NullPointerException or ArrayIndexOutOfBoundsException. |

## Example
Here is an example of exception handling using the `try`, `catch`, `finally`, and `throws` keywords involving `IOException` and `ArithmeticException`:
```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // Checked exception: FileNotFoundException
            readFile("nonexistentFile.txt");

            // Unchecked exception: ArithmeticException (divide by zero)
            int result = divide(10, 0);
            System.out.println("Result: " + result);

        } catch (IOException e) {
            System.out.println("Checked Exception caught: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Unchecked Exception caught: " + e.getMessage());
        } finally {
            System.out.println("This will always execute.");
        }
    }

    // Checked exception (FileNotFoundException)
    public static void readFile(String filename) throws IOException {
        throw new IOException("File not found: " + filename);  // Simulating file read error
    }

    // Unchecked exception (ArithmeticException)
    public static int divide(int a, int b) {
        return a / b;  // Division by zero will cause ArithmeticException
    }
}
```