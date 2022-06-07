//
//  main.swift
//  Lv3_순위
//
//  Created by neuli on 2022/06/07.
//
//  https://programmers.co.kr/learn/courses/30/lessons/49191#

import Foundation

import Foundation

var dict: [Int : [Int]] = [:]
var reversedDict: [Int : [Int]] = [:]
var visited: [Bool] = []

func dfs(_ start: Int, _ info: [Int : [Int]]) {
    var stack: [Int] = []
    stack.append(start)
    
    while !stack.isEmpty {
        let cur = stack.removeLast()
        if visited[cur] { return }
        visited[cur] = true
        if let nexts = info[cur] {
            for next in nexts where !visited[next] {
                stack.append(next)
            }
        }
    }
}

func solution(_ n: Int, _ results: [[Int]]) -> Int {
    var answer = 0
    
    for result in results {
        dict[result[0], default: []].append(result[1])
        reversedDict[result[1], default: []].append(result[0])
    }
    
    for i in 1...n {
        var set: Set<Int> = []
        visited = Array(repeating: false, count: n + 1)
        dfs(i, dict)
        for num in 1...n where !visited[num] {
            set.insert(num)
        }
        
        visited = Array(repeating: false, count: n + 1)
        dfs(i, reversedDict)
        
        for num in set where !visited[num] {
            answer -= 1
            break
        }
        answer += 1
    }
    
    return answer
}
