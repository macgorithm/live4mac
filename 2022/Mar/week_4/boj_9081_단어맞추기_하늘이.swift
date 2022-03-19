//
//  main.swift
//  9081_단어 맞추기
//
//  Created by 하늘이 on 2022/03/16.
//

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    
    // next-permutation
    // 단어를 받고 reverse -> 앞에서부터 찾으려고
    var word = Array(readLine()!.reversed())
    // next-permutation 에서 word[i-1] < word[[i] 가 되는 가장 큰 값
    var top = -1
    
    // top 값 찾기
    for index in 0..<word.count {
        // 만약 찾는 값 없이 맨 앞에 도달했다면 이미 word가 마지막 순열 값
        if index == word.count - 1 {
            break
        }
        
        if word[index + 1] < word[index] {
            top = index
            break
        }
    }
    
    // 처음 word 값 출력
    if top == -1 {
        print(word.reversed().reduce("", { String($0) + String($1) }))
        continue
    }
    
    // top 값 뒤에 있는 (revere라서 앞에 있는) 값 중 top + 1의 값보다 큰 값 찾기
    for index in 0..<word.count {
        // index가 top보다 커질 경우를 고려할 필요가 없다.
        if word[top + 1] < word[index] {
            word.swapAt(top + 1, index)
            break
        }
    }
    
    // 원래 순서로
    word = word.reversed()
    
    top = word.count - top - 1
    let frontWord: String = word[..<top].reduce("", {String($0) + String($1)})
    // top 뒤의 값은 오름차순으로 정렬
    let backWord: String = word[top...].sorted(by: <).reduce("", {String($0) + String($1)})
    print(frontWord + backWord)
}


/// 참조코드
//import Foundation
//
//let n = Int(readLine()!)!
//
//for _ in 0..<n {
//    var word = readLine()!.map{String($0)}
//    if nextPermutation(&word) {print(word.joined())}
//    else{ print(word.joined()) }
//}
//
//func nextPermutation(_ word:inout [String]) -> Bool{
//    var i = word.count - 1
//    while i > 0 && word[i-1] >= word[i] { i -= 1 }
//    if i == 0 { return false}
//
//    var j = word.count - 1
//    while word[i-1] >= word[j] { j -= 1 }
//
//    var temp = word[i-1]
//    word[i-1] = word[j]
//    word[j] = temp
//
//    word = word[..<i] + word[i...].reversed()
//
//    return true
//}
