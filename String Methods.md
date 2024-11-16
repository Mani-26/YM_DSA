## .charAt()
```java
public class CharAtExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str.charAt(1)); // e
    }
}
```

## .compareTo()
```java
public class CompareToExample {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "Banana";
        System.out.println(str1.compareTo(str2)); // Negative value
    }
}
```

## .compareToIgnoreCase()
```java
public class CompareToIgnoreCaseExample {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "apple";
        System.out.println(str1.compareToIgnoreCase(str2)); // 0
    }
}
```

## .concat()
```java
public class ConcatExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = " World";
        System.out.println(str1.concat(str2)); // Hello World
    }
}
```

## .contains()
```java
public class ContainsExample {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.contains("World")); // true
    }
}
```

## .equals()
```java
public class EqualsExample {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "Java";
        System.out.println(str1.equals(str2)); // true
    }
}
```

## .equalsIgnoreCase()
```java
public class EqualsIgnoreCaseExample {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "java";
        System.out.println(str1.equalsIgnoreCase(str2)); // true
    }
}
```

## .indexOf()
```java
public class IndexOfExample {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.indexOf('o')); // 4
    }
}
```

## .length()
```java
public class LengthExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str.length()); // 5
    }
}
```

## .replaceAll()
```java
public class ReplaceAllExample {
    public static void main(String[] args) {
        String str = "Java is fun!";
        System.out.println(str.replaceAll("fun", "awesome")); // Java is awesome!
    }
}
```

## .split()
```java
public class SplitExample {
    public static void main(String[] args) {
        String str = "apple,banana,cherry";
        String[] fruits = str.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit); // apple, banana, cherry
        }
    }
}
```

## .toCharArray()
```java
public class ToCharArrayExample {
    public static void main(String[] args) {
        String str = "Hello";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.println(c); // H e l l o
        }
    }
}
```

## .toLowerCase()
```java
public class ToLowerCaseExample {
    public static void main(String[] args) {
        String str = "HELLO";
        System.out.println(str.toLowerCase()); // hello
    }
}
```

## .toUpperCase()
```java
public class ToUpperCaseExample {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.toUpperCase()); // HELLO
    }
}
```

## .trim()
```java
public class TrimExample {
    public static void main(String[] args) {
        String str = "   Hello World   ";
        System.out.println(str.trim()); // "Hello World"
    }
}
```

## .substring()
```java
public class SubstringExample {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.substring(6)); // World
    }
}
```

## Character.isWhiteSpace()
```java
public class IsWhiteSpaceExample {
    public static void main(String[] args) {
        char c = ' ';
        System.out.println(Character.isWhitespace(c)); // true
    }
}
```

## Character.isLetter()
```java
public class IsLetterExample {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println(Character.isLetter(c)); // true
    }
}
```

## Character.isLetterOrDigit()
```java
public class IsLetterOrDigitExample {
    public static void main(String[] args) {
        char c = '1';
        System.out.println(Character.isLetterOrDigit(c)); // true
    }
}
```

## Character.isDigit()
```java
public class IsDigitExample {
    public static void main(String[] args) {
        char c = '9';
        System.out.println(Character.isDigit(c)); // true
    }
}
```

## Character.isLowerCase()
```java
public class IsLowerCaseExample {
    public static void main(String[] args) {
        char c = 'a';
        System.out.println(Character.isLowerCase(c)); // true
    }
}
```

## Character.isUpperCase()
```java
public class IsUpperCaseExample {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println(Character.isUpperCase(c)); // true
    }
}
```

## Character.toLowerCase()
```java
public class ToLowerCaseCharExample {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println(Character.toLowerCase(c)); // a
    }
}
```

## Character.toUpperCase()
```java
public class ToUpperCaseCharExample {
    public static void main(String[] args) {
        char c = 'a';
        System.out.println(Character.toUpperCase(c)); // A
    }
}
```