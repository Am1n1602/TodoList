# Todo List

A simple Todo List app built using Kotlin for Android.

---

## Description

This project is a basic Todo List application where users can add, mark as complete, and delete their tasks.  
**On the `db` branch, the app is enhanced with persistent storage using a local database.**  
This means that todos are saved between app launches, providing a more robust user experience.

<p align="center">
<img src="Todo_main.png" alt="Main Screenshot" style="width:528px;max-width: 100%;">
</p>

---

## Features

- **Add new todos** by entering a title and pressing the add button.
- **Mark tasks as completed** with a checkbox (completed tasks have a strikethrough).
- **Remove all completed todos** with the delete button.
- **Persistent storage**: Todos are saved to a local database (Room), so your list persists between sessions. *(db branch only)*
- Responsive, clean UI using Material Design components.
- Built with Android's RecyclerView for efficient list handling.

---

## Getting Started

### Prerequisites

- Android Studio (latest recommended)
- Android SDK version 24 or higher

### Build & Run

1. Clone the repository and checkout the `db` branch:
   ```sh
   git clone https://github.com/Am1n1602/TodoList.git
   cd TodoList
   git checkout db
   ```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

---

## File Structure

- `app/src/main/java/com/example/todolist/`
  - `MainActivity.kt` - Main activity and entry point for the app.
  - `Todo.kt` - Data class representing a single todo item.
  - `TodoAdapter.kt` - RecyclerView adapter for managing and displaying todos.
  - `TodoDatabase.kt` *(db branch only)* - Database setup and access objects.
  - `ui/theme/` - Custom app theming.
- `app/src/main/res/layout/` - XML layout files for UI components.

---

## Notes on the `db` Branch

- The `db` branch introduces a database layer (using Room, Android's recommended SQLite abstraction).
- This allows todos to persist even after the app is closed.
- The rest of the app logic and UI remain simple and beginner-friendly.

---
