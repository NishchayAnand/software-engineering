# Understanding Decorator Pattern

**DEFINITION: The Decorator pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.**

The primary intent of a `Decorator` to give an object new responsibilities without making any code changes to its underlying class.

The java.io package is largely based on Decorator Pattern. For example, `FileInputStream` is decorated with `BufferedInputStream`.

## How it work?

The Decorator Pattern use **composition** and **delegation** to dynamically add new behavior to an existing object.

You wrap an object with another object. The wrapper, or decorator, contains (or "composes") an instance of the original object. This is **composition**.

The decorator forwards **(delegates)** requests to the wrapped object, potentially adding its own behavior before or after forwarding the request. This means the decorator can modify or enhance the behavior of the original object dynamically.

Decorators implement the same interface or abstract class as the objects they decorate. This ensures that the decorated objects can be used interchangeably with undecorated ones.

> **NOTE:** The Decorator Pattern promotes `Open-Close Principle` and `Liskov Subsitution Principle`.

---

## EXTRA

**Sample Code: Java**

A text editor where we want to add different formatting options such as bold, italic, and underline to a piece of text.

```
public interface Text {
    String getText();
}

public class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

public abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text text) {
        this.decoratedText = text;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}

public class BoldDecorator extends TextDecorator {

    public BoldDecorator(Text text) {
        super(text);
    }

    @Override
    public String getText() {
        return "<b>" + decoratedText.getText() + "</b>";
    }
}

public class ItalicDecorator extends TextDecorator {

    public ItalicDecorator(Text text) {
        super(text);
    }

    @Override
    public String getText() {
        return "<i>" + decoratedText.getText() + "</i>";
    }
}

public class UnderlineDecorator extends TextDecorator {

    public UnderlineDecorator(Text text) {
        super(text);
    }

    @Override
    public String getText() {
        return "<u>" + decoratedText.getText() + "</u>";
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, World!");

        System.out.println("Plain Text: " + text.getText());

        text = new BoldDecorator(text);
        System.out.println("Bold Text: " + text.getText());

        text = new ItalicDecorator(text);
        System.out.println("Bold and Italic Text: " + text.getText());

        text = new UnderlineDecorator(text);
        System.out.println("Bold, Italic, and Underlined Text: " + text.getText());
    }
}
```

## Disadvantages

Designs using Decorator Pattern often result in a large number of small classes that can be overwhelming to a developer trying to use the Decorator-based API.

> **NOTE:** We typically create decorators by using other patterns like **Factory** and **Builder**.
