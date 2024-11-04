# Model-View-Controller

## Overview
MVC is a design pattern that separates an application into three interconnected components: Model, View, and Controller. It organizes code to separate concerns and improve maintainability.

## Components
| Component  | Description                                                                     |
|------------|---------------------------------------------------------------------------------|
| Model      | Contains business logic and custom objects.                                     |
| View       | Generates the output to display to the client.                                  |
| Controller | Sends commands to the model and view, and passes objects around where required. |

## Importance
- **Separates Concerns**: Divides an application into distinct components, each handling specific responsibilities.
- **Enhances Maintainability**: Changes in one component do not directly affect others, making it easier to manage and update code.
- **Improves Reusability**: Components can be reused across different parts of the application or in different projects.

## Implementation
- **Model**: Manages the data and business logic of the application.
- **View**: Handles the user interface and presentation of data. 
- **Controller**: Manages user input and updates the Model and View accordingly.

## Example
```java
// Model
class Model {
private String data;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

// View
class View {
    public void display(String data) {
        System.out.println("Displaying data: " + data);
    }
}

// Controller
class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    void updateData(String data) {
        model.setData(data);
        view.display(model.getData());
    }
}

// Main application
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.updateData("Hello MVC!");
    }
}
```
In the code above:
- Model represents the data and business logic, providing methods to get and set data.
- View handles the presentation, with a method to display data to the user.
- Controller manages the interaction between Model and View, updating the Model and then instructing the View to display the updated data.
- Main demonstrates how the Controller orchestrates the interaction between Model and View, illustrating how MVC separates concerns and manages application flow.
