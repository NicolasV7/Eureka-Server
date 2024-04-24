# Eureka Server

## 🧞 Commands

All commands are run from the root of the project, from a terminal:

| Command                   | Action                                           |
| :------------------------ | :----------------------------------------------- |
| `mvn spring-boot:run`             | Run service                            |
| `mvn clean install`             | Build service                            |

## 📚 Decorators
| Annotation     | Description |
| -------------- | ----------- |
| `@Id`          | Specifies the primary key of an entity. |
| `@GeneratedValue` | Provides for the specification of generation strategies for the values of primary keys. |
| `@Column`      | Specifies the mapped column for a persistent property or field. |
| `@PrePersist`  | Callback method annotation. When a new entity is persisted, methods annotated with `@PrePersist` are executed. |
| `@Temporal`    | Converts the date and time values from Java object to compatible database type and vice versa. |
| `@Transactional` | Defines the scope of a single database transaction. |


## 📝 Spring Boot Concepts

| Concept | Explanation |
| :------ | :---------- |
| `ResponseEntity<?>` | Represents the entire HTTP response. You can specify status code, headers, and body. The `<?>` is a wildcard representing any type of body in the response. |
| `Optional` | A container object which may or may not contain a non-null value. It's used to represent nullable return types, so you don't have to check for `null` values. |
| `@PathVariable` | A Spring annotation which indicates that a method parameter should be bound to a URI template variable. If the method parameter is `Map<String, String>`, then all the path variables are added to the map. |

## Generic Component in Java

A generic component in Java refers to generic classes, interfaces, and methods. Generics allow types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.

The idea is to allow the type (class or interface) to be a parameter to a class or method, and that type is used wherever necessary, thereby providing compile-time type safety.

Here is a simple example of a generic class in Java:

```java
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
```

## 📷 Screenshots

Eureka Server:
![Screenshot](usuarios/src/main/resources/img/000.png)

Client Service:
![Screenshot](usuarios/src/main/resources/img/0000.png)

## 📦 Requirements

| Requirement | Version |
| :---------- | :------ |
| Java        | 21      |