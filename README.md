# L5XParser[^1] [![Java CI with Maven](https://github.com/DanielSzczesny/L5XParser/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/DanielSzczesny/L5XParser/actions/workflows/maven.yml)
Java L5X Parser for Logix 5000 PLC's

Main reason for creating this project was to find typos in the PLC code

To start application

```java
java -jar JarFileName.jar
```

Application will search a current folder in case of .L5X and .csv files which names match 
e.g. PLC_Code.L5X and PLC_Code.csv. <br />
For each pair report will be generated in folder Reports.



## TODO
- [x] Parse XML to Java Objects
- [x] Prepare basic mapping of typos
- [x] Save result to .txt file
- [ ] Prepare advanced mapping of typos
- [ ] User interface

[^1]:MIT License
  Copyright (c) 2022 Daniel Szczęsny
  Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
  The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
