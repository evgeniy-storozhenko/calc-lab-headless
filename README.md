# calc-lab-headless
The console environment for numerical computations. Eclipse based java application.

[Download last build](http://calc-lab.com:8080/job/calc-lab-headless/lastStableBuild/artifact/build/product/target/calclab-headless-1.0.0-SNAPSHOT.zip)

[![Build Status](http://calc-lab.com:8080/buildStatus/icon?job=calc-lab-headless&build=6)](http://calc-lab.com:8080/job/calc-lab-headless/6/)


## Usage
```
Calculation Laboratory Headless command line arguments:
	-input, -i:	Input expression for calculation
	-file, -f:	Input file for calculation
	-row, -r:	Output result of calculation as row
	-html, -H:	Output result of calculation as html
	-help, -h, -?:	Help
	-version, -v:	Current version
```

## Examples
### Continuous mode
```
evgeny@furious: ~/Desktop/calclab-headless $ ./calclab.sh
> 2+2
	= 4

> a=24/(8-5)
	= 8

> log(2,a)
	= 3
```

### Single mode
```
evgeny@furious: ~/Desktop/calclab-headless $ ./calclab.sh -i "13^8;a=2;b=3*a;"
13^8 = 815730721
a=2 = 2
b=3*a = 6
```
