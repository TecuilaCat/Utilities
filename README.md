# Utilities


![Version Badge](https://img.shields.io/badge/version-1.0.1-blue)
![MIN_SDK Badge](https://img.shields.io/badge/MIN_SDK-Java_17-red)
![Maven_Central Badge](https://img.shields.io/badge/maven_central-pending-brown)
![Type Badge](https://img.shields.io/badge/Software_Typ-utilities-green)

This API contains multiple different Utility-Classes with use-cases that might come in handy in other projects such as utilities surrounding native Java classes

---

## Third-Party-Usages and Licenses
- [X] [Eclipse Public Licence - v 2.0](https://github.com/junit-team/junit5/blob/main/LICENSE.md)
  - [X] Junit Jupiter API


--- 
## Maven-Dependency
Add the following dependendy to the `pom.xml` file
```xml
<dependency>
    <groupId>com.github.tecuilacat</groupId>
    <artifactId>Utilities</artifactId>
    <version>1.0.1</version>
</dependency>
```

---
## Usable classes
- [X] StringUtilities
- [X] IntegerUtilities
- [X] DoubleUtilities
- [X] LocalDateUtilities


---

## Example

```java
import com.github.tecuilacat.utilities.modes.UtilitiesSortMode;
import com.github.tecuilacat.utilities.utils.IntegerUtilities;
import com.github.tecuilacat.utilities.utils.StringUtilities;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        StringUtilities.getMatchingSubstringsIgnoreCase("This is a test!", "this|test")
                .forEach(System.out::println);

        System.out.println(" ");

        IntegerUtilities.getSortedCollection(Arrays.asList(5, 3, 2, 1, 7), UtilitiesSortMode.DESCENDING)
                .forEach(System.out::println);
    }
}
```

Result:
> This  
> test  
>  
> 7  
> 5  
> 3  
> 2  
> 1


---
&copy; Tecuilacat 2023