//
//  main.swift
//  16234_인구 이동
//
//  Created by 하늘이 on 2022/03/19.
//

import Foundation

// input
var input = readLine()!.split(separator: " ").map{ Int($0)! }

let N = input[0]
let L = input[1]
let R = input[2]

// 인구수, bfs 방문여부, 결과값
var landPeople = Array(repeating: Array(repeating: 0, count: N), count: N)
var visited = Array(repeating: Array(repeating: false, count: N), count: N)
var movePeopleDay = 0

// input
for i in 0..<N {
    input = readLine()!.split(separator: " ").map{ Int($0)! }
    for j in 0..<N {
        landPeople[i][j] = input[j]
    }
}

let dr = [-1, 1, 0, 0]
let dc = [0, 0, -1, 1]

func isIn(_ r: Int, _ c: Int) -> Bool {
    return 0<=r && r<N && 0<=c && c<N
}

// 두 나라의 인구 차이가 L명 이상, R명 이하
func isOpenBorderLine(_ countryA: (Int, Int), _ countryB: (Int, Int)) -> Bool {
    let diff = abs(landPeople[countryA.0][countryA.1] - landPeople[countryB.0][countryB.1])
    return L <= diff && diff <= R
}

// 인구 이동이 일어날 수 있는지 여부
func isMovePeople() -> Bool {
    var nr = 0, nc = 0
    for i in 0..<N {
        for j in 0..<N {
            for k in 0..<4 {
                nr = i + dr[k]
                nc = j + dc[k]
                if isIn(nr, nc) && isOpenBorderLine((i, j), (nr, nc)) {
                    return true
                }
            }
        }
    }
    return false
}

// 국경선이 아직 안열린 곳에서만 bfs
func openBorderLine(_ startR: Int, _ startC: Int) {
    // queue 인척하는 배열
    var queue: [(Int, Int)] = []
    // 위치, 인구 수 저장
    var union: [(Int, Int)] = []
    
    visited[startR][startC] = true
    queue.append((startR, startC))
    union.append((startR, startC))
    
    while !queue.isEmpty {
        let r = queue.first!.0
        let c = queue.first!.1
        queue.removeFirst()
    
        for i in 0..<4 {
            let nr = r + dr[i]
            let nc = c + dc[i]
        
            if isIn(nr, nc) && !visited[nr][nc] && isOpenBorderLine((r, c), (nr, nc)) {
                visited[nr][nc] = true
                queue.append((nr, nc))
                union.append((nr, nc))
            }
        }
    }
    
    // 각 칸의 인구수
    let unionPeopleCount = union.reduce(0, { $0 + landPeople[$1.0][$1.1] }) / union.count
    // 연합의 인구수 바꾸기
    for country in union {
        landPeople[country.0][country.1] = unionPeopleCount
    }
}

// main

while isMovePeople() {
    visited = Array(repeating: Array(repeating: false, count: N), count: N)
    for i in 0..<N {
        for j in 0..<N {
            if !visited[i][j] {
                openBorderLine(i, j)
            }
        }
    }
    movePeopleDay += 1
}

print(movePeopleDay)
