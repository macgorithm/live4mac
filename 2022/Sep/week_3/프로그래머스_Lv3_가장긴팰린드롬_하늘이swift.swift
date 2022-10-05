//
//  main.swift
//  Lv3_가장 긴 팰린드롬
//
//  Created by neuli on 2022/09/18.
//

import Foundation

func solution(_ s: String) -> Int {
    
    let s = Array(s).map { String($0) }
    let count = s.count
    var palindrome = Array(repeating: Array(repeating: 0, count: count + 1), count: count + 1)
    var result = 0
    
    for j in 1...count {
        for i in 1...j {
            if i == j {                         // 1. 같을 경우 팰린드롬 길이는 1
                palindrome[i][j] = 1
            } else if i + 1 == j {              // 2. ab, cd 같은 경우 같으면 길이 2
                palindrome[i][j] = s[i-1] == s[j-1] ? 2 : 0
            } else {                            // 3. abcde 같은 경우 bcd의 길이 확인, a e 같은지 확인
                if palindrome[i+1][j-1] == 0 {
                    palindrome[i][j] = 0
                } else if s[i-1] == s[j-1] {
                    palindrome[i][j] = palindrome[i+1][j-1] + 2
                }
            }
            result = max(result, palindrome[i][j])
        }
    }
    return result
}
