
The **Editor component** is the primary text-input surface of the application.  

It enables users to **create, edit, and format Markdown content efficiently**, with a strong focus on **keyboard-first workflows**, **clarity**, and **low cognitive load**.

---
## Core Responsibilities

The Editor must:

- Allow users to **write raw Markdown**
- Provide **keyboard shortcuts** for common formatting
- Maintain **cursor and selection accuracy**
- Persist content reliably
- Integrate seamlessly with **Preview** and **Sidebar** components

---
### Functional Requirements

**Text Input**: Use a `<textarea>` (initial version) or editor engine (future). Should support:

 - Multi-line input
- Large documents
- Continuous typing without lag

**Cursor & Selection Handling**: The Editor must:

- Track cursor position (`selectionStart`, `selectionEnd`)
- Preserve cursor position after:
    - Formatting actions
    - Keyboard shortcuts
    - Content updates
- Allow programmatic selection (used for placeholders)

---
### Markdown Formatting Actions

The Editor must support **inline formatting** using a generic insertion mechanism.

| Action      | Syntax       | Behavior                             |
| ----------- | ------------ | ------------------------------------ |
| Bold        | `**text**`   | Wrap selection or insert placeholder |
| Italic      | `_text_`     | Wrap selection or insert placeholder |
| Inline code | `` `text` `` | Wrap selection                       |
| Heading     | `#`          | Insert at cursor                     |
| List item   | `-`          | Insert at cursor                     |
| Quote       | `>`          | Insert at cursor                     |

---
### Keyboard Shortcuts

The Editor must support:

| Shortcut       | Action            |
| -------------- | ----------------- |
| `Tab`          | Insert two spaces |
| `Ctrl/Cmd + B` | Bold              |
| `Ctrl/Cmd + I` | Italic            |

---
