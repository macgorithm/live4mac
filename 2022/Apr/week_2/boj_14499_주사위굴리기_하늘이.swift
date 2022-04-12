//
//  main.swift
//  14499_주사위 굴리기
//
//  Created by neuli on 2022/04/07.
//

import Foundation

var dice = Array(repeating: 0, count: 7)
var input = readLine()!.split(separator: " ").map { Int($0)! }

let N = input[0]
let M = input[1]
var x = input[2]
var y = input[3]
let K = input[4]
var curDice = 5

let dx = [0, 0, 0, -1, 1], dy = [0, 1, -1, 0, 0]

var map = Array(repeating: Array(repeating: 0, count: M), count: N)

for i in 0..<N {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    for j in 0..<M {
        map[i][j] = input[j]
    }
}

input = readLine()!.split(separator: " ").map { Int($0)! }

func isIn(_ cx: Int, _ cy: Int) -> Bool {
    return 0<=cx && cx<N && 0<=cy && cy<M
}

func roll(_ command: Int) {
    let d1 = dice[1], d2 = dice[2], d3 = dice[3], d4 = dice[4], d5 = dice[5], d6 = dice[6]
    switch command {
    case 1:
        dice[1] = d4
        dice[4] = d6
        dice[6] = d3
        dice[3] = d1
    case 2:
        dice[4] = d1
        dice[6] = d4
        dice[3] = d6
        dice[1] = d3
    case 3:
        dice[1] = d5
        dice[2] = d1
        dice[6] = d2
        dice[5] = d6
    case 4:
        dice[5] = d1
        dice[1] = d2
        dice[2] = d6
        dice[6] = d5
    default:
        break
    }
}

func move(_ command: Int) {
    if isIn(x + dx[command], y + dy[command]) {
        x += dx[command]
        y += dy[command]
    } else {
        return
    }
    
    roll(command)
    
    if map[x][y] == 0 {
        map[x][y] = dice[6]
    } else {
        dice[6] = map[x][y]
        map[x][y] = 0
    }
    
    print(dice[1])
}

for i in 0..<K {
    move(input[i])
}
