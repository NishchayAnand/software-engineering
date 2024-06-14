# SQL Interview Questions

**Q. Use ID or Text String?**

Whether you store an ID or a text string is a question of duplication. When you ue an ID, the information that is meaningful to humans is stored in only one place, and everything that refers to it uses an ID (which only has meaning within the database).

When you store the text directly, you are duplicating the human-meaningful information in every record that uses it.

The advantage of using an ID is that because it has no meaning to humans, it never needs to change: _the ID can remain same, even if the information it identifies changes_. Anything that is meaningful to humans may need to change sometime in the future, and if that information is duplicated, all the redundant copies need to be updated. That incurs write overheads and risks inconsistencies (where some copies of the information are updated but others aren't). _Removing such duplication is the key idea behind **normalization** in databases_.
