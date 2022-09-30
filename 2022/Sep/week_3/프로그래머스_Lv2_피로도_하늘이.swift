//
//  main.swift
//  Lv2_피로도
//
//  Created by neuli on 2022/09/21.
//

import Foundation

var visited: [Bool] = []
var result = 0

func solution(_ k: Int, _ dungeons: [[Int]]) -> Int {
    var dungeons = dungeons
    visited = Array(repeating: false, count: dungeons.count)
    permutation(k, 0, &dungeons)
    
    return result
}

func permutation(_ k: Int,
                 _ count: Int,
                 _ dungeons: inout [[Int]]) {
    result = max(result, count)
    if count == dungeons.count { return }
    for i in 0..<dungeons.count where !visited[i] && dungeons[i][0] <= k {
        visited[i] = true
        permutation(k - dungeons[i][1], count + 1, &dungeons)
        visited[i] = false
    }
}
