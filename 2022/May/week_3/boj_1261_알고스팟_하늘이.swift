//
//  main.swift
//  1261_알고스팟
//
//  Created by neuli on 2022/05/21.
//

import Foundation

var input = readLine()!.components(separatedBy: .whitespaces).map { Int($0)! }
let M = input[0]
let N = input[1]

var map = Array(repeating: Array(repeating: 0, count: M), count: N)
var breakWallCount = Array(repeating: Array(repeating: Int.max, count: M), count: N)
var q: [(r: Int, c: Int)] = []
let dr = [1, 0, -1, 0]
let dc = [0, 1, 0, -1]

breakWallCount[0][0] = 0
q.append((r: 0, c: 0))

for i in 0..<N {
    let input = Array(readLine()!.map { Int(String($0))! })
    for j in 0..<M {
        map[i][j] = input[j]
    }
}

func isIn(_ r: Int, _ c: Int) -> Bool {
    return 0<=r && r<N && 0<=c && c<M
}

while !q.isEmpty {
    let cur = q.removeFirst()
    for i in 0..<4 {
        let nr = cur.r + dr[i]
        let nc = cur.c + dc[i]
        if isIn(nr, nc) && breakWallCount[cur.r][cur.c] + map[nr][nc] < breakWallCount[nr][nc] {
            breakWallCount[nr][nc] = breakWallCount[cur.r][cur.c] + map[nr][nc]
            q.append((r: nr, c: nc))
        }
    }
}

print(breakWallCount[N-1][M-1])
