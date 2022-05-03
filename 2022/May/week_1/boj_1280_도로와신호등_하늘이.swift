//
//  main.swift
//  2980_도로와 신호등
//
//  Created by neuli on 2022/04/27.
//
//  https://www.acmicpc.net/problem/2980

import Foundation

var input = readLine()!.split(separator: " ").map { Int($0)! }

let N = input[0]
let L = input[1]
var trafficLight: [Int : (red: Int, green: Int)] = [:]

for _ in 0..<N {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    trafficLight[input[0]] = (input[1], input[2])
}

var cur = 0, time = 0

while cur < L {
    // trafficLight[cur]의 값이 없다면 신호등이 없으므로 cur, time 1씩 증가
    guard let light = trafficLight[cur] else {
        cur += 1
        time += 1
        continue
    }
    // trafficLight[cur]의 값이 있고
    // 현재 신호등이 빨간 불이라면
    let restTime = time % (light.red + light.green)
    if  restTime < light.red {
        time += light.red - restTime
    } else { // 초록 불이라면
        cur += 1
        time += 1
    }
}

print(time)
