
**Constraint Annotations** are **special markers** (annotations) you put on fields, method parameters, or return values to declare the rules they must follow, such as requiring a non-null value, enforcing a specific format, or limiting the size or range.

**Example**

```
import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;

    @Size(max = 100, message = "Description cannot exceed 100 characters")
    private String description;

    @FutureOrPresent(message = "Launch date cannot be in the past")
    private LocalDate launchDate;
}
```

These rules remain passive until the validation process is triggered, for example, through **`@Valid`** or **`@Validated`** in Spring Boot, at which point a validation engine, such as **Hibernate Validator**, checks the data against the declared constraints and raises errors if violations are found.

> **NOTE:** You need to include `spring-boot-starter-validation` in our Spring Boot application to use **Jakarta Bean Validation API**.

---

<span style="color:red;font-weight:bold">Q. Explain the difference between</span> `@NotNull`<span style="color:red;font-weight:bold;">,</span> `@NotEmpty` <span style="color:red;font-weight:bold;">and</span> `@NotBlank` <span style="color:red;font-weight:bold;">annotations.</span>

**`@NotNull`**

- **Purpose**: Ensures the value is **not `null`**.
- **Applies to**: Any object type.
- **Does not check**: For emptiness or whitespace, i.e., an empty string or empty collection still passes.

```
@NotNull String str; // "" ✅, null ❌
```

**`@NotEmpty`**

- **Purpose**: Ensures the value is **not `null`** **and** has a size/length > 0.
- **Applies to**: Strings, collections, maps, arrays.
- **Does not check**: For whitespace-only strings, however, `" "` still passes.

```
@NotEmpty String str; // "" ❌, " " ✅, null ❌
```

**`@NotBlank`**

- **Purpose**: Ensures the string is **not `null`**, has length > 0, and contains at least one **non-whitespace** character.
- **Applies to**: Strings only.
- **Stricter than** `@NotEmpty` for strings.

```
@NotBlank String str; // "" ❌, "   " ❌, null ❌, "abc" ✅
```

---
