//
//  main.swift
//  14889_스타트와 링크
//
//  Created by 하늘이 on 2022/03/10.
//

import Foundation

// input
let N = Int(readLine()!)!

var power = [[Int]](Array(repeating: Array(repeating: 0, count: N+1), count: N+1))

// input
for i in 1...N {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    for j in 1...N {
        power[i][j] = input[j-1]
    }
}

// 변수 선언
let memberCount = N/2
var startPower = 0, linkPower = 0, result = Int.max
var visited = [Bool](Array(repeating: false, count: N+1))

// 조합짜기
func makeTeam(_ start: Int, _ count: Int) {
    if count == memberCount + 1 {
        getDiffPower()
        return
    }
    
    for i in start...N {    // 시간초과의 원인
        if !visited[i] {
            visited[i] = true
            makeTeam(i, count + 1)
            visited[i] = false
        }
    }
}

// 팀의 능력치 차이 구하기
func getDiffPower() {
    startPower = 0
    linkPower = 0
    
    for i in 1...N {
        for j in i...N {
            if visited[i] && visited[j] {
                startPower += power[i][j] + power[j][i]
            }
            else if !visited[i] && !visited[j] {
                linkPower += power[i][j] + power[j][i]
            }
        }
    }
    result = min(result, abs(startPower - linkPower))
}

makeTeam(1, 1)
print(result)
