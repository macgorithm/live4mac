//
//  main.swift
//  2779_블라인드
//
//  Created by 하늘이 on 2022/03/05.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int($0)! }
let M: Int = input[0]
let N: Int = input[1]

// 블라인드 상태를 딕셔너리 형태로 저장
var blindState: Dictionary<Int, Int> = [0 : 0, 1 : 0, 2 : 0, 3 : 0, 4 : 0]

// 창문 한 줄을 큰 틀로 잡아서 for 문
for _ in 0..<M {
    readLine()!
    // 블라인드가 쳐져 있다면 값을 더해서 몇줄의 블라인드가 쳐져 있는지 각 창문을 배열로 나타냄
    var windows: [Int] = Array(repeating: 0, count: N)
    
    for _ in 0..<4 {
        let input = readLine()!
        
        // 각 창문의 첫번째 상태만 * 인지 확인
        for k in 0..<N {
            let idx = input.index(input.startIndex, offsetBy: 5 * k + 1)
            if input[idx] == "*" {
                windows[k] += 1
            }
        }
    }
    
    // blindState dictionary 에 창문의 상태를 저장
    for window in windows {
        blindState[window]! += 1
    }
}

readLine()!

for i in 0...4 {
    print(blindState[i]!, terminator: " ")
}
