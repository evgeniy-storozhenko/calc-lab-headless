# calc-lab-headless
The console environment for numerical computations. Eclipse based java application.

[Download last build](http://calc-lab.com:8080/job/calc-lab-headless/lastStableBuild/artifact/build/product/target/calclab-headless-1.0.0-SNAPSHOT.zip)

[![Build Status](http://calc-lab.com:8080/job/calc-lab-headless/lastStableBuild/badge/icon)](http://calc-lab.com:8080/job/calc-lab-headless/lastStableBuild/)


## Usage
```
Calculation Laboratory Headless command line arguments:
	-input, -i:	Input expression for calculation
	-file, -f:	Input file for calculation
	-row, -r:	Output result of calculation as row
	-html, -H:	Output result of calculation as html
	-scale, -s:	Scale determines the accuracy of calculations
	-display, -d:	Scale for display of numbers
	-help, -h, -?:	Help
	-version, -v:	Current version
```

## Examples
### Continuous mode
```
evgeny@furious: ~/Desktop/calclab-headless $ ./calclab.sh
Calculation Laboratory Headless version: 1.0.0
>> 2+2
ans = 4

>> a=24/(8-5)
a = 8

>> log(2,a)
ans = 3

>> help sin
ans

Function: sin

Syntax: sin(x)
Description: Sine of a number x. Argument is measured in radians. To calculate the sine an argument in degrees, use sind(x).

Example: 
	y = sin(0.5);
Result: 
	0.479425538604203
```

### Single mode
```
evgeny@furious: ~/Desktop/calclab-headless $ ./calclab.sh -i "13^8;a=2;b=3*a;"
13^8 = 815730721
a=2 = 2
b=3*a = 6
```
