//
//  main.swift
//  10815_숫자 카드
//
//  Created by neuli on 2022/09/11.
//

import Foundation

let N = Int(readLine()!)!
var cards = readLine()!.components(separatedBy: " ").map { Int($0)! }
let M = Int(readLine()!)!
let input = readLine()!.components(separatedBy: " ").map { Int($0)! }

let count = cards.count
cards.sort()

for num in input {
    print("\(findNum(num))", terminator: " ")
}

func findNum(_ num: Int) -> Int {
    var start = 0
    var end = count - 1
    
    while start <= end {
        let mid = (start + end) / 2
        if num == cards[mid] { return 1 }
        else if num < cards[mid] { end = mid - 1 }
        else if cards[mid] < num { start = mid + 1 }
    }
    
    return 0
}
