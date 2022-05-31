//
//  main.swift
//  Lv2_멀쩡한 사각형
//
//  Created by neuli on 2022/05/31.
//
//  https://programmers.co.kr/learn/courses/30/lessons/62048

import Foundation

func solution(_ w: Int, _ h: Int) -> Int64{
    var answer: Int64 = Int64(w) * Int64(h)
    
    var n1 = max(w, h)
    var n2 = min(w, h)
    
    while true {
        let remain = n1 % n2
        if remain == 0 {
            break
        }
        n1 = max(n2, remain)
        n2 = min(n2, remain)
    }

    return answer - Int64(w + h - n2)
}
