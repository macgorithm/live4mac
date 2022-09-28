//
//  main.swift
//  Lv2_소수 찾기
//
//  Created by neuli on 2022/09/27.
//

import Foundation

var result: Set<Int> = []
var number: [String] = []
var visited: [Bool] = []

func solution(_ numbers: String) -> Int {
    
    number = Array(numbers).map { String($0) }
    visited = Array(repeating: false, count: number.count)
    dfs("")
    
    return result.count
}

func dfs(_ num: String) {
    if let intNum = Int(num), isPrime(intNum) {
        print(intNum)
        result.insert(intNum)
    }
    for i in 0..<visited.count where !visited[i] {
        visited[i] = true
        dfs("\(num)\(number[i])")
        visited[i] = false
    }
}

func isPrime(_ num: Int) -> Bool {
    if num == 1 || num == 0 { return false }
    if num == 2 { return true }
    for i in 2..<num where num.isMultiple(of: i) {
        return false
    }
    return true
}

print(solution("011"))
