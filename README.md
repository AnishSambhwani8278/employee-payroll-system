# 🚀 Employee Payroll System (Java OOPs-Based) 🚀

Welcome to the **Employee Payroll System** project! This is a console-based application built in **Java** utilizing **Object-Oriented Programming (OOP)** principles to manage employee payroll data efficiently. The system supports adding, removing, and viewing employee details, as well as calculating and editing salaries for both **Full-Time** and **Part-Time** employees.

---

## 💡 Key Features:

- **📋 Employee Management:** Add, remove, and view employee details with ease.
- **💰 Salary Management:** Calculate and update salaries for both **Full-Time** and **Part-Time** employees.
- **🔄 Real-Time Updates:** Dynamic salary management with real-time changes to employee data.

---

## 🔑 OOP Concepts Implemented:

- **Abstraction:**  
  The `Employee` class is an **abstract** class that defines common attributes such as name and ID, along with the abstract method `calculateSalary()`. This hides implementation details, simplifying the user experience.

- **Inheritance:**  
  The `FullTimeEmployee` and `PartTimeEmployee` classes inherit from the `Employee` class, ensuring **code reuse** and allowing specialized behavior for each employee type.

- **Polymorphism:**  
  By overriding the `calculateSalary()` method in the subclasses, the system demonstrates **runtime polymorphism**, where the correct salary calculation method is called depending on the type of employee.

- **Encapsulation:**  
  Employee data (like name, ID, and salary) is **encapsulated** using **private** variables, ensuring data integrity and controlled access through **public methods**.

---

## 📦 Tech Stack:

- **Java (Core OOP Principles)**
- **Console-Based User Interface**
