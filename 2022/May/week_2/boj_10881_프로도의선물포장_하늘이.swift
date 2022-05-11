//
//  main.swift
//  10881_프로도의 선물 포장
//
//  Created by neuli on 2022/05/08.
//
//  https://www.acmicpc.net/problem/10881

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    var result = Int.max
    var gifts: [(Int, Int)] = []
    for _ in 0..<3 {
        let input = readLine()!.split(separator: " ").map { Int($0)! }
        gifts.append((input[0], input[1]))
    }
    result = min(result, box(gifts))
    print(result)
}

func box(_ gifts: [(Int, Int)]) -> Int {
    
    var result = Int.max
    
    for i in 0..<2 {
        for j in 0..<2 {
            for k in 0..<2 {
                var width = 0, height = 0
                width = i == 0 ? width + gifts[0].0 : width + gifts[0].1
                width = j == 0 ? width + gifts[1].0 : width + gifts[1].1
                width = k == 0 ? width + gifts[2].0 : width + gifts[2].1
                height = i == 0 ? max(height, gifts[0].1) : max(height, gifts[0].0)
                height = j == 0 ? max(height, gifts[1].1) : max(height, gifts[1].0)
                height = k == 0 ? max(height, gifts[2].1) : max(height, gifts[2].0)
                result = min(result, width * height)
                
                let firstWidth = i == 0 ? gifts[0].0 : gifts[0].1
                let secondWidth = j == 0 ? gifts[1].0 : gifts[1].1
                let thirsWidth = k == 0 ? gifts[2].0 : gifts[2].1
                let firstHeight = i == 0 ? gifts[0].1 : gifts[0].0
                let secondHeight = j == 0 ? gifts[1].1 : gifts[1].0
                let thirdHeight = k == 0 ? gifts[2].1 : gifts[2].0
                width = max(firstWidth + secondWidth, thirsWidth)
                height = max(firstHeight, secondHeight) + thirdHeight
                result = min(result, width * height)
                width = max(firstWidth, secondWidth + thirsWidth)
                height = firstHeight + max(secondHeight, thirdHeight)
                result = min(result, width * height)
                width = max(firstWidth + thirsWidth, secondWidth)
                height = max(firstHeight, thirdHeight) + secondHeight
                result = min(result, width * height)
            }
        }
    }
    
    return result
}
