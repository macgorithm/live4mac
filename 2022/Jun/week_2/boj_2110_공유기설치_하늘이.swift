//
//  main.swift
//  2110_공유기 설치
//
//  Created by neuli on 2022/06/14.
//
//  https://www.acmicpc.net/problem/2110

import Foundation

let input = readLine()!.split(separator: " ").map { Int($0)! }
let N = input[0]
let C = input[1]
var result = 0
var homes: [Int] = []

for _ in 0..<N {
    let input = Int(readLine()!)!
    homes.append(input)
}

homes.sort()

var start = 1, end = homes.last! - homes.first!

while start < end {
    let mid = (start + end) / 2
    
    var count = 1, beforeHome = homes[0]
    for i in 1..<N where mid < (homes[i] - beforeHome) {
        count += 1
        beforeHome = homes[i]
    }
    if C <= count {
        start = mid + 1
    } else {
        end = mid
    }
}

print(end)
