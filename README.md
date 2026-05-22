# 🎮 Java Fundamentals Master

A comprehensive, menu-driven console application demonstrating **ALL core Java fundamentals** through an interactive Number Guessing Game and Pattern Generator.

---

## 📚 Concepts Covered

| Category | Concepts Demonstrated |
|----------|---------------------|
| **Variables & Data Types** | `int`, `double`, `char`, `boolean`, `String`, `Scanner` |
| **Operators** | Arithmetic (`+ - * / %`), Relational (`== != &gt; &lt;`), Logical (`&& \|\| !`), Bitwise (`& \| ^ ~ &lt;&lt; &gt;&gt;`), Assignment (`= += -= *= /= %=`), Increment (`++ --`), Ternary (`? :`) |
| **Control Flow** | `if-else if-else`, `switch`, `for`, `while`, `do-while`, `break`, `continue` |
| **Type Casting** | Implicit & explicit: `int ↔ double`, `char ↔ int`, `String → int` |
| **Arrays** | Declaration, initialization, iteration, element shifting |
| **OOP** | Classes, objects, constructors, encapsulation, composition |
| **Methods** | Instance & static methods, method overloading, return types |
| **Exception Handling** | `try-catch` for `NumberFormatException` |
| **Utility Classes** | `Random`, `Math`, `Scanner`, `String` manipulation |

---

## 🎯 Features

### 1. Number Guessing Game
- **3 Difficulty Levels**: Easy (1-50), Medium (1-100), Hard (1-200)
- **Smart Hint System**: Distance feedback, even/odd hints after 3 attempts
- **Dynamic Scoring**: Based on attempts used, accuracy, and difficulty multiplier
- **High Score Tracking**: Persistent score history with visual bar charts

### 2. Pattern Generator
- **Number Pyramid**: Symmetric numeric triangle
- **Star Diamond**: Full diamond with alternating rows
- **Character Triangle**: ASCII casting demo (Uppercase, Lowercase, Digits, Symbols)
- **Binary Pattern**: Bitwise operators visualization
- **Multiplication Table**: Formatted grid with square number highlighting

### 3. Java Fundamentals Demo
- Interactive showcase of every operator and control structure
- Live examples with your own values

---

## 🚀 How to Run

### Prerequisites
- Java JDK 17 or higher
- Any terminal or IDE (Eclipse, IntelliJ, VS Code)

### Compile & Run
```bash
# Clone the repository
git clone https://github.com/ManojGouda120502/java-fundamentals-game.git

# Navigate to project
cd java-fundamentals-game

# Compile
javac src/GameApp.java

# Run
java -cp src GameApp
