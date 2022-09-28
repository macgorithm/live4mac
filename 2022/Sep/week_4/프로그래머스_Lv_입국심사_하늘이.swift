//
//  main.swift
//  Lv3_입국심사
//
//  Created by neuli on 2022/09/28.
//

import Foundation

func solution(_ n: Int, _ times: [Int]) -> Int64 {
    
    let times: [Int64] = times.sorted(by: <).map { Int64($0) }
    var start: Int64 = 0
    var end: Int64 = times.last! * Int64(n)
    
    while start < end {
        let mid = (start + end) / Int64(2)
        var count: Int64 = 0
        times.forEach {
            count += mid / $0
        }
        if n <= count {
            end = mid
        } else {
            start = mid + Int64(1)
        }
    }
    
    return start
}

//  https://school.programmers.co.kr/questions/21374
