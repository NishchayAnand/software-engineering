
```
Example 1:

class Main {
    
    static {
        System.out.println("Static block 1");
    }
    
    Main() {
        System.out.println("Constructor executed");
    }

    {
        System.out.println("Instance block 1 executed");
    }

    {
        System.out.println("Instance block 2 executed");
    }

    static {
        System.out.println("Static block 2");
    }
    
    public static void main(String[] args) {
        Main t1 = new Main();
        Main t2 = new Main();
    }
}
```

```
Static block 1
Static block 2
Instance block 1 executed
Instance block 2 executed
Constructor executed
Instance block 1 executed
Instance block 2 executed
Constructor executed
```

```
class Parent {
    static {
        System.out.println("Parent static block");
    }
    
    {
        System.out.println("Parent instance block");
    }

    Parent() {
        System.out.println("Parent constructor executed");
    }
}

class Child extends Parent {
    static {
        System.out.println("Child static block");
    }
    
    {
        System.out.println("Child instance block");
    }

    Child() {
        System.out.println("Child constructor executed");
    }

    public static void main(String[] args) {
        
    }
}

class Main {
    public static void main(String[] args) {
        Child c = new Child();
    }
}
```

```
Parent static block
Child static block
Parent instance block
Parent constructor executed
Child instance block
Child constructor executed
```

```
class Main {
    
    static {
        System.out.println("Static block executed");
        return; // Try to return from static block
    }

    public static void main(String[] args) {
        System.out.println("Main method executed");
    }
    
}
```

```
ERROR!
Main.java:8: error: return outside method
        return; // Try to return from static block
        ^
1 error
```

