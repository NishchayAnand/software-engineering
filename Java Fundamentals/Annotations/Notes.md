# Understanding Annotations in Java

## What are Annotations?

Special types that act as metadata. Allows us to attach metadata to a target. No direct affect on target behavior. Allow other code to act on our metadata.

Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.

Provide a structured way to express context and intent.
Allow tools and other code to act on context and intent.

metadata provided by the annotation gets added to the class information and can be accessed using the getClass().getAnnotation() method.

## Why Annotations?

Annotations have a number of uses, among them:

- **Information for the compiler** — Annotations can be used by the compiler to detect errors or suppress warnings.
- **Compile-time and deployment-time processing** — Software tools can process annotation information to generate code, XML files, and so forth.
- **Runtime processing** — Some annotations are available to be examined at runtime.

Things like XML and JSON processors use annotations to simplify mapping between the Java types you and their XML or JSON representations.

## How to create Custom Annotation?

The at sign character (@) indicates to the compiler that what follows is an annotation.

Annotations are a special type of interface.
Cannot be explicitly implemented.
Implicitly extend the Annotation interface.
Can be declared within a class or interface.

Annotations can optionally have elements. An element is simply a way that we specify a value within an annotation. Elements are declared as if they are methods. Set values similar to fields.

Can specify allowable targets

Marker interface were before annotations were introduced. A marker interface (also called a tag interface) has no methods to implement and exists so that you can announce to the world that, "Yes, I can do this."
