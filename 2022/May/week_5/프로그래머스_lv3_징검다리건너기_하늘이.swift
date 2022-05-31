//
//  main.swift
//  LV3_징검다리 건너기
//
//  Created by neuli on 2022/05/31.
//
//  https://programmers.co.kr/learn/courses/30/lessons/64062#qna

import Foundation

func solution(_ stones: [Int], _ k: Int) -> Int {
    
    // 친구수를 이분탐색..
    var start = 1, end = 200_000_000, mid = 0
    var result = 0
    while start <= end {
        mid = (start + end) / 2
        if crossBridge(stones, k, mid) {
            start = mid + 1
            result = max(result, mid)
        } else {
            end = mid - 1
        }
    }
    
    return result
}

func crossBridge(_ stones: [Int], _ k: Int, _ count: Int) -> Bool {
    var jump = 0
    for stone in stones {
        if stone - count < 0 {
            jump += 1
        } else {
            jump = 0
        }
        if k == jump {
            return false
        }
    }
    return true
}
