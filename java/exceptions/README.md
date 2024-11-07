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
| Exception Type       | Explanation                                                                                                                                                   | Examples                                                |
|----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| Checked Exceptions   | Exceptions checked at `compile-time`. The compiler forces you to handle them, either by using a try-catch block or by declaring them with the throws keyword. | IOException and SQLException.                           |
| Unchecked Exceptions | Exceptions checked at `runtime`. These exceptions typically represent programming bugs.                                                                       | NullPointerException or ArrayIndexOutOfBoundsException. |
