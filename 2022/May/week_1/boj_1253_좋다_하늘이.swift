//
//  main.swift
//  1253 좋다
//
//  Created by neuli on 2022/04/27.
//
//  https://www.acmicpc.net/problem/1253

import Foundation

let N = Int(readLine()!)!
let A: [Int64] = readLine()!.split(separator: " ").map { Int64($0)! }
var dict: [Int64 : Int] = [:]
var set: Set<Int64> = []
var count = 0

for num in A {
    dict[num, default: 0] += 1
}

var aSet = Set(A)

for (index1, num1) in A.enumerated() {
    for (index2, num2) in A.enumerated() where index1 != index2 && (num1 + num2) <= 1_000_000_000 && aSet.contains(num1 + num2) {
        set.insert(num1 + num2)
    }
}

for num in set {
    count += dict[num]!
}

print(count)
