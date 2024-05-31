# Understanding XML

Extensible Markup Language (XML) lets you define and store data in a shareable manner.

XML supports information exchange between computer systems such as **websites**, **databases**, and **third-party applications**.

---

An XML tag puts a label on a piece of data that identifies it. For example, `<message>...</message>`.

In the same way that you define the field names for a data structure, you are free to use any XML tags that make sense for a given application. Naturally, **for multiple applications to use the same XML data, they must agree on the tag names they intend to use.**

Predefined rules make it easy to transmit data as XML files over any network because the recipient can use those rules to read the data accurately and efficiently.

## XML Schema

An Extensible Markup Language (XML) schema is a document that describes some rules or limits on the structure of an XML file.

XML schema describes data types, individual XML schema instances (documents), and groups of such instances in a complex schema language.

A concrete XML schema is also referred to as an XSD (XML Schema Definition) and usually has the extension ".xsd" as a file. Unlike DTDs, XML Schemas can be used to distinguish between the name of the XML type and the name of the XML tag used in the instance.

- **Document Type Definition (DTD):** Specifies the structure and rules for an XML document.
- **XML Schema (XSD):** A more powerful way to define the structure, data types, and constraints of XML documents. It uses XML syntax.

## XML Namespace

An XML namespace is a collection of XML elements and attributes identified by an Internationalized Resource Identifier (IRI). This collection is often referred to as an XML "vocabulary".

One of the primary motivations for defining an XML namespace is to avoid naming conflicts when using and re-using multiple vocabularies.

**Namespaces are similar to packages in Java in several ways:**

- A package in Java can have many reusable classes and interfaces. Similarly, a namespace in XML can have many reusable elements and attributes.

- To use a class or interface in a package, you must fully qualify that class or interface with the package name. Similarly, to use an element or attribute in a namespace, you must fully qualify that element or attribute with the namespace.

- A Java package may have an inner class that is not directly inside the package, but rather "belongs" to it by the virtue of its enclosing class. The same is true for namespaces: there could be elements or attributes that are not directly in a namespace, but belongs to the namespace by virtue of its parent or enclosing element.

## How Can You Use XML?

There are several basic ways to use XML:

- Traditional data processing, where XML encodes the data for a program to process.

- Document-driven programming, where XML documents are containers that build interfaces and applications from existing components.

- Archiving--the foundation for document-driven programming--where the customized version of a component is saved (archived) so that it can be used later.

- Binding, where the DTD or schema that defines an XML data structure is used to automatically generate a significant portion of the application that will eventually process that data.
