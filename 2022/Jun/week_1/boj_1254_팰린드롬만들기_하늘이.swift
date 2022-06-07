//
//  main.swift
//  1254_팰린드롬 만들기
//
//  Created by neuli on 2022/06/05.
//

import Foundation

let S = readLine()!

if S.count == 1 || isPalindrome(Array(S).map { String($0) }) {
    print(S.count)
} else {
    for i in 0...(S.count - 1) {
        var arr = Array(S).map { String($0) }
        let add = arr[0...i].reversed()
        arr.append(contentsOf: add)
        if isPalindrome(arr) {
            print(arr.count)
            break
        }
    }
}

func isPalindrome(_ s: [String]) -> Bool {
    for i in 0...(s.count/2 - 1) where s[i] != s[s.count - 1 - i] {
        return false
    }
    return true
}
