
Machine learning is the intersection of two disciplines: **data science** and **software engineering**.

**The goal of machine learning is to use data to create a predictive model that can be incorporated into a software application or service.** 

To achieve this goal requires collaboration between data scientists who **explore and prepare the data** before using it to train a machine learning model, and software developers who **integrate the models into applications** where they're used to predict new data values (a process known as **inferencing**).

---
## Thinking in Mathematical Terms

Because machine learning is based on mathematics and statistics, it's common to think about machine learning models in mathematical terms. 

Fundamentally, a machine learning model is a software application that encapsulates a **_function_** to calculate an output value based on one or more input values. The process of defining that function is known as **training**. 

After the function has been defined, you can use it to predict new values in a process called **inferencing**.

---
## Flow of Machine Learning

1. The training data consists of past observations. In most cases, the observations include the observed attributes or **features** of the thing being observed, and the known value of the thing you want to train a model to predict (known as the **label**).

2. An **algorithm** is applied to the data to try to determine a relationship between the **features (x)** and the **label (y)**, and generalise that relationship as a calculation that can be performed on **x** to calculate **y**. 

3. The result of the algorithm is a **model** that encapsulates the calculation derived by the algorithm as a **function**.

> **NOTE:** The specific algorithm used depends on the kind of predictive problem you're trying to solve, but the basic principle is to try to **fit a function to the data**, in which the values of the **features** can be used to calculate the **label**.

---
## Iterative Training

In most real-world scenarios, a data scientist will use an iterative process to repeatedly train and evaluate a model, varying:

- Feature selection and preparation (choosing which features to include in the model, and calculations applied to them to help ensure a better fit).
- Algorithm selection.
- Algorithm parameters (numeric settings to control algorithm behaviour, more accurately called **hyperparameters** to differentiate them from the **x** and **y** parameters).

After multiple iterations, the model that results in the best evaluation metric is selected.

---
## Supervised Machine Learning

Supervised machine learning is a general term for machine learning algorithms in which the **training data includes both feature values and known label values**. 

Supervised machine learning is used to train models by determining a relationship between the features and labels in past observations, so that unknown labels can be predicted for features in future cases.

---
### Regression - Supervised Machine Learning

**Regression** is a form of **supervised machine learning** in which the label predicted by the model is a numeric value.

---
#### Mean Absolute Error (MAE) - Regression Evaluation Metrics

A statistical measure used to evaluate the performance of a predictive model by calculating the average of the absolute differences between the predicted values and the actual values.

It gives an indication of how far off predictions are, on average, from the true values. It doesn't matter if the prediction was over or under the actual value (so for example, **-3 and +3 both indicate a variance of 3**).

> **NOTE:** Since, MAE treats all errors equally, a model with **occasional large errors** might still have a reasonable MAE (as large errors aren't penalised more heavily than small ones).

---
#### Mean Squared Error (MSE) - Regression Evaluation Metrics

A commonly used metric in regression analysis to measure the average squared difference between the predicted values and the actual values.

A model with **occasional large errors** will have a much higher MSE, as large errors have a quadratic impact.

When **predictability** is the priority, having a model that produces consistent, small errors is far more desirable than one that achieves higher accuracy on average but occasionally makes large, unpredictable errors. 

**Example:** In stock price predictions, avoiding large outlier predictions is often more critical than reducing minor prediction inaccuracies.

> **NOTE:** MSE helps take the magnitude of errors into account, but because it squares the error values, the resulting metric no longer represents the quantity measured by the label.
> 
> This makes the MSE less interpretable because it doesn't directly convey how much the model's predictions deviate from the actual values in the original measurement units.

---
#### Root Mean Squared Error (RMSE) - Regression Evaluation Metrics

Taking the square root of MSE restores the metric to the original units of the target variable. 

RMSE is more interpretable because it represents the average magnitude of the errors in the same units as the label.

---
#### Coefficient of determination (R^2)

A statistical measure used to assess how well a regression model explains the variability of the target variable. 

It provides a numerical value (typically between 0 and 1) that indicates the proportion of variance explained by the model. **In simple terms, the closer to 1 this value is, the better the model is fitting the validation data.**

---
### Classification - Supervised Machine Learning

Classification is a form of supervised machine learning in which the label represents a categorisation, or class.

---
#### Binary Classification - Supervised Machine Learning

_Binary classification_ algorithms are used to train a model that predicts one of two possible labels for a single class. Essentially, predicting _**true**_ or _**false**_.

In most real scenarios, the data observations used to train and validate the model consist of multiple feature (_**x**_) values and a _**y**_ value that is either **1** or **0**.

We'll use an algorithm to fit the training data to a function that calculates the _probability_ of the class label being _true_ (e.g., the probability of a patient having diabetes). 

**Confusion Matrix**: a matrix of the number of correct and incorrect predictions for each possible class label. 

![[Pasted image 20250204123607.png]]

---
## Unsupervised Machine Learning

Unsupervised machine learning involves training models using data that consists only of feature values without any known labels. 

---
### Clustering - Unsupervised Machine Learning

A clustering algorithm identifies similarities between observations based on their features, and groups them into discrete clusters. For example:

- Group similar flowers based on their size, number of leaves, and number of petals.
- Identify groups of similar customers based on purchasing behaviour.

In some ways, clustering is similar to multi-class classification in that it categorises observations into discrete groups. 

The difference is that when using classification, you already know the classes to which the observations in the training data belong, so the algorithm works by determining the relationship between the features and the known classification label. 

In clustering, there's no previously known cluster label and the algorithm groups the data observations based purely on similarity of features.

> **NOTE:** In some cases, clustering is used to determine the set of classes that exist before training a classification model. For example, you might use clustering to segment your customers into groups, then use the labeled data to train a classification model that predicts to which customer category a new customer might belong.

---
