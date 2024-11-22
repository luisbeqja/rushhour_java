## Git Best Practices for the Project

These are the rules to follow whenever you need to make a change in the Git repository.

---

### Clone the Repository

To clone the repository, use the following command:

```bash
git clone git@gitlab.com:kdg-ti/integration-1.1/2024-2025/projects/ACS104_Team3.git
```

Before cloning, ensure you have created an SSH key on your PC and added it to your GitLab account.

---

### Commit

Follow the best practices for writing commit messages:

```
bugfix: <description of the bug fixed>
---------------------------------------
feature: <description of the new feature added>
```

Ensure the commit messages are concise yet descriptive, explaining the purpose of the changes.

---

### Push

When you're ready to push your changes, follow these steps:

1. **Create a new branch**:
   - For bug fixes: `bugfix/<name-of-the-branch>`
   - For new features: `feature/<name-of-the-branch>`

2. **Push your branch** to the repository:

   ```bash
   git push origin <branch-name>
   ```

3. **Open a Pull Request (PR)** to the `development` branch.

---

### Pull Request Guidelines

When creating a PR, include a clear description of the changes made in the branch. Be specific about what has been added, fixed, or updated.

A well-written PR description helps reviewers understand the context and purpose of the changes.

---

### Final Notes

- Always pull the latest changes from the `development` branch before starting new work:

  ```bash
  git pull origin development
  ```

- Keep your branches small and focused on a single purpose to make reviewing easier.
