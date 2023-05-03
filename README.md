# Utilities


![Version Badge](https://img.shields.io/badge/version-alpha-blue)
![MIN_SDK Badge](https://img.shields.io/badge/MIN_SDK-Java_17-red)
![license Badge](https://img.shields.io/badge/License-MIT-gree)
![Maven_Central Badge](https://img.shields.io/badge/maven_central-pending-brown)
![Type Badge](https://img.shields.io/badge/Software_Typ-utilities-green)

This API contains multiple different Utility-Classes with use-cases that might come in handy in other projects such as utilities surrounding native Java classes

---

## Third-Party-Usages and Licenses
- [X] [Eclipse Public Licence - v 2.0](https://github.com/junit-team/junit5/blob/main/LICENSE.md)
  - [X] Junit Jupiter API


--- 
## Maven-Dependency
Add the following dependency to the `pom.xml` file
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
- [X] LongUtilities
- [ ] FileUtilities


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

## Having problems? No problem!
For better debugging enable assertions:
1. Open the Run-Configurations-Tab
2. Click on Modify options
3. Click on Add VM options
4. Insert `-ea` into the text-field
5. Run the program

Above example is for Intellij-Users only. For other IDEs you might have to look it up yourself.

---
&copy; Tecuilacat 2023