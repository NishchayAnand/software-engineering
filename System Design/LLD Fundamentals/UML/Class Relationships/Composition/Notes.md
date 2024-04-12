# Understanding Composition

Composition is a stronger form of aggregation. It represents a "part-of" relationship. The whole object is responsible for the lifecycle of the part object. In simpler terms, if the whole object is destroyed, the part object is also destroyed.

Example: Book and Chapter

A book is composed of chapters, and chapters wouldn't typically exist outside the context of a book.

```
class Chapter {
  private String title;
  private String content;

  public Chapter(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }
}

class Book {
  private String title;
  private List<Chapter> chapters;

  public Book(String title, List<Chapter> chapters) {
    this.title = title;
    this.chapters = chapters;
  }

  public String getTitle() {
    return title;
  }

  public List<Chapter> getChapters() {
    return chapters;
  }
}

```
