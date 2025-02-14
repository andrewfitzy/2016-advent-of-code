![build_and_test badge](https://github.com/andrewfitzy/2016-advent-of-code/actions/workflows/build_and_test.yml/badge.svg)
# 2016-advent-of-code

This repo contains the solutions for my path of [Advent of Code 2016](https://adventofcode.com/2016). I complete AoC to get familiar with a technology, its build tools and testing tools, it's kind of a mini-production type workflow I follow.

In this year I chose to use the following tools:
- [Kotlin v1.9.20](https://kotlinlang.org/docs/whatsnew1920.html). Language for this year's AOC.
- [Gradle v8.1.1](https://docs.gradle.org/8.1.1/release-notes.html). Build tool for Kotlin projects.
- [Spotless v6.25.0](https://github.com/diffplug/spotless/releases/tag/gradle%2F6.25.0). Also using the Ktlint formatting configuration [v1.1.1](https://github.com/pinterest/ktlint/releases/tag/1.1.1).
- [Detekt v1.23.3](https://detekt.dev/docs/intro). Code analysis tool which is useful for finding bugs.
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
| [Day 04](https://adventofcode.com/2016/day/4)  | Security Through Obscurity             | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day04/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day04/Task02.kt) |
| [Day 05](https://adventofcode.com/2016/day/5)  | How About a Nice Game of Chess?        | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day05/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day05/Task02.kt) |
| [Day 06](https://adventofcode.com/2016/day/6)  | Signals and Noise                      | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day06/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day06/Task02.kt) |
| [Day 07](https://adventofcode.com/2016/day/7)  | Internet Protocol Version 7            | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day07/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day07/Task02.kt) |
| [Day 08](https://adventofcode.com/2016/day/8)  | Two-Factor Authentication              | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day08/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day08/Task02.kt) |
| [Day 09](https://adventofcode.com/2016/day/9)  | Explosives in Cyberspace               | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day09/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day09/Task02.kt) |
| [Day 10](https://adventofcode.com/2016/day/10) | Balance Bots                           | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day10/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day10/Task02.kt) | 
| [Day 11](https://adventofcode.com/2016/day/11) | Radioisotope Thermoelectric Generators | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day11/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day11/Task02.kt) | 
| [Day 12](https://adventofcode.com/2016/day/12) | Leonardo's Monorail                    | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day12/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day12/Task02.kt) |      
| [Day 13](https://adventofcode.com/2016/day/13) | A Maze of Twisty Little Cubicles       | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day13/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day13/Task02.kt) |
| [Day 14](https://adventofcode.com/2016/day/14) | One-Time Pad                           | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day14/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day14/Task02.kt) |
| [Day 15](https://adventofcode.com/2016/day/15) | Timing is Everything                   | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day15/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day15/Task02.kt) |
| [Day 16](https://adventofcode.com/2016/day/16) | Dragon Checksum                        | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day16/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day16/Task02.kt) |
| [Day 17](https://adventofcode.com/2016/day/17) | Two Steps Forward                      | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day17/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day17/Task02.kt) |
| [Day 18](https://adventofcode.com/2016/day/18) | Like a Rogue                           | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day18/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day18/Task02.kt) |
| [Day 19](https://adventofcode.com/2016/day/19) | An Elephant Named Joseph               | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day19/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day19/Task02.kt) |
| [Day 20](https://adventofcode.com/2016/day/20) | Firewall Rules                         | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day20/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day20/Task02.kt) |
| [Day 21](https://adventofcode.com/2016/day/21) | Scrambled Letters and Hash             | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day21/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day21/Task02.kt) |
| [Day 22](https://adventofcode.com/2016/day/22) | Grid Computing                         | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day22/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day22/Task02.kt) |
| [Day 23](https://adventofcode.com/2016/day/23) | Safe Cracking                          | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day23/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day23/Task02.kt) |
| [Day 24](https://adventofcode.com/2016/day/24) | Air Duct Spelunking                    | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day24/Task01.kt) | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day24/Task02.kt) |
| [Day 25](https://adventofcode.com/2016/day/25) | Clock Signal                           | [🌟](https://github.com/andrewfitzy/2016-advent-of-code/blob/main/app/src/main/kotlin/io/github/andrewfitzy/day25/Task01.kt) |                                                              🌟                                                              |