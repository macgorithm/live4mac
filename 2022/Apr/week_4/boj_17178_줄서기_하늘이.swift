//
//  main.swift
//  17178_줄서기
//
//  Created by neuli on 2022/04/19.
//
//  https://www.acmicpc.net/problem/17178

import Foundation

let N = Int(readLine()!)!
var line: [(String, Int)] = []
var order: [(String, Int)] = []
var stack: [(String, Int)] = []

for _ in 0..<N {
    let input = readLine()!.split(separator: " ")
    for person in input {
        let ticket = person.split(separator: "-")
        line.append((String(ticket[0]), Int(ticket[1])!))
    }
}

order = line.sorted(by: {
    if $0.0 == $1.0 { return $0.1 > $1.1 }
    return $0.0 > $1.0
})

while true {
    if !line.isEmpty && line[0] == order.last! {
        line.removeFirst()
        order.removeLast()
    } else if !stack.isEmpty && stack.last! == order.last! {
        stack.removeLast()
        order.removeLast()
    } else if !line.isEmpty {
        stack.append(line[0])
        line.removeFirst()
    } else {
        print("BAD")
        break
    }
    
    if order.isEmpty {
        print("GOOD")
        break
    }
}
