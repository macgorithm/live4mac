//
//  main.swift
//  1003_피보나치함수
//
//  Created by neuli on 2022/06/22.
//

import Foundation

var dp0: [Int] = Array(repeating: 0, count: 41)
var dp1: [Int] = Array(repeating: 0, count: 41)
dp0[0] = 1
dp1[1] = 1

for i in 2...40 {
    dp0[i] = dp0[i-1] + dp0[i-2]
    dp1[i] = dp1[i-1] + dp1[i-2]
}

let T = Int(readLine()!)!

for _ in 0..<T {
    let N = Int(readLine()!)!
    print("\(dp0[N]) \(dp1[N])")
}
