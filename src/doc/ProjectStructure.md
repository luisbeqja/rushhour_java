## Project folder structure 
Following a simpler version of the [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)


### Explanation of the Project Structure

1. **`src/`**  
   This is the root folder for the source code.

2. **`src/doc/`**
    - in this folder there will be all the documentation of the project.
       - `ProjectStructure.md`: This document provides an overview of the project's structure (this file).
      - `GitBestPractice.md`: This document provides all the Git best practice for the repo.

3. **`src/main/`**  
   The main directory contains the primary logic of the game.
    - **`game/`**: Contains the core game classes.
    - **`Main`**: The entry point for the game application.
    - **`resources/`**: This directory will store any additional resources (e.g. levels) needed by the game.

4. **`README.md`**  
   This file, which serves as the project overview.

This structure ensures a clean and organized project, where code is separated into logical components and documentation is easily accessible.
