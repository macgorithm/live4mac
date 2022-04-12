//
//  main.swift
//  11265_끝나지 않는 파티
//
//  Created by neuli on 2022/04/06.
//
//  https://www.acmicpc.net/problem/11265

import Foundation

let MAX = 1_000_000_000

var input = readLine()!.split(separator: " ").map { Int($0)! }

let N = input[0]
let M = input[1]

var edges = Array(repeating: Array(repeating: 0, count: N + 1), count: N + 1)

for i in 1...N {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    for j in 1...N {
        edges[i][j] = input[j - 1]
    }
}

for k in 1...N {
    for i in 1...N {
        for j in 1...N {
            edges[i][j] = min(edges[i][j], edges[i][k] + edges[k][j])
        }
    }
}

for _ in 1...M {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    let A = input[0]
    let B = input[1]
    let C = input[2]
    
    print(edges[A][B] <= C ? "Enjoy other party" : "Stay here")
}
