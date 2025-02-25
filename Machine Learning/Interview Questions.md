Q. What is a **Feature**?

An input variable to a machine learning model.

---

Q. What is **Inference**?

The process of making predictions by applying a trained model to unlabelled examples.

---

Q. What is a **Feature Vector**?

The array of feature values comprising an example. The feature vector is input during **training** and during **inference**.

> **NOTE:** The term **dimension** is a synonym for the number of elements in a feature vector.

---

Q. **Can a machine learning model can train directly on raw string values without converting these values to numerical vectors?**

No, a machine learning model can only train on features with floating-point values, so you'll need to convert those strings to unique index numbers before training.

> **NOTE:** If categorical feature data is left as **raw indexed integers** and fed into a model without proper encoding, it can lead to incorrect assumptions and poor model performance. For example, if we assign numeric labels (`Red = 1`, `Blue = 2`, `Green = 3`), the model might assume `Green is closer to Blue than to Red`, which isn't meaningful.

---

Q. What is **One-Hot Encoding**?

In **One-Hot Encoding**, each category is represented by a binary vector (array) of N elements, where N is the number of categories. 

For example, if `car_color` has eight possible categories, then the one-hot vector representing will have eight elements. Exactly one of the elements in a one-hot vector has the value `1`, all the remaining elements have the value `0`.

![[one-hot-encoding.png]]

> **NOTE:** Avoid **One-Hot Encoding** when the categorical variable has a **high number of unique categories** (e.g., ZIP codes, product IDs).

---

Q. 


