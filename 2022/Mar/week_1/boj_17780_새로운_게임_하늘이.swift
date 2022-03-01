//
//  main.swift
//  17780_새로운 게임
//
//  Created by 하늘이 on 2022/03/01.
//

import Foundation

var turn: Int = 0

struct Pos {
    var r, c: Int
    
    init(_ r: Int, _ c: Int) {
        self.r = r
        self.c = c
    }
}

struct Knight {
    let num: Int
    var pos: Pos
    var dir: Int
    
    init(_ num: Int, _ pos: Pos, _ dir: Int) {
        self.num = num
        self.pos = pos
        self.dir = dir
    }
}

let dr = [0, 0, 0, -1, 1]
let dc = [0, 1, -1, 0, 0]

func changedDirection(_ dir: Int) -> Int {
    if dir == 1 { return 2 }
    if dir == 2 { return 1 }
    if dir == 3 { return 4 }
    if dir == 4 { return 3 }
    return -1
}

// input
var intArr = readLine()!.split(separator: " ").map{ Int($0)! }

let N = intArr[0]
let K = intArr[1]

var chessStatus: [[Int]] = Array(repeating: Array(repeating: 0, count: N+1), count: N+1)
var knights: [Knight] = Array(repeating: Knight(0, Pos(-1, -1), 0), count: 1)
var chessKnights: [[[Int]]] = Array(repeating: Array(repeating:[] , count: N+1), count: N+1)

// input
for i in 1...N {
    intArr = readLine()!.split(separator: " ").map{ Int($0)! }
    for j in 1...N {
        chessStatus[i][j] = intArr[j-1]
    }
}

// input
for i in 1...K {
    intArr = readLine()!.split{ $0 == " " }.map{ Int($0)! }
    knights.append(Knight(i, Pos(intArr[0], intArr[1]), intArr[2]))
    chessKnights[intArr[0]][intArr[1]].append(i)
}

// 이동할 곳에 넣고 모두 삭제
func move(_ cr: Int, _ cc: Int, _ nr: Int, _ nc: Int) {
    chessKnights[cr][cc].forEach { knight in
        chessKnights[nr][nc].append(knight)
        knights[knight].pos.r = nr
        knights[knight].pos.c = nc
    }
    chessKnights[cr][cc].removeAll()
}

// 범위
func isIn(_ r: Int, _ c: Int) -> Bool {
    return 0<r && r<=N && 0<c && c<=N
}

while true {
    turn += 1
    if (turn >= 1000) {
        print(-1)
        exit(0)
    }
    
    for i in 1...K {
        let cr = knights[i].pos.r
        let cc = knights[i].pos.c
        var dir = knights[i].dir
        var nr = cr + dr[dir]
        var nc = cc + dc[dir]
        
        if (chessKnights[cr][cc].first != i) { // 차례 pass
            continue
        }
        
        if (!isIn(nr, nc) || chessStatus[nr][nc] == 2) { // 벗어나거나 파란색인 경우
            dir = changedDirection(dir)
            knights[i].dir = dir
            nr = cr + dr[dir]
            nc = cc + dc[dir]
            
            if (!isIn(nr, nc) || chessStatus[nr][nc] == 2) { // 벗어나거나 파란색인 경우
                continue
            }
            if (chessStatus[nr][nc] == 1) { // 빨간색일 경우
                chessKnights[cr][cc].reverse()
            }
        }
        else if chessStatus[nr][nc] == 1 {  // 빨간색일 경우 순서를 반대로 바꾼 후 넣고 모두 삭제
            chessKnights[cr][cc].reverse()
        }
        move(cr, cc, nr, nc)
        
        if (chessKnights[nr][nc].count >= 4) {
            print(turn)
            exit(0)
        }
    }
}
