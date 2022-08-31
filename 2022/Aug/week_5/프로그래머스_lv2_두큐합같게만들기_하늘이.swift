//
//  main.swift
//  Lv2_두 큐 합 같게 만들기
//
//  Created by neuli on 2022/08/27.
//

import Foundation

func solution(_ queue1: [Int], _ queue2: [Int]) -> Int {
    
    var q = queue1.map { Int64($0) }
    var q2 = queue2.map { Int64($0) }
    q.append(contentsOf: queue2.map { Int64($0) })
    q2.append(contentsOf: queue1.map { Int64($0) })
    
    let sum = q.reduce(0, +) / 2
    let qCount = q.count
    let qStart = 0, qEnd = queue1.count - 1
    var start = 0, end = 0
    var result = -1
    
    var startToEndSum = q[0]
    
    while start <= end && start < qCount && end < qCount {
        if startToEndSum == sum {
            result = start + abs(end - qEnd)
            break
        } else if startToEndSum < sum {
            end += 1
            if end < qCount { startToEndSum += q[end] }
        } else {
            startToEndSum -= q[start]
            start += 1
        }
    }
    
    start = 0
    end = 0
    startToEndSum = q2[0]
    
    while start <= end && start < qCount && end < qCount {
        if startToEndSum == sum {
            result = max(result, start + abs(end - qEnd))
            break
        } else if startToEndSum < sum {
            end += 1
            if end < qCount { startToEndSum += q2[end] }
        } else {
            startToEndSum -= q2[start]
            start += 1
        }
    }
    
    return result != -1 ? result : -1
}
