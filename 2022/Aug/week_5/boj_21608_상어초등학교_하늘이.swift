//
//  main.swift
//  21608_상어 초등학교
//
//  Created by neuli on 2022/08/27.
//

import Foundation

let dr = [0, -1, 0, 1]
let dc = [1, 0, -1, 0]
let score = [0, 1, 10, 100, 1000]

let N = Int(readLine()!)!

// 좌석
var seats = Array(repeating: Array(repeating: 0, count: N + 1), count: N + 1)
// 좋아하는 친구
var likes: [[Int]] = Array(repeating: [], count: N * N + 1)

// 순서대로 좌석 앉히기
for _ in 0..<N*N {
    let input = readLine()!.components(separatedBy: " ").map { Int($0)! }
    for i in 1...4 {
        likes[input[0]].append(input[i])
    }
    setSeat(input[0])
}

// 만족도
var result = 0
for r in 1...N {
    for c in 1...N {
        result += satisfaction(seats[r][c], r, c)
    }
}
print(result)

// MARK: - Functions

func setSeat(_ student: Int) {
    let firstSeats = likePeopleSeats(student)                   // 1. 좋아하는 학생이 가장 많은 칸들
    if firstSeats.count == 1 {
        seats[firstSeats[0].r][firstSeats[0].c] = student
    } else {
        let secondSeats = mostEmptySeats(student, firstSeats)   // 2. 비어있는 인접 칸이 많은 칸들
        if secondSeats.count == 1 {
            seats[secondSeats[0].r][secondSeats[0].c] = student
        } else {
            let lastSeat = getSeat(student, secondSeats)        // 3. r, c 제일 작은 칸
            seats[lastSeat.r][lastSeat.c] = student
        }
    }
}

/// 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸
func likePeopleSeats(_ student: Int) -> [(r: Int, c: Int)] {
    
    var maxCount = 0
    var result: [(Int, Int)] = []
    
    for r in 1...N {
        for c in 1...N where seats[r][c] == 0 {
            let studentLikeCount = likeCount(student, r, c)
            
            if maxCount < studentLikeCount {
                result.removeAll()
                result.append((r, c))
                maxCount = studentLikeCount
            } else if maxCount == studentLikeCount {
                result.append((r, c))
            }
        }
    }
    
    return result
}

/// 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
func mostEmptySeats(_ student: Int,
                    _ likeSeats: [(r: Int, c: Int)]) -> [(r: Int, c: Int)] {
    var result: [(Int, Int)] = []
    var maxEmpty = 0
    for seat in likeSeats {
        let count = emptyCount(student, seat.r, seat.c)
        if maxEmpty < count {
            result.removeAll()
            result.append((seat.r, seat.c))
            maxEmpty = count
        } else if maxEmpty == count {
            result.append((seat.r, seat.c))
        }
    }
    return result
}

/// 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
func getSeat(_ student: Int,
             _ likeSeats: [(r: Int, c: Int)]) -> (r: Int, c: Int) {
    var likeSeats = likeSeats
    likeSeats.sort {
        if $0.r == $1.r {
            return $0.c < $1.c
        }
        return $0.r < $1.r
    }
    return likeSeats[0]
}

/// 인접한 칸에서 좋아하는 학생 수
func likeCount(_ student: Int,
               _ r: Int,
               _ c: Int) -> Int {
    var like = 0
    for i in 0..<4 {
        let nr = r + dr[i]
        let nc = c + dc[i]
        if isIn(nr, nc) && likes[student].contains(seats[nr][nc]) {
            like += 1
        }
    }
    return like
}

/// 인접한 칸에서 빈 칸 수
func emptyCount(_ student: Int,
                _ r: Int,
                _ c: Int) -> Int {
    var count = 0
    for i in 0..<4 {
        let nr = r + dr[i]
        let nc = c + dc[i]
        if isIn(nr, nc) && seats[nr][nc] == 0 {
            count += 1
        }
    }
    return count
}

func isIn(_ r: Int,
          _ c: Int) -> Bool {
    return 1<=r && r<=N && 1<=c && c<=N
}

func satisfaction(_ student: Int, _ r: Int, _ c: Int) -> Int {
    var count = 0
    for i in 0..<4 {
        let nr = r + dr[i]
        let nc = c + dc[i]
        if isIn(nr, nc) && likes[student].contains(seats[nr][nc]) {
            count += 1
        }
    }
    return score[count]
}
