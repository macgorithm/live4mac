//
//  main.swift
//  17219_비밀번호 찾기
//
//  Created by neuli on 2022/04/12.
//

import Foundation

let input = readLine()!.split(separator: " ").map { Int($0)! }

let N = input[0]
let M = input[1]

var dict: Dictionary<String, String> = [:]

for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map { String($0) }
    dict[input[0]] = input[1]
}

for _ in 0..<M {
    let input = readLine()!
    print(dict[input]!)
}
