![example workflow](https://github.com/andrewfitzy/2016-advent-of-code/actions/workflows/build_and_test.yml/badge.svg)
# 2016-advent-of-code

This repo contains the solutions for my path of Advent of Code 2016. I complete AoC to get familiar with a technology, its build tools and testing tools, it's kind of a mini-production type workflow I follow.

In this year I chose to use the following tools:
- [Kotlin v1.9.20](https://kotlinlang.org/docs/whatsnew1920.html). Build tools for this year's language of choice.
- [Gradle v8.1.1](https://docs.gradle.org/8.1.1/release-notes.html). From April 2023 which is when I set up this repo.
- [Spotless v6.25.0](https://github.com/diffplug/spotless/releases/tag/gradle%2F6.25.0). Also using the Ktlint formatting configuration [v1.1.1](https://github.com/pinterest/ktlint/releases/tag/1.1.1).
- [Detekt v1.23.3](). Code analysis tool which is useful for finding bugs.
- [Kotlin JUnit](https://kotlinlang.org/api/latest/kotlin.test/). Unit test framework with a Kotlin flavour.

All development was completed using IntelliJ which is an awesome development environment.

## Setup
There is a small setup script that copies the projects pre-commit file to the `hooks` folder of the project's repo. This needs to be run after the project is cloned only. 
```bash
$ ./gradlew initProject  
```

## Building
```bash
$ ./gradlew build  
```

## Testing
```bash
$ ./gradlew check  
```

## Committing
The pre-commit hook should kick-in, when it does it will run `spotless` and `detekt`
```bash
$ git add --all
$ git commit -a
```

## Progress
|                                                | Challenge                              |                                                            Task 1                                                            |                                                            Task 2                                                            |
|:-----------------------------------------------|:---------------------------------------|:----------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------:|
| [Day 01](https://adventofcode.com/2016/day/1)  | No Time for a Taxicab                  | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day01/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day01/Task02.kt) |
| [Day 02](https://adventofcode.com/2016/day/2)  | Bathroom Security                      | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day02/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day02/Task02.kt) |
| [Day 03](https://adventofcode.com/2016/day/3)  | Squares With Three Sides               | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day03/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day03/Task02.kt) |
| [Day 04](https://adventofcode.com/2016/day/4)  | Security Through Obscurity             |                                                                                                                              ||
| [Day 05](https://adventofcode.com/2016/day/5)  | How About a Nice Game of Chess?        |                                                                                                                              ||
| [Day 06](https://adventofcode.com/2016/day/6)  | Signals and Noise                      |                                                                                                                              ||
| [Day 07](https://adventofcode.com/2016/day/7)  | Internet Protocol Version 7            |                                                                                                                              ||
| [Day 08](https://adventofcode.com/2016/day/8)  | Two-Factor Authentication              |                                                                                                                              ||
| [Day 09](https://adventofcode.com/2016/day/9)  | Explosives in Cyberspace               |                                                                                                                              ||
| [Day 10](https://adventofcode.com/2016/day/10) | Balance Bots                           |                                                                                                                              ||
| [Day 11](https://adventofcode.com/2016/day/11) | Radioisotope Thermoelectric Generators |                                                                                                                              ||
| [Day 12](https://adventofcode.com/2016/day/12) | Leonardo's Monorail                    |                                                                                                                              ||
| [Day 13](https://adventofcode.com/2016/day/13) | A Maze of Twisty Little Cubicles       |                                                                                                                              ||
| [Day 14](https://adventofcode.com/2016/day/14) | One-Time Pad                           |                                                                                                                              ||
| [Day 15](https://adventofcode.com/2016/day/15) | Timing is Everything                   |                                                                                                                              ||
| [Day 16](https://adventofcode.com/2016/day/16) | Dragon Checksum                        |                                                                                                                              ||
| [Day 17](https://adventofcode.com/2016/day/17) | Two Steps Forward                      |                                                                                                                              ||
| [Day 18](https://adventofcode.com/2016/day/18) | Like a Rogue                           |                                                                                                                              ||
| [Day 19](https://adventofcode.com/2016/day/19) | An Elephant Named Joseph               |                                                                                                                              ||
| [Day 20](https://adventofcode.com/2016/day/20) | Firewall Rules                         |                                                                                                                              ||
| [Day 21](https://adventofcode.com/2016/day/21) | Scrambled Letters and Hash             |                                                                                                                              ||
| [Day 22](https://adventofcode.com/2016/day/22) | Grid Computing                         |                                                                                                                              ||
| [Day 23](https://adventofcode.com/2016/day/23) | Safe Cracking                          |                                                                                                                              ||
| [Day 24](https://adventofcode.com/2016/day/24) | Air Duct Spelunking                    |                                                                                                                              ||
| [Day 25](https://adventofcode.com/2016/day/25) | Clock Signal                           |                                                                                                                              ||