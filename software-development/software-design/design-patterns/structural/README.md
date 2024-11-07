# Structural Design Pattern

## Overview
Structural design patterns focus on how to compose objects and class to form larger structures while keeping them flexible and efficient.

## Importance
| Importance                               | Explanation                                                                                    |
|------------------------------------------|------------------------------------------------------------------------------------------------|
| Simplifies relationships between objects | Reduce the complexity of how objects are connected or composed within a system.                |
| Enhances flexibility                     | Easier to add or modify components without affecting the rest of the system.                   |
| Promotes reusability                     | By reusing common patterns for organizing objects, code becomes more modular and maintainable. |

## Example 
The Adapter pattern allows two incompatible systems to work together.
For example, a payment system supporting both cash and credit card payments.
The Adapter converts a cash payment to a format that the system can process, making the two systems compatible.

```java
// Existing system that accepts only credit card payments
interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card.");
    }
}

// New system that accepts only cash payments
class CashPayment {
    public void payCash(double amount) {
        System.out.println("Paid $" + amount + " via Cash.");
    }
}

// Adapter that allows cash payments to work with the existing system
class CashPaymentAdapter implements PaymentMethod {
    private CashPayment cashPayment;

    public CashPaymentAdapter(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    @Override
    public void pay(double amount) {
        cashPayment.payCash(amount);  // Adapts the cash payment
    }
}

// Using the Adapter to make cash payments compatible
public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        creditCard.pay(20.0);  // Works as usual with Credit Card

        // Using the Adapter to make Cash Payment compatible
        CashPayment cashPayment = new CashPayment();
        PaymentMethod cashAdapter = new CashPaymentAdapter(cashPayment);
        cashAdapter.pay(30.0);  // Now works like a credit card payment
    }
}
```
