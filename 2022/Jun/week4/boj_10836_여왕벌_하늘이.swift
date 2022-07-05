//
//  main.swift
//  10836_여왕벌
//
//  Created by neuli on 2022/06/28.
//
//  https://www.acmicpc.net/problem/10836

import Foundation

var input = readLine()!.split(separator: " ").map{ Int($0)! }

let M = input[0]
let N = input[1] // 날짜 수
var grow = Array(repeating: Array(repeating: 0, count: M), count: M)

for _ in 0..<N {
    
    input = readLine()!.split(separator: " ").map{ Int($0)! }
    
    // 자라는 정도
    for i in 1...(2 * M - 1) {
        var growing = 0
        if i <= input[0] {
            growing = 0
        } else if i <= input[0] + input[1] {
            growing = 1
        } else {
            growing = 2
        }
        if i < M {
            grow[M - i][0] += growing
        } else {
            grow[0][i - M] += growing
        }
    }
}

for i in 0..<M {
    for j in 0..<M {
        if i == 0 || j == 0 {
            print(1 + grow[i][j], terminator: " ")
        } else {
            grow[i][j] = grow[i-1][j]
            print(1 + grow[i][j], terminator: " ")
        }
    }
    print()
}
