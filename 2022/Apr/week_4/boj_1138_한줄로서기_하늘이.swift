//
//  main.swift
//  1138 한 줄로 서기
//
//  Created by neuli on 2022/04/25.
//

import Foundation

let N = Int(readLine()!)!
let leftCount = readLine()!.split(separator: " ").map{ Int($0)! }
var count = Array(repeating: 0, count: N)
var orders = Array(repeating: 0, count: N)

for i in 0..<N {
    count[i] = i
}

for i in 0..<N {
    for position in 0..<N where count[position] == leftCount[i] {
        orders[position] = i + 1
        count[position] = -1
        for cur in (position + 1)..<N where count[cur] != -1 {
            count[cur] -= 1
        }
        break
    }
}

for order in orders {
    print(order, terminator: " ")
}
