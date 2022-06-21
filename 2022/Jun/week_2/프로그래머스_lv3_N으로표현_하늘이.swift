//
//  main.swift
//  Lv3_N으로 표현
//
//  Created by neuli on 2022/06/15.
//

import Foundation

func solution(_ N: Int, _ number: Int) -> Int {
    
    if N == number { return 1 }
    
    var sets: [Set<Int>] = []
    
    for i in 1...9 {
        var set: Set<Int> = []
        var num = ""
        var count = 0
        while count < i {
            num += String(N)
            count += 1
        }
        set.insert(Int(num)!)
        sets.append(set)
    }
    
    for i in 1..<8 {
        for j in 0..<i {
            for op1 in sets[j] {
                for op2 in sets[i - j - 1] {
                    sets[i].insert(op1 + op2)
                    sets[i].insert(op1 - op2)
                    sets[i].insert(op1 * op2)
                    if op2 != 0 {
                        sets[i].insert(op1 / op2)
                    }
                }
            }
        }
        if sets[i].contains(number) {
            return i + 1
        }
    }
    
    return -1
}
