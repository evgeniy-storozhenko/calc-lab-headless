# calc-lab-headless
The console environment for numerical computations. Eclipse based java application.

```
Calculation Laboratory Headless command line arguments:
	-input, -i:	Input expression for calculation
	-file, -f:	Input file for calculation
	-row, -r:	Output result of calculation as row
	-html, -H:	Output result of calculation as html
	-help, -h, -?:	Help
	-version, -v:	Current version
```

## Examples of use
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