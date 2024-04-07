# Understanding Interface Segregation Principle

- States that "Clients should not be forced to depend upon interfaces that they do not use."
- By following this principle, you prevent bloated interfaces that define methods for multiple responsibilities, and respecting it helps us also to observe the Single Responsiblity Principle.

- Classes which implement small interfaces will be less likely to accumulate multiple responsibilties.

- Maximized Cohesion: The measure of how strong the methods and data of a class belong together: interdependence within a class.

- Minimized Coupling: The meaure of how strongly different classes depend on one another: interdependence between classes.

- Closely related to the concept of coupling. When two or more details are intermixed in the same class, it introduces tight coulping between these details. If the details change at different times due to different reasons, it's likely to cause problems in the future.
