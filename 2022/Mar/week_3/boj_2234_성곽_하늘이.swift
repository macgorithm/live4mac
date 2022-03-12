//
//  main.swift
//  2234_성곽
//
//  Created by 하늘이 on 2022/03/08.
//

import Foundation

// input: M, N
var input = readLine()!.split(separator: " ").map{ Int($0)! }
let N = input[0]
let M = input[1]

// 위치에 대한 정보
struct wall {
    var r: Int = 0
    var c: Int = 0
    var east: Bool = false
    var west: Bool = false
    var south: Bool = false
    var north: Bool = false
    var roomNum: Int = -1
    
    // 2로 나눠서 벽이 있는지 확인 후에 벽 설정
    init(_ r: Int, _ c: Int, _ info: Int) {
        self.r = r
        self.c = c
        
        var num = info, count = 0
        if info == 0 {
            return
        }
        while count < 4 {
            if num == 1 {
                setDirection(count, 1)
                break
            }
            setDirection(count, num % 2)
            num = num / 2
            count += 1
        }
    }
    
    mutating func setDirection(_ count: Int, _ val: Int) {
        let isWall = val == 1 ? true : false
        switch count {
        case 0: west = isWall
        case 1: north = isWall
        case 2: east = isWall
        case 3: south = isWall
        default: break
        }
    }
    
    // 벽이 있는지 확인
    func isWall(_ direction: Int) -> Bool {
        switch direction {
        case 0: return west
        case 1: return north
        case 2: return east
        case 3: return south
        default: break
        }
        return false
    }
}

// MARK: - 변수
// 성벽
var walls = [[wall]](Array(repeating: Array(repeating: wall(0, 0, 0), count: N), count: M))
// 탐색을 위한 visited 변수
var visited = [[Bool]](Array(repeating: Array(repeating: false, count: N), count: M))
// 방의 갯수, 넓은 방의 넓이, 벽 제거 후 넓은 방의 넓이
var roomCount = 0, largeArea = 0, largeAreaWithReomveWall = 0

// 방의 넓이 저장 roomCount로
var roomArea = [Int](Array(repeating: 0, count: N*M))

// west, north, east, south
let dr = [0, -1, 0, 1]
let dc = [-1, 0, 1, 0]


// input
for i in 0..<M {
    input = readLine()!.split(separator: " ").map{ Int($0)! }
    for j in 0..<N {
        walls[i][j] = wall(i, j, input[j])
    }
}

// MARK: - 함수
// 범위
func isIn(_ r: Int, _ c: Int) -> Bool {
    return 0<=r && r<M && 0<=c && c<N
}

// 탐색
func bfs(_ startR: Int, _ startC: Int) {
    var area = 0, nr = 0, nc = 0
    // queue라고 생각
    var queue = [wall]()
    
    queue.append(walls[startR][startC])
    visited[startR][startC] = true
    
    while !queue.isEmpty {
        let curWall = queue.first!
        walls[curWall.r][curWall.c].roomNum = roomCount
        area += 1
        queue.removeFirst()
        
        for i in 0..<4 {
            nr = curWall.r + dr[i]
            nc = curWall.c + dc[i]
            if isIn(nr, nc) && !visited[nr][nc] && !curWall.isWall(i) {
                visited[nr][nc] = true
                queue.append(walls[nr][nc])
            }
        }
    }
    roomArea[roomCount] = area
    largeArea = max(area, largeArea)
}

func getLargeAreaWithRemoveWall() {
    var nr = 0, nc = 0
    for i in 0..<M {
        for j in 0..<N {
            for k in 0..<3 {
                nr = walls[i][j].r + dr[k]
                nc = walls[i][j].c + dc[k]
                if isIn(nr, nc) && walls[i][j].roomNum != walls[nr][nc].roomNum {
                    largeAreaWithReomveWall = max(largeAreaWithReomveWall,
                                                  roomArea[walls[i][j].roomNum] +
                                                  roomArea[walls[nr][nc].roomNum])
                }
            }
        }
    }
}

// main
for i in 0..<M {
    for j in 0..<N {
        if !visited[i][j] {
            bfs(i, j)
            roomCount += 1
            
        }
    }
}

getLargeAreaWithRemoveWall()

print(roomCount)
print(largeArea)
print(largeAreaWithReomveWall)
